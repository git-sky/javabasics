package cn.com.sky.tools.json.fastjson;

import cn.com.sky.tools.json.fastjson.domain.Men;
import cn.com.sky.tools.json.fastjson.domain.Person;
import cn.com.sky.tools.json.fastjson.domain.WoMen;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * <pre>
 *
 *
 * 1、序列化
 * 序列化就是指把JavaBean对象转成JSON格式的字符串。
 *
 * com.alibaba.fastjson.JSON提供了许多方法（多态）实现序列化。
 *
 * 基本的序列化
 * String objJson = JSON.toJSONString(Object object);
 *
 * 2、反序列化
 * 反序列化就是把JSON格式的字符串转化为JavaBean对象。
 *
 * com.alibaba.fastjson.JSON提供了许多方法（多态）实现反序列化。
 *
 * JSONObject，JSONArray是JSON的两个子类。
 *
 * JSONObject相当于Map<String, Object>，
 *
 * JSONArray相当于List<Object>。
 *
 * </pre>
 */
public class TestFastJson {

    @Test
    public void test1() {

        Men men = new Men();

        men.set_name("哈哈");
        men.set_age(11);

        //传入一个对象，将对象转成JSON字符串。
        String str = JSON.toJSONString(men);

        System.out.println(str);

        Men m = JSON.parseObject(str, Men.class);
        System.out.println(m.get_name());

        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.get("name"));

        System.out.println(jsonObject.get("_name"));

    }

    @Test
    public void test2() {

        WoMen w = new WoMen();

        w.set_3age(16);
        w.set_3name("老外");

        String str = JSON.toJSONString(w);

        System.out.println(str);

        WoMen m = JSON.parseObject(str, WoMen.class);
        System.out.println(m.get_3name());

        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.get("3nasme"));

    }


    /**
     * 将Map转成JSON
     */
    @Test
    public void test3() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "One");
        map.put("key2", "Two");

        String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);

        //反序列化
        //泛型的反序列化（使用TypeReference传入类型信息）。
        Map<String, Object> map1 = JSON.parseObject(mapJson, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(map1.get("key1"));
        System.out.println(map1.get("key2"));
    }

    /**
     * 将List<Map>转成JSON。
     */
    @Test
    public void test4() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("key1", "One");
        map1.put("key2", "Two");

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("key1", "Three");
        map2.put("key2", "Four");

        list.add(map1);
        list.add(map2);

        String listJson = JSON.toJSONString(list);

        System.out.println(listJson);

        //可以输出格式化后的 JSON 字符串。
        String listJsonFormat = JSON.toJSONString(list, true);
        System.out.println(listJsonFormat);


        //传入一个对象和SerializerFeature类型的可变变量。SerializerFeature是一个枚举。
        //使用单引号
        String listJsonF = JSON.toJSONString(list, SerializerFeature.UseSingleQuotes);
        System.out.println(listJsonF);


        String listJsonP = JSON.toJSONString(list, SerializerFeature.PrettyFormat);
        System.out.println(listJsonP);

        //反序列化
        List<Map> list1 = JSON.parseArray(listJson, Map.class);
        for (Map<String, Object> map : list1) {
            System.out.println(map.get("key1"));
            System.out.println(map.get("key2"));
        }


    }

    @Test
    public void testPersion() {
        Person person = new Person(new Long(123456L), "张三", 25, 160, 55.23);
        String jsonString = JSONObject.toJSONString(person);
        System.out.println(jsonString);

        //输出格式化后的 JSON 字符串。
        String jsonStringFormat = JSON.toJSONString(person, true);
        System.out.println(jsonStringFormat);


//        序列化时写入类型信息
        String personClazz = JSON.toJSONString(person, SerializerFeature.WriteClassName);
        System.out.println(personClazz);

//        反序列化
        Person user1 = (Person) JSON.parse(personClazz);
        System.out.println(user1.getAge());

        Person person1 = JSON.parseObject(jsonString, Person.class);
        System.out.println(person1.getName());


    }

    @Test
    public void testDate() {
        //在缺省的情况下，FastJSON会将Date转成long。
        String dateJson = JSON.toJSONString(new Date());
        System.out.println(dateJson);

        //使用SerializerFeature特性格式化日期。
        String dateJsonFe = JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat);
        System.out.println(dateJsonFe);


        //指定输出日期格式。
        String dateJsonF = JSON.toJSONStringWithDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(dateJsonF);
    }


    @Test
    public void testNull() {
        Map<String, Object> map = new HashMap<>();
        String b = null;
        Integer i = 1;
        map.put("a", b);
        map.put("b", i);

        // 缺省情况下FastJSON不输入为值Null的字段，可以使用SerializerFeature.WriteMapNullValue使其输出。
        String listJson = JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
        System.out.println(listJson);
    }


}
