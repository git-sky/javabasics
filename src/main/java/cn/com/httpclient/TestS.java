//package cn.com.httpclient;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class TestS {
//
//    public static void main(String[] args) {
//
//        StringEntity stringEntity = new StringEntity(requestBody.toJSONString());
//        RequestConfig requestConfig = RequestConfig.custom().
//                setSocketTimeout(60000).//服务器返回数据(response)的时间，超过该时间抛出read timeout
//                setConnectTimeout(60000).//连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
//                setConnectionRequestTimeout(60000).build();//从连接池中获取连接的超时时间，超过该时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
//        HttpPost post = new HttpPost(queryUrl);
//        post.addHeader("content-type", "application/json");
//        post.setEntity(stringEntity);
//        post.setConfig(requestConfig);
//
//        BufferedReader reader = null;
//        StringBuilder sb = null;
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            try (CloseableHttpResponse response = httpClient.execute(post)) {
//                HttpEntity responseEntity = response.getEntity();
//                reader = new BufferedReader(new InputStreamReader((responseEntity.getContent())));
//                String lines;
//                sb = new StringBuilder();
//                while ((lines = reader.readLine()) != null) {
//                    sb.append(lines);
//                }
//            }
//        } catch (IOException e) {
//            throw e;
//        } finally {
//            reader.close();
//        }
//    }
//
//}