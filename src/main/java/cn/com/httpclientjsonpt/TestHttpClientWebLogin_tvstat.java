package cn.com.httpclientjsonpt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import org.apache.http.util.EntityUtils;

/**
 * 模拟登陆tv统计平台并且查询报表
 * *
 */
public class TestHttpClientWebLogin_tvstat {

    public static void main(String[] args) {

        // 创建默认的httpClient实例.
        HttpClient httpclient = new DefaultHttpClient();

        get_code(httpclient);
        login_web(httpclient);
        query_report(httpclient);

        httpclient.getConnectionManager().shutdown();
    }

    private static void get_code(HttpClient httpclient) {

        try {
            // 创建httpget
            HttpGet httpget = new HttpGet(
                    "http://tvstat.in.kuyun.com/tvstat/confirmcode.jsp");
            System.out.println("executing request " + httpget.getURI());

            // 执行get请求.
            HttpResponse response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            System.out.println("--------------------------------------");

            // 把生成的验证码保存下来
            File file = new File("f:/loginimg.jpg");
            OutputStream ops = new FileOutputStream(file);
            entity.writeTo(ops);

            // 打印响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                // 打印响应内容长度
                System.out.println("Response content length: "
                        + entity.getContentLength());
                // // 打印响应内容
                // System.out.println("Response content: "
                // + EntityUtils.toString(entity));
            }
            System.out.println("------------------------------------");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void login_web(HttpClient httpclient) {

        System.out.println("输入用户名:");
        Scanner scr = new Scanner(System.in);
        String user_name = scr.nextLine();

        System.out.println("输入密码:");
        scr = new Scanner(System.in);
        String password = scr.nextLine();

        // 输入验证码
        System.out.println("输入验证码:");
        scr = new Scanner(System.in);
        String code = scr.nextLine();

        // 创建httppost
        HttpPost httppost = new HttpPost(
                "http://tvstat.in.kuyun.com/tvstat/login.do");
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        formparams.add(new BasicNameValuePair("username", user_name));
        formparams.add(new BasicNameValuePair("password", password));
        formparams.add(new BasicNameValuePair("confirmcode", code));

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            HttpResponse response = httpclient.execute(httppost);
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

    private static void query_report(HttpClient httpclient) {

        // 创建httppost
        HttpPost httppost = new HttpPost(
                "http://tvstat.in.kuyun.com/tvstat/GetDataTable");
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();


        formparams.add(new BasicNameValuePair("default", ""));
        formparams.add(new BasicNameValuePair("reportId", "103"));
        formparams.add(new BasicNameValuePair("sortColumn", "uv"));
        formparams.add(new BasicNameValuePair("sortType", "desc"));
        formparams.add(new BasicNameValuePair("begin", "20130901"));
        formparams.add(new BasicNameValuePair("end", "20130905"));
        formparams.add(new BasicNameValuePair("frequency", "day"));
        formparams.add(new BasicNameValuePair("show_result", "yes"));
        formparams.add(new BasicNameValuePair("numPerPage", "30"));
        formparams.add(new BasicNameValuePair("product_", "29"));

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            HttpResponse response = httpclient.execute(httppost);
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
