package cn.com.okhttp_demo;

import okhttp3.*;

import java.io.IOException;

public class TestOk {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public static void main(String[] args) throws IOException {
        String url = "";
        String json = "";
        new TestOk().post(url, json);
    }

    String post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}