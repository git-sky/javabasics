package cn.com.httpclient.utils;

import cn.com.json_tools.jackson.JsonUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class HttpsClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpsClientUtils.class);

    public static final String ENCODE = "utf-8";
    public static final int CONNECT_TIMEOUT = 3000;
    public static final int READ_TIMEOUT = 3000;

    //设置HttpClient连接池最大连接数
    private static final int MAX_TOTAL_CONNECTION = 1024;

    //设置HttpClient连接池每个路由的最大连接数
    private static final int MAX_PER_ROUTE = 50;

    private static CloseableHttpClient httpClient = null;

    static {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();

        poolingHttpClientConnectionManager.setMaxTotal(MAX_TOTAL_CONNECTION);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        //失效链接检查时间 20s
        poolingHttpClientConnectionManager.setValidateAfterInactivity(20000);
//
//        httpClient = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).build();

//        httpClient = new HttpClientConnManager().getHttpClient();

//构造client时候设置SSLSocketFactory
        httpClient = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).setSSLSocketFactory(createSSLConnSocketFactory()).build();

    }


    private HttpsClientUtils() {
    }

    //change the implementation of the singleton
    //Initialization on demand holder to BE LAZY
    private static class HttpsClientUtilsHolder {
        static HttpsClientUtils instance = new HttpsClientUtils();
    }

    /**
     * 获取单例
     *
     * @return
     */
    public static HttpsClientUtils getInstance() {
        return HttpsClientUtilsHolder.instance;
    }

    public CloseableHttpClient createClientWithPool() {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(500);
        connManager.setDefaultMaxPerRoute(20);
        return HttpClients.custom().setConnectionManager(connManager).build();
    }


    public static String invokeGet(String url, Map<String, String> params) {
        return invokeGet(url, params, ENCODE, CONNECT_TIMEOUT, READ_TIMEOUT);
    }

    public static String invokeGet(String url, Map<String, String> params, String encode, int connectTimeout, int readTimeout) {
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


    public static String invokePost(String url, Map<String, Object> params) {
        return invokePost(url, params, ENCODE, CONNECT_TIMEOUT, READ_TIMEOUT);
    }

    public static String invokePost(String url, Map<String, Object> params, String encode, int connectTimeout, int readTimeout) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeout).setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(buildParams(params), encode));
        } catch (UnsupportedEncodingException ex) {
            LOGGER.error("invokePost: encode http post params error, params is " + params, ex);
        }
        return doRequest(httpPost, encode);
    }

    public static String invokePost(String url, String json, Map<String, String> headers) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(READ_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(CONNECT_TIMEOUT).build();
        HttpPost httpPost = new HttpPost(url);
        if (!MapUtils.isEmpty(headers)) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }
        httpPost.setConfig(requestConfig);
        httpPost.setEntity(new StringEntity(json, ENCODE));
        return doRequest(httpPost, ENCODE);
    }

    /**
     * json格式提交
     */
    public static String invokeViaJson(String url, String json, String method) {
        return invokeViaJson(url, json, method, READ_TIMEOUT, CONNECT_TIMEOUT, ENCODE);
    }

    /**
     * json格式提交
     */
    public static String invokeViaJson(String url, String json, String method, int readTimeout, int connectTimeout, String encode) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeout).setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();

        HttpRequestBase http;
        if (StringUtils.equalsIgnoreCase("PUT", method)) {
            http = new HttpPut(url);
            ((HttpPut) http).setEntity(new StringEntity(json, encode));
        } else if (StringUtils.equalsIgnoreCase("POST", method)) {
            http = new HttpPost(url);
            ((HttpPost) http).setEntity(new StringEntity(json, encode));
        } else {
            throw new IllegalArgumentException("http method not support json");
        }
        http.setConfig(requestConfig);
        http.setHeader("Content-Type", "application/json;charset=utf-8");
        return doRequest(http, encode);
    }

    /**
     * 构建http接口需要的参数
     *
     * @param params
     * @return
     */
    private static List<NameValuePair> buildParams(Map<String, Object> params) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        if (!MapUtils.isEmpty(params)) {
            for (String key : params.keySet()) {
                if (params.get(key) instanceof String) {
                    nameValuePairs.add(new BasicNameValuePair(key, (String) params.get(key)));
                } else {
//                    nameValuePairs.add(new BasicNameValuePair(key, JsonUtils.toJSONStringWithClass(params.get(key))));
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
            LOGGER.info("HttpsClientUtils Begin Invoke: " + httpRequestBase.getURI() + ", cost time " + (System.currentTimeMillis() - start) + " ms");
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
                LOGGER.error(String.format("[HttpsClientUtils.doRequest] get response error, url:%s", httpRequestBase.getURI()), e);
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (SocketTimeoutException e) {
            LOGGER.error("SocketTimeoutException", e);
        } catch (Exception e) {
            LOGGER.error("Exception", e);
        } finally {
            httpRequestBase.releaseConnection();
        }
        return responseString;
    }

    private static String buildRequestUrl(String url, Map<String, String> params) throws UnsupportedEncodingException {
        if (MapUtils.isEmpty(params)) {
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


    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLConnectionSocketFactory sslsf = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

                @Override
                public void verify(String host, SSLSocket ssl) throws IOException {
                }

                @Override
                public void verify(String host, X509Certificate cert) throws SSLException {
                }

                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                }
            });
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return sslsf;
    }

    public static void main(String[] args) {

    }

}

