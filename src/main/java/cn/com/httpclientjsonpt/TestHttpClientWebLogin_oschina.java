package cn.com.httpclientjsonpt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

/**
 * 模拟登陆oschina
 */
public class TestHttpClientWebLogin_oschina {

    public static void main(String[] args) {

        // 创建默认的httpClient实例.
        HttpClient httpclient = new DefaultHttpClient();

        login_web(httpclient);// 登录
        main_page(httpclient);// 设置

        httpclient.getConnectionManager().shutdown();
    }

    private static void login_web(HttpClient httpclient) {

        // 创建httppost
        HttpPost httppost = new HttpPost(
                "https://www.oschina.net/action/user/hash_login");

        // 伪装浏览器,有的网站会校验是否为浏览器
        // httppost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
        // // 或者用下面方式：
        httpclient
                .getParams()
                .setParameter(CoreProtocolPNames.USER_AGENT,
                        "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");

        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        formparams.add(new BasicNameValuePair("email", "xxxx@qq.com"));
        formparams.add(new BasicNameValuePair("pwd",
                "xxxxxxxxxxx"));

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request: " + httppost.getURI());
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            response.getStatusLine();

            System.out.println("executing request: "
                    + response.getStatusLine().getStatusCode());

            if (entity != null) {
                System.out.println("--------------------------------------");
                System.out.println("Response content: "
                        + EntityUtils.toString(entity, "UTF-8"));
                System.out.println("--------------------------------------");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void main_page(HttpClient httpclient) {

        // 创建httpget
        HttpGet httpget = new HttpGet("http://www.oschina.net/");

        try {
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            response.getStatusLine();

            System.out.println("executing request " + response.getStatusLine());

            if (entity != null) {
                System.out.println("--------------------------------------");
                System.out.println("Response content: "
                        + EntityUtils.toString(entity, "UTF-8"));
                System.out.println("--------------------------------------");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
