package cn.com.sky.setget;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigUtil {
    protected static Log logger = LogFactory.getLog(ConfigUtil.class);

    public static boolean isSpecificSymbol(String prop) {
        return (prop.endsWith("-")) || (prop.endsWith("+")) || (prop.endsWith("^"));
    }

    public static Object getValue(Object obj, String fieldName) throws Exception {
        String pk = fieldName;
        Object value = null;
        if (isSpecificSymbol(fieldName))
            pk = fieldName.substring(0, fieldName.length() - 1);
        try {
            Method getMethod = getInnerMethod(MethodTypeEnum.GET, pk, obj.getClass());
            value = getMethod.invoke(obj, null);
        } catch (Exception e) {
            throw new RuntimeException("ConfigUtil getValue error ,fieldName = " + fieldName + " , class = " + obj.getClass().getCanonicalName());
        }

        return value;
    }

    public static Method getInnerMethod(MethodTypeEnum mtype, String key, Class clazz) throws SecurityException, NoSuchMethodException {
        String methodNameBody = key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase(mtype.name() + methodNameBody))
                return method;
            if ((mtype == MethodTypeEnum.GET) && (method.getName().equalsIgnoreCase("is" + methodNameBody))) {
                return method;
            }
        }
        return null;
    }

    public static boolean isBoolean(Class returnType, String value) {
        return ("java.lang.Object".equals(returnType.getName())) && (StringUtils.isNotBlank(value)) && (("true".equals(value)) || ("false".equals(value)));
    }

    public static boolean isInteger(Class returnType, String value) {
        if (("java.lang.Object".equals(returnType.getName())) && (StringUtils.isNotBlank(value)) && (value.trim().length() < 10) && (!value.contains("."))) {
            Pattern pattern = Pattern.compile("\\d");
            return pattern.matcher(value.trim()).matches();
        }

        return false;
    }

    public static boolean isLong(Class returnType, String value) {
        if (("java.lang.Object".equals(returnType.getName())) && (StringUtils.isNotBlank(value)) && (!value.contains("."))) {
            Pattern pattern = Pattern.compile("\\d");
            return pattern.matcher(value.trim()).matches();
        }
        return false;
    }

    public static boolean isDouble(Class returnType, String value) {
        if (("java.lang.Object".equals(returnType.getName())) && (StringUtils.isNotBlank(value))) {
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)");
            return pattern.matcher(value.trim()).matches();
        }
        return false;
    }

    public static Object transBasicValue(Class returnType, String value) throws Exception {
        if (String.class.isAssignableFrom(returnType))
            return value;
        if ((Byte.TYPE.isAssignableFrom(returnType)) || (Byte.class.isAssignableFrom(returnType)))
            return Byte.valueOf(value);
        if ((Short.TYPE.isAssignableFrom(returnType)) || (Short.class.isAssignableFrom(returnType)))
            return Short.valueOf(value);
        if ((Integer.TYPE.isAssignableFrom(returnType)) || (Integer.class.isAssignableFrom(returnType)) || (isInteger(returnType, value))) {
            return Integer.valueOf(value);
        }
        if ((Long.TYPE.isAssignableFrom(returnType)) || (Long.class.isAssignableFrom(returnType)) || (isLong(returnType, value))) {
            return Long.valueOf(value);
        }
        if ((Double.TYPE.isAssignableFrom(returnType)) || (Double.class.isAssignableFrom(returnType)) || (isDouble(returnType, value))) {
            return Double.valueOf(value);
        }
        if ((Float.TYPE.isAssignableFrom(returnType)) || (Float.class.isAssignableFrom(returnType))) {
            return Float.valueOf(value);
        }
        if ((Boolean.TYPE.isAssignableFrom(returnType)) || (Boolean.class.isAssignableFrom(returnType)) || (isBoolean(returnType, value))) {
            return Boolean.valueOf(value);
        }
        if ((Character.TYPE.isAssignableFrom(returnType)) || (Character.class.isAssignableFrom(returnType))) {
            if (StringUtils.isNotBlank(value))
                return Character.valueOf(value.trim().charAt(0));
        } else if (Class.class.isAssignableFrom(returnType)) {
            if (StringUtils.isNotBlank(value))
                return Class.forName(value);
        } else {
            logger.warn("ConfigUtil  transBasicValue can't find suitable type to handle the value ,use default String type, returnType = " + returnType.getCanonicalName() + " , value = " + value);
        }

        return value;
    }

    public static Map analyzeString2Map(Class rType, Type type, String value) throws Exception {
        Map map = null;

        if ((!rType.isInterface()) && (!Modifier.isAbstract(rType.getModifiers())) && (!rType.isEnum()))
            map = (Map) rType.newInstance();
        else {
            map = new HashMap();
        }
        Class mapKey = String.class;
        Class mapValue = Object.class;
        if ((type instanceof ParameterizedType)) {
            ParameterizedType pType = (ParameterizedType) type;
            mapKey = (Class) pType.getActualTypeArguments()[0];
            mapValue = (Class) pType.getActualTypeArguments()[1];
        }

        String[] kvs = value.split(",");
        if (kvs != null) {
            for (String kv : kvs) {
                String[] kvArray = kv.split("=", -1);
                if ((kvArray != null) && (kvArray.length >= 2)) {
                    String k = null;
                    String v = null;
                    if (kvArray.length == 2) {
                        k = kvArray[0].trim();
                        v = kvArray[1].trim();
                    } else if (kvArray.length > 2) {
                        k = kvArray[0].trim();
                        v = kv.substring(kv.indexOf("=") + 1);
                    }
                    Object mv = transBasicValue(mapValue, v);
                    if ((mv == null) && (Hashtable.class.isAssignableFrom(rType))) {
                        logger.warn("rType = " + rType + "(hashtable) can't  put a null value");
                    } else
                        map.put(k, mv);
                }
            }
        }
        return map;
    }

    public static Object constructArray(Class returnType, String[] values) throws Exception {
        if (String.class.isAssignableFrom(returnType)) {
            String[] arrstrs = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((String) transBasicValue(returnType, values[i]));
            }
            return arrstrs;
        }
        if (Integer.TYPE.isAssignableFrom(returnType)) {
            int[] arrstrs = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Integer) transBasicValue(returnType, values[i])).intValue();
            }
            return arrstrs;
        }
        if (Integer.class.isAssignableFrom(returnType)) {
            Integer[] arrstrs = new Integer[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Integer) transBasicValue(returnType, values[i]));
            }
            return arrstrs;
        }
        if (Long.TYPE.isAssignableFrom(returnType)) {
            long[] arrstrs = new long[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Long) transBasicValue(returnType, values[i])).longValue();
            }
            return arrstrs;
        }
        if (Long.class.isAssignableFrom(returnType)) {
            Long[] arrstrs = new Long[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Long) transBasicValue(returnType, values[i]));
            }
            return arrstrs;
        }
        if (Double.TYPE.isAssignableFrom(returnType)) {
            double[] arrstrs = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Double) transBasicValue(returnType, values[i])).doubleValue();
            }
            return arrstrs;
        }
        if (Double.class.isAssignableFrom(returnType)) {
            Double[] arrstrs = new Double[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Double) transBasicValue(returnType, values[i]));
            }
            return arrstrs;
        }
        if (Float.TYPE.isAssignableFrom(returnType)) {
            float[] arrstrs = new float[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Float) transBasicValue(returnType, values[i])).floatValue();
            }
            return arrstrs;
        }
        if (Float.class.isAssignableFrom(returnType)) {
            Float[] arrstrs = new Float[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Float) transBasicValue(returnType, values[i]));
            }
            return arrstrs;
        }
        if (Boolean.TYPE.isAssignableFrom(returnType)) {
            boolean[] arrstrs = new boolean[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Boolean) transBasicValue(returnType, values[i])).booleanValue();
            }
            return arrstrs;
        }
        if (Boolean.class.isAssignableFrom(returnType)) {
            Boolean[] arrstrs = new Boolean[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Boolean) transBasicValue(returnType, values[i]));
            }
            return arrstrs;
        }
        if (Character.TYPE.isAssignableFrom(returnType)) {
            char[] arrstrs = new char[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Character) transBasicValue(returnType, values[i])).charValue();
            }
            return arrstrs;
        }
        if (Character.class.isAssignableFrom(returnType)) {
            Character[] arrstrs = new Character[values.length];
            for (int i = 0; i < values.length; i++) {
                arrstrs[i] = ((Character) transBasicValue(returnType, values[i]));
            }
            return arrstrs;
        }

        Object[] arrstrs = new Object[values.length];
        for (int i = 0; i < values.length; i++) {
            arrstrs[i] = transBasicValue(returnType, values[i]);
        }
        return arrstrs;
    }

    public static Object analyzeString2Array(Class returnType, String value) throws Exception {
        List list = new ArrayList();
        String[] arrstrs = value.trim().split(",");

        return constructArray(returnType, arrstrs);
    }

    public static Collection analyzeString2Collection(Method getMethod, String value) throws Exception {
        Collection collection = null;
        Class rType = getMethod.getReturnType();
        if ((!rType.isInterface()) && (!Modifier.isAbstract(rType.getModifiers())) && (!rType.isEnum()))
            collection = (Collection) rType.newInstance();
        else if (List.class.isAssignableFrom(rType))
            collection = new ArrayList();
        else if (Set.class.isAssignableFrom(rType))
            collection = new HashSet();
        else {
            throw new RuntimeException("not support Collection type , type = " + rType.getCanonicalName());
        }

        Class collectionType = Object.class;
        Type type = getMethod.getGenericReturnType();
        if ((type instanceof ParameterizedType)) {
            ParameterizedType pType = (ParameterizedType) type;
            collectionType = (Class) pType.getActualTypeArguments()[0];
        }

        String[] arrstrs = value.split(",");
        if (arrstrs != null) {
            for (String arrstr : arrstrs) {
                Object av = transBasicValue(collectionType, arrstr);
                collection.add(av);
            }
        }
        return collection;
    }
}