package cn.com.sky.tools.httpclientjsonpt;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class httpclientjsoup {

    /**
     * heepclient 抓取页面 jroup 解析页面内容
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入手机号码：");
        String strphone = reader.nextLine();

        HttpClient client = new HttpClient();
        // 设置代理服务器地址(URL)和端口
        client.getHostConfiguration().setHost("haoma.imobile.com.cn", 80);
        HttpMethod method = getPostMethod(strphone);
        try {
            client.executeMethod(method);
            // System.out.println(method.getStatusLine()); //打印结果页面
            String response = new String(method.getResponseBodyAsString());

            System.out.println(response);
            // 释放连接
            method.releaseConnection();

            // 解析页面内容
            Document doc = Jsoup.parse(response); // 从字符串中加载
            // 直接从URL 中加载页面信息。timeout设置连接超时时间 post提交方式 或者get()
            // Document document = (Document)
            // Jsoup.connect("http://haoma.imobile.com.cn/index.php?mob=18710115102").timeout(3000).post();

            // Elements 是 Element 的集合类
            Elements element = doc.select("table"); // 从加载的信息中查找table 标签

            // 从查找到table属性的Elements集合中获取标签 tr 或者tr[class$=alt] 表示
            // tr标签内class属性=alt
            // Elements titleName=element.select("tr[class$=alt]");
            Elements titleName = element.select("tr");
            for (Element name : titleName) {
                System.out.println(name.text());
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static HttpMethod getPostMethod(String phone) {
        PostMethod post = new PostMethod("/index.php");
        // POST提交则需要通过NameValuePair类来设置参数名和对应的值
        NameValuePair simcard = new NameValuePair("mob", phone);
        post.setRequestBody(new NameValuePair[]{simcard});
        return post;
    }

    /**
     * 使用 GET 方式提交数据
     *
     * @return
     */

    private static HttpMethod getGetMethod() {
        return new GetMethod("/index.php?simcard=1330227");
    }

}
