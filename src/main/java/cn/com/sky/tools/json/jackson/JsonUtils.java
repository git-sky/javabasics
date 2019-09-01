package cn.com.sky.tools.json.jackson;


import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    /**
     * json转为object
     *
     * @param json
     * @param valueTypeRef
     * @param <T>
     * @return
     */
    public static <T> T json2Object(String json, TypeReference valueTypeRef) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return (T) objectMapper.readValue(json, valueTypeRef);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * json转object
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T json2Object(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            return null;
        }
    }


    public static Map json2Map(String json, boolean containNull) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            if (!containNull) {
                objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            }
            objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
            return objectMapper.readValue(json, Map.class);
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> List<List<T>> json2DList(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return Collections.emptyList();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType1 = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, javaType1);
            List<List<T>> list = mapper.readValue(json, javaType);
            return list;
        } catch (Exception e) {
            throw new RuntimeException("json2DList error.", e);
        }
    }

    public static String object2Json(Object object) {
        return object2Json(object, false);
    }

    public static String object2Json(Object object, boolean containNull) {
        if (object == null) {
            return StringUtils.EMPTY;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            if (!containNull) {
                objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            }
            objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            return StringUtils.EMPTY;
        }
    }

}