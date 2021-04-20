package cn.com.a_temp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 *
 */
public class TestMs {

    public static void main(String[] args) {
//        String content = "1";
//////        String content = "{\"1\":\"100-200\",\"2\":\"201-300\",\"3\":\"500\"}";
////        Map<String, String> map = Maps.newHashMap();
////        map = JSON.parseObject(content, Map.class);
////        System.out.println(map);
////        for (Map.Entry<String, String> entry : map.entrySet()) {
////            System.out.println("key=" + entry.getKey());
////            System.out.println("key=" + entry.getValue());
////        }
//
//        String minPrice = "    12          ";
//        System.out.println(StringUtils.trim(minPrice));
//        System.out.println(Long.parseLong(StringUtils.trim(minPrice)));
////        System.out.println(Long.parseLong(minPrice));
//
//        String value = "1";
//
//        String[] minMaxPrice = value.split("-");
//        System.out.println(minMaxPrice.length);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cityId", 1);
        jsonObject.put("referer", "jjddz");
        jsonObject.put("channel", "game");
        System.out.println(JSON.toJSONString(jsonObject));
        System.out.println(jsonObject.toJSONString());
        System.out.println(JSON.toJSONString(jsonObject,SerializerFeature.MapSortField));

    }
}