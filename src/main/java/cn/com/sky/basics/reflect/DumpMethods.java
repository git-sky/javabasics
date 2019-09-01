package cn.com.sky.basics.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DumpMethods {

    String className = "";

    @Before
    public void setUp() {
        className = "java.util.List";
    }

    @After
    public void tearDown() {

    }

    @Test
    public void dumpMethods() {
        try {
            Class c = Class.forName(className);
            // getDeclaredMethods 获取当前类的全部方法
            Method[] m = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    @Test
    public void dumpMethods2() {
        try {
            Class cls = Class.forName(className);
            // getDeclaredMethods 获取当前类的全部方法
            Method methodsList[] = cls.getDeclaredMethods();
            for (int i = 0; i < methodsList.length; i++) {
                Method m = methodsList[i];
                System.out.println("getName = " + m.getName());
                System.out.println("getClass = " + m.getClass());
                System.out.println("getDeclaringClass = " + m.getDeclaringClass());
                //参数类型
                Class parameterTypes[] = m.getParameterTypes();
                for (int j = 0; j < parameterTypes.length; j++) {
                    System.out.println("parameterType #" + j + " " + parameterTypes[j]);
                }
                Class exceptionTypes[] = m.getExceptionTypes();
                for (int j = 0; j < exceptionTypes.length; j++) {
                    System.out.println("exceptionType #" + j + " " + exceptionTypes[j]);
                }
                System.out.println("returnType = " + m.getReturnType());
                System.out.println("=========================================");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    @Test
    public void getConstructors() {
        try {
            Class cls = Class.forName(className);
            Constructor declaredConstructors[] = cls.getDeclaredConstructors();
            for (int i = 0; i < declaredConstructors.length; i++) {
                Constructor constructor = declaredConstructors[i];
                System.out.println("getName = " + constructor.getName());
                System.out.println("getDeclaringClass = " + constructor.getDeclaringClass());
                Class[] parameterTypes = constructor.getParameterTypes();
                for (int j = 0; j < parameterTypes.length; j++) {
                    System.out.println("parameterType #" + j + " " + parameterTypes[j]);
                }
                Class[] exceptionTypes = constructor.getExceptionTypes();
                for (int j = 0; j < exceptionTypes.length; j++) {
                    System.out.println("exceptionType #" + j + " " + exceptionTypes[j]);
                }
                System.out.println("=========================================");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    @Test
    public void getDeclaredFields() {
        try {
            Class cls = Class.forName(className);
            Field declaredFields[] = cls.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                System.out.println("getName = " + field.getName());
                System.out.println("getDeclaringClass = " + field.getDeclaringClass());
                System.out.println("getType = " + field.getType());
                int mod = field.getModifiers();
                System.out.println("modifiers = " + Modifier.toString(mod));
                System.out.println("=========================================");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

}