package cn.com.httpclient.https;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Map;

/**
 * https请求工具
 * 说明:对方的证书是自签的证书
 */
public class HttpsUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpsUtils.class);

    private final static Gson gson = new GsonBuilder().create();

    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_READ_TIMEOUT = 5000;
    private static final int MAX_GET_INSTANCE_TIMEOUT = 5000;
    private static final int MAX_CONNECT_TIMEOUT = 5000;

    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(20);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_CONNECT_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_READ_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_GET_INSTANCE_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
        configBuilder.setStaleConnectionCheckEnabled(true);

        requestConfig = configBuilder.build();
    }


    /**
     * 发送 SSL POST 请求（HTTPS），json
     *
     * @param apiUrl API接口URL
     * @param params 参数map
     */
    public static String doPostSSL(String apiUrl, Map<String, Object> params, String keyStoreFile, String password) throws IOException {
        CloseableHttpClient httpClient = buildHttpsClient(keyStoreFile, password);
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;
        try {
            httpPost.setConfig(requestConfig);
            String requestString = gson.toJson(params);
            System.out.println(requestString);
            StringEntity stringEntity = new StringEntity(requestString, "UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, "utf-8");
        } catch (SocketTimeoutException e) {
            LOGGER.warn("api:{} socket超时 参数为:{}", apiUrl, params);
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    LOGGER.error("关闭资源异常", e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 构建https的httpclient,读取信任的证书
     *
     * @param keyStoreFile 信任证书在resource目录下的名称
     * @param password     信任证书的密码
     * @return
     * @throws Exception
     */
    private static CloseableHttpClient buildHttpsClient(String keyStoreFile, String password) {
        try {
            String keyStorePath = HttpsUtils.class.getClassLoader().getResource(keyStoreFile).getPath();
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream in = new FileInputStream(keyStorePath);
            ks.load(in, password.toCharArray());
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(ks);
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(null, tmf.getTrustManagers(), null);
            LayeredConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(ctx);
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
            return httpClient;
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | KeyManagementException e) {
            LOGGER.error("创建httpsClient客户端异常", e);
            throw new RuntimeException(e);
        }
    }
}

