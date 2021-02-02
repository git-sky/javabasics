package cn.com.httpclient.utils;


import cn.com.json_tools.jackson.JsonUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Http请求工具类
 */
public class HttpClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    public static final String ENCODE = "utf-8";
    public static final int CONNECT_TIMEOUT = 2000;
    public static final int READ_TIMEOUT = 10000;

    //设置HttpClient连接池最大连接数
    private static final int MAX_TOTAL_CONNECTION = 1024;

    //设置HttpClient连接池每个路由的最大连接数
    private static final int MAX_PER_ROUTE = 50;

    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
    private static CloseableHttpClient httpClient = null;

    static {
        poolingHttpClientConnectionManager.setMaxTotal(MAX_TOTAL_CONNECTION);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        //失效链接检查时间 20s
        poolingHttpClientConnectionManager.setValidateAfterInactivity(10000);
        httpClient = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).build();
    }

    private HttpClientUtils() {
    }

    //change the implementation of the singleton
    //Initialization on demand holder to BE LAZY
    private static class HttpClientUtilsHolder {
        static HttpClientUtils instance = new HttpClientUtils();
    }

    /**
     * 获取单例
     *
     * @return
     */
    public static HttpClientUtils getInstance() {
        return HttpClientUtilsHolder.instance;
    }

    /**
     * 创建带连接池的httpclient，线程安全<br>
     * 默认每host最大100连接，timeout时间为5秒
     * 超时重试次数为3次
     */
    public CloseableHttpClient createClientWithPool() {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(500);
        connManager.setDefaultMaxPerRoute(20);
        return HttpClients.custom().setConnectionManager(connManager).build();
    }

    /**
     * 调用外部get接口
     */
    public static String invokeGet(String url, Map<String, String> params, String encode, int connectTimeout, int readTimeout, String clientId, String clientSecret) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeout).setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();
        String requestUrl;
        try {
            requestUrl = buildRequestUrl(url, params);
        } catch (UnsupportedEncodingException e) {
            return StringUtils.EMPTY;
        }
        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.setConfig(requestConfig);
        return doRequest(httpGet, encode);
    }

    /**
     * 调用外部post接口
     */
    public static String invokePost(String requestUrl, Map<String, Object> params, String encode, int connectTimeout, int readTimeout) {
        return invokePostWithParam(requestUrl, params, encode, connectTimeout, readTimeout);
    }


    public static String invokePost(String requestUrl, Map<String, Object> params) {
        return invokePostWithParam(requestUrl, params, ENCODE, CONNECT_TIMEOUT, READ_TIMEOUT);
    }

    private static String invokePostWithParam(String requestUrl, Map<String, Object> params, String encode, int connectTimeout, int readTimeout) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeout).setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();
        HttpPost httpPost = new HttpPost(requestUrl);
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(buildParams(params), encode));
        } catch (UnsupportedEncodingException ex) {
            LOGGER.error("invokePost: encode http post params error, params is " + params, ex);
        }
        return doRequest(httpPost, encode);
    }

    public static String invokePost(String requestUrl, String json, Map<String, String> headers) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(READ_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(CONNECT_TIMEOUT).build();
        HttpPost httpPost = new HttpPost(requestUrl);
        if (!MapUtils.isEmpty(headers)) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }
        httpPost.setConfig(requestConfig);
        try {
            StringEntity se = new StringEntity(json, ENCODE);
            httpPost.setEntity(se);
        } catch (Exception ex) {
            LOGGER.error("invokePost: encode http post params error, params is " + json, ex);
        }
        return doRequest(httpPost, ENCODE);
    }


    /**
     * json格式提交
     */
    public static String invokeViaJson(String requestUrl, String json, String method, String encode,
                                       int connectTimeout, int readTimeout, String clientId, String clientSecret) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeout).setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();
        HttpRequestBase http;
        if (StringUtils.equalsIgnoreCase("PUT", method)) {
            http = new HttpPut(requestUrl);
            ((HttpPut) http).setEntity(new StringEntity(json, encode));
        } else if (StringUtils.equalsIgnoreCase("POST", method)) {
            http = new HttpPost(requestUrl);
            ((HttpPost) http).setEntity(new StringEntity(json, encode));
        } else {
            throw new IllegalArgumentException("http method not support json");
        }
        http.setConfig(requestConfig);
        http.setHeader("Content-Type", "application/json;charset=utf-8");
        return doRequest(http, encode);
    }

    /**
     * json格式提交
     */
    public static String invokeViaJson(String requestUrl, String json, String method) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(READ_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(CONNECT_TIMEOUT).build();
        HttpRequestBase http;

        if (StringUtils.equalsIgnoreCase("PUT", method)) {
            http = new HttpPut(requestUrl);
            ((HttpPut) http).setEntity(new StringEntity(json, ENCODE));
        } else if (StringUtils.equalsIgnoreCase("POST", method)) {
            http = new HttpPost(requestUrl);
            ((HttpPost) http).setEntity(new StringEntity(json, ENCODE));
        } else {
            throw new IllegalArgumentException("http method not support json");
        }
        http.setConfig(requestConfig);
        http.setHeader("Content-Type", "application/json;charset=utf-8");
        return doRequest(http, ENCODE);
    }

    /**
     * 构建http接口需要的参数
     *
     * @param params
     * @return
     */
    private static List<NameValuePair> buildParams(Map<String, Object> params) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        if (!CollectionUtils.isEmpty(params)) {
            for (String key : params.keySet()) {
                if (params.get(key) instanceof String) {
                    nameValuePairs.add(new BasicNameValuePair(key, (String) params.get(key)));
                } else {
                    nameValuePairs.add(new BasicNameValuePair(key, JsonUtils.object2Json(params.get(key), true)));
                }
            }
        }

        return nameValuePairs;
    }

    private static String doRequest(HttpRequestBase httpRequestBase, String encode) {
        String responseString = StringUtils.EMPTY;
        try {
            long start = System.currentTimeMillis();
            CloseableHttpResponse response = httpClient.execute(httpRequestBase);
            LOGGER.info("HttpClientUtils Begin Invoke: " + httpRequestBase.getURI() + ", cost time " + (System.currentTimeMillis() - start) + " ms");
            try {
                HttpEntity entity = response.getEntity();
                try {
                    if (entity != null) {
                        responseString = EntityUtils.toString(entity, encode);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } catch (Exception e) {
                LOGGER.error(String.format("[HttpClientUtils.doRequest] get response error, url:%s", httpRequestBase.getURI()), e);
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (SocketTimeoutException e) {
            LOGGER.error("SocketTimeoutException");
        } catch (Exception e) {
            LOGGER.error("Exception");
        } finally {
            httpRequestBase.releaseConnection();
        }
        return responseString;
    }

    private static String buildRequestUrl(String url, Map<String, String> params) throws UnsupportedEncodingException {
        if (CollectionUtils.isEmpty(params)) {
            return url;
        }
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append(url);
        int i = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (i == 0) {
                requestUrl.append("?");
            }
            requestUrl.append(entry.getKey());
            requestUrl.append("=");
            String value = entry.getValue();
            requestUrl.append(URLEncoder.encode(value, "UTF-8"));
            requestUrl.append("&");
            i++;
        }
        requestUrl.deleteCharAt(requestUrl.length() - 1);
        return requestUrl.toString();
    }


    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        int i = 0;
        for (; ; ) {
            i++;
            executorService.submit(new MyTask(i));
        }
    }

    static class MyTask implements Runnable {
        int i = 0;

        public MyTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appId", "mgckmf3q8yx9d72b");
            jsonObject.put("tag", "1");
            String response = HttpClientUtils.invokeViaJson("http://localhost:8080/mgc/gateway/api/v3/mg/getBaseInfo", jsonObject.toJSONString(), "POST");
            System.out.println(System.currentTimeMillis() + "=" + i + "= " + response);
        }
    }

}

