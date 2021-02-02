package cn.com.httpclient.demo;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 *
 */
public class Http {


    public static void main(String[] args) {
//        创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpClients.createSystem();
        HttpClients.createMinimal();
        HttpClients.custom().build();
    }


    //连接池管理器
    private static PoolingHttpClientConnectionManager initPool() {
        int MAX_CONN_TOTAL = 3;
        int MAX_CONN_PERROUTE = 3;

        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
        pool.setMaxTotal(MAX_CONN_TOTAL);                                         //设置最大连接数
        pool.setDefaultMaxPerRoute(MAX_CONN_PERROUTE);             //设置路由最大连接数
        //HttpHost httpHost = new HttpHost("host",80);
        //pool.setMaxPerRoute(new HttpRoute(httpHost),3);          对特定域名设置最大连接数
        return pool;
    }

}