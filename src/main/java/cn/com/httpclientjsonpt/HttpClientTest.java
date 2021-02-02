package cn.com.httpclientjsonpt;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
    public static void main(String[] args) throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            TrustManager easyTrustManager = new X509TrustManager() {

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] x509Certificates,
                        String s)
                        throws java.security.cert.CertificateException {
                    // To change body of implemented methods use File | Settings
                    // | File Templates.
                }

                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] x509Certificates,
                        String s)
                        throws java.security.cert.CertificateException {
                    // To change body of implemented methods use File | Settings
                    // | File Templates.
                }

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[0]; // To
                    // change
                    // body
                    // of
                    // implemented
                    // methods
                    // use
                    // File
                    // |
                    // Settings
                    // |
                    // File
                    // Templates.
                }
            };

            SSLContext sslcontext = SSLContext.getInstance("TLS");

            //使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
            sslcontext
                    .init(null, new TrustManager[]{easyTrustManager}, null);

            SSLSocketFactory sf = new SSLSocketFactory(sslcontext);

            Scheme sch = new Scheme("https", 443, sf);

            httpClient.getConnectionManager().getSchemeRegistry().register(sch);

            HttpGet httpget = new HttpGet("https://passport.csdn.net/ajax/accounthandler.ashx?t=log&u=jonliner&p=xpp345,,,&remember=0&f=http%3A%2F%2Fwww.csdn.net%2F&rand=0.09795457124710083");

            //模拟浏览器，如果没有下面的两个参数，会返回错误
            httpget.setHeader("Referer", "http://www.csdn.net/");
            httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");


            System.out.println("executing request" + httpget.getRequestLine());

            HttpResponse response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            if (entity != null) {
                System.out.println("Response content length: "
                        + entity.getContentLength());
            }
            String content = EntityUtils.toString(entity);
            System.out.println(content);

        } finally {
            httpClient.getConnectionManager().shutdown();
        }

    }

}