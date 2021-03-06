package cn.com.freemarker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {

    public static <T> List<T> parseArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    public static JSONObject parseObject(String text) {
        return JSON.parseObject(text);
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static <T> T parseObject(String json, Type type, Feature... features) {
        return JSON.parseObject(json, type, features);
    }

    public static <T> T parseObject(String json, TypeReference<T> type, Feature... features) {
        return JSON.parseObject(json, type, features);
    }

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteNonStringKeyAsString);
    }

    public static String toArrayJSONString(Object object) {
        return JSONArray.toJSONString(object, SerializerFeature.WriteNonStringKeyAsString);
    }

    public static String toJSONStringWithClass(Object object) {
        SerializerFeature[] features = new SerializerFeature[]{
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteNonStringKeyAsString
        };
        return JSON.toJSONString(object, features);
    }

    public static String toArrayJSONStringWithClass(Object object) {
        SerializerFeature[] features = new SerializerFeature[]{
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteNonStringKeyAsString
        };
        return JSONArray.toJSONString(object, features);
    }

    public static void main(String[] args) {
//        Map map = new HashMap();
//        String str = toJSONString(map);
//        System.err.println(str);
//        ConcurrentHashMap map2 = parseObject(str, ConcurrentHashMap.class);
//        System.err.println(map2);
    }
}