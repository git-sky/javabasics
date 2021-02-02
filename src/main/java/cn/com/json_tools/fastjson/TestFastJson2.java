package cn.com.json_tools.fastjson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFastJson2 {

    @Test
    public void test() {
        //将Map转成JSONObject，然后添加元素，输出。
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "One");
        map.put("key2", "Two");
        JSONObject jsonObject = new JSONObject(map);
        jsonObject.put("key3", "Three");
        System.out.println(jsonObject.get("key1"));
        System.out.println(jsonObject.get("key2"));
        System.out.println(jsonObject.get("key3"));
    }


    //将List对象转成JSONArray。
    @Test
    public void testJsonArray() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "One");
        map.put("key2", "Two");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("key1", "Three");
        map2.put("key2", "Four");

        list.add(map);
        list.add(map2);

        System.out.println(JSON.toJSONString(list));

        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));

        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.get(i));
        }
    }
}