package cn.com.sky.tools.httpclientjsonpt;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class TestHttpClient4 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        HttpClient httpclient = new DefaultHttpClient();

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
        } finally { // 关闭连接,释放资源
            httpclient.getConnectionManager().shutdown();
        }
    }

}
