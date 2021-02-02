package cn.com.httpclientjsonpt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 模拟登录csdn账号并设置
 * *
 */

public class TestHttpClientWebLogin_csdn {

    public static void main(String[] args) {

        // 创建默认的httpClient实例.
        HttpClient httpclient = new DefaultHttpClient();

        login_web(httpclient);//登录
        profile(httpclient);//设置

        //关闭
        httpclient.getConnectionManager().shutdown();
    }

    private static void login_web(HttpClient httpclient) {

        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(
                    "https://passport.csdn.net/ajax/accounthandler.ashx?t=log&u=jonliner&p=xpp345,,,&remember=0&f=http%3A%2F%2Fwww.csdn.net%2F&rand=0.09795457124710083");

            // 模拟浏览器，如果没有下面的两个参数，会返回错误
            httpget.setHeader("Referer", "http://www.csdn.net/");
            httpget
                    .setHeader(
                            "User-Agent",
                            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");

            System.out.println("executing request: " + httpget.getURI());
            // 执行get请求.
            HttpResponse response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            System.out.println("--------------------------------------");

            // 打印响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                // 打印响应内容长度
                System.out.println("Response content length: "
                        + entity.getContentLength());
                // 打印响应内容
                System.out.println("Response content: "
                        + EntityUtils.toString(entity));
            }
            System.out.println("------------------------------------");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void profile(HttpClient httpclient) {

        // 创建httpget
        HttpGet httpget = new HttpGet(
                "https://passport.csdn.net/account/profile");

        // 伪装浏览器,有的网站会校验是否为浏览器
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
        httpget.setHeader("Referer", "http://www.csdn.net/");
        httpget.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");

        try {
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            response.getStatusLine();

            System.out.println("executing request: "
                    + response.getStatusLine().getStatusCode());

            if (entity != null) {
                System.out.println("--------------------------------------");
                System.out.println("Response content length: "
                        + entity.getContentLength());
                System.out.println("Response content: "
                        + EntityUtils.toString(entity, "UTF-8"));
                System.out.println("--------------------------------------");

                // 获取响应实体
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
