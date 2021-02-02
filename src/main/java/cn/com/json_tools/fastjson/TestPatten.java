package cn.com.json_tools.fastjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestPatten {

    public static void main(String[] args) {
        getStrings();
    }

    private static void getStrings() {

        String str = "{\"id\":1,\"user_id\":123,\"social_id\":234,\"faceNum\":1,\"lookNum\":1}";

        // 缓存的key
        Map<String, String> ckeys = new HashMap<>();
        ckeys.put("faceNum", "user:{user_id}:number");
        ckeys.put("lookNum", "social:{social_id}:number");

        JSONObject jsonObject = JSON.parseObject(str);

        getValues(ckeys, jsonObject);

        System.out.println(jsonObject.toString());
    }

    private static void getValues(Map<String, String> ckeys, JSONObject jsonObject) {

        System.out.println(jsonObject.toString());

        for (Map.Entry<String, String> entry : ckeys.entrySet()) {

            String key = entry.getKey();
            String val = entry.getValue();

            Pattern p = Pattern.compile("\\{(.*?)\\}");
            Matcher m = p.matcher(val);
            ArrayList<String> strs = new ArrayList<>();
            while (m.find()) {
                strs.add(m.group(0));
                strs.add(m.group(1));
            }
            for (String s : strs) {
                System.out.println(s);
            }

            Integer user_id = (Integer) jsonObject.get(strs.get(1));

            System.out.println(user_id);

            String ss = m.replaceAll(String.valueOf(user_id));

            System.out.println(ss);


            // 实时数据
            Map<String, Integer> realData = new HashMap<>();
            realData.put("user:123:number", 3333);
            realData.put("social:234:number", 4444);


            int num = realData.get(ss);

            System.out.println(num);

            jsonObject.put(key, num);
        }

        // return jsonObject;

    }


}
