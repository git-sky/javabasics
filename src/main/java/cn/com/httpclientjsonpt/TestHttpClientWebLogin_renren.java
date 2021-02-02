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
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

/**
 * 模拟登录人人网,不成功
 */
public class TestHttpClientWebLogin_renren {

    public static void main(String[] args) {

        // 创建默认的httpClient实例.
        HttpClient httpclient = new DefaultHttpClient();

        // //设置自动跳转
        // ((AbstractHttpClient) httpclient)
        // .setRedirectStrategy(new LaxRedirectStrategy());
        //
        login_web(httpclient);// 登录
        // verify_password(httpclient);//设置

        httpclient.getConnectionManager().shutdown();
    }

    private static void login_web(HttpClient httpclient) {

        // 创建httppost
        HttpPost httppost = new HttpPost(
                "http://www.renren.com/ajaxLogin/login?1=1&uniqueTimestamp=2013811727860");

        // 伪装浏览器,有的网站会校验是否为浏览器
        // httppost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
        // // 或者用下面方式：
        httpclient
                .getParams()
                .setParameter(CoreProtocolPNames.USER_AGENT,
                        "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");

        httppost
                .setHeader("User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
        httppost.setHeader("Referer", "http://www.csdn.net/");
        httppost
                .setHeader(
                        "User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");

        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        formparams.add(new BasicNameValuePair("email", "xxxxxxxxx@qq.com"));
        formparams.add(new BasicNameValuePair("icode", ""));
        formparams.add(new BasicNameValuePair("origURL",
                "http://www.renren.com/home"));
        formparams.add(new BasicNameValuePair("domain", "renren.com"));
        formparams.add(new BasicNameValuePair("key_id", "1"));
        formparams.add(new BasicNameValuePair("captcha_type", "web_login"));
        formparams.add(new BasicNameValuePair("password", "xxxxxxxxxx"));
        formparams.add(new BasicNameValuePair("rkey",
                "d0cf42c2d3d337f9e5d14083f2d52cb2"));

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

}
