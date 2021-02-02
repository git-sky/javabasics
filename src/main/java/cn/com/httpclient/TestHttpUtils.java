package cn.com.httpclient;

import cn.com.httpclient.utils.HttpClientUtils;
import cn.com.json_tools.jackson.JsonUtils;

public class TestHttpUtils {

    public static void main(String[] args) {
        String url = "https://openapi.sky.com/doc/queryAllDocGroup";


        String json = "{\"data\":{\"api_key\":\"1c3f21f510c87c6dd4917a96556ef74879f51e22ae87117a6a3107c8a52e795d\"}}";
        String response = HttpClientUtils.invokeViaJson(url, json, "POST");
        System.out.println(response);
    }
}
