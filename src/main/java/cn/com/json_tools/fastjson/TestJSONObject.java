package cn.com.json_tools.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class TestJSONObject {

    @Test
    public void testJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "zhangsan");
        jsonObject.put("userId", "123456");
        jsonObject.put("templateId", 123);
        jsonObject.put("money", 55.68);
        System.out.println(jsonObject);

    }
}
