package cn.com.sky.tools.httpclientjsonpt;

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
 * 模拟登陆iteye,不知为什么总是返回乱码
 */
public class TestHttpClientWebLogin_iteye {

    public static void main(String[] args) {

        // 创建默认的httpClient实例.
        HttpClient httpclient = new DefaultHttpClient();

        // 设置自动跳转
//		((AbstractHttpClient) httpclient)
//				.setRedirectStrategy(new LaxRedirectStrategy());

        login_web(httpclient);// 登录
        my_page(httpclient);//我的主页
        my_email(httpclient);//我的收件箱

        httpclient.getConnectionManager().shutdown();
    }

    private static void login_web(HttpClient httpclient) {

        // 创建httppost
        HttpPost httppost = new HttpPost("http://www.iteye.com/login");

        // 伪装浏览器,有的网站会校验是否为浏览器
        // httppost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
        // // 或者用下面方式：
        httpclient
                .getParams()
                .setParameter(CoreProtocolPNames.USER_AGENT,
                        "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");

        httppost
                .setHeader("Accept",
                        "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httppost.setHeader("Accept-Encoding", "gzip,deflate,sdch");
        httppost.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httppost.setHeader("Cache-Control", "max-age=0");
        httppost.setHeader("Connection", "keep-alive");
        // httppost.setHeader("Content-Length","122");
        httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httppost
                .setHeader(
                        "Cookie",
                        "_javaeye_cookie_id_=1376290123197390; lzstat_uv=15511664072731900509|1280728@2925339@729007@1309865; remember_me=no; _javaeye3_session_=BAh7CSIKZmxhc2hJQzonQWN0aW9uQ29udHJvbGxlcjo6Rmxhc2g6OkZsYXNoSGFzaHsGOgplcnJvciIy55m75b2V5ZCN56ew5oiW5a%2BG56CB6ZSZ6K%2Bv77yM6K%2B36YeN5paw55m75b2VBjoKQHVzZWR7BjsGVDoRb3JpZ2luYWxfdXJpIhpodHRwOi8vd3d3Lml0ZXllLmNvbS86EF9jc3JmX3Rva2VuIjFYYmdUVnFpM1pLZDA1eW5DODl1eCtUb1JpTHpZWExxSDRhWkhHOXJ3clRrPToPc2Vzc2lvbl9pZCIlZjA2MmZhMTY3MTZjNDI1NDcwYTg1MWNiODRiMjM2NTA%3D--916b366181b7550d21c4a3e2388bb453b78006da; __utma=191637234.793154495.1376290131.1378694297.1378708365.56; __utmb=191637234.9.10.1378708365; __utmc=191637234; __utmz=191637234.1378708365.56.51.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided)");
        httppost.setHeader("Host", "www.iteye.com");
        httppost.setHeader("Origin", "http://www.iteye.com");
        httppost.setHeader("Referer", "http://www.iteye.com/login");
        httppost
                .setHeader(
                        "User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");

        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        formparams.add(new BasicNameValuePair("authenticity_token",
                "XbgTVqi3ZKd05ynC89ux+ToRiLzYXLqH4aZHG9rwrTk="));
        formparams.add(new BasicNameValuePair("name", "xxxxx"));
        formparams.add(new BasicNameValuePair("password", "xxxxx"));
        formparams.add(new BasicNameValuePair("button", "登　录"));

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


    private static void my_page(HttpClient httpclient) {
        try {
            // 创建httpget
            HttpGet httpget = new HttpGet("http://javajar.iteye.com/");
            System.out.println("executing request " + httpget.getURI());

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


    private static void my_email(HttpClient httpclient) {
        try {
            // 创建httpget
            HttpGet httpget = new HttpGet("http://my.iteye.com/messages");
            System.out.println("executing request " + httpget.getURI());

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
}
