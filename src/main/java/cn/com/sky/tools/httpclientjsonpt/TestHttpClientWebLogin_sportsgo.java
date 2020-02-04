package cn.com.sky.tools.httpclientjsonpt;

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
 * 模拟登陆sportsgo测试平台并且修改密码
 */

public class TestHttpClientWebLogin_sportsgo {

    public static void main(String[] args) {

        // 创建默认的httpClient实例.
        HttpClient httpclient = new DefaultHttpClient();

        get_code(httpclient);
        login_web(httpclient);
        verify_password(httpclient);
        modify_password(httpclient);

        httpclient.getConnectionManager().shutdown();
    }

    private static void get_code(HttpClient httpclient) {

        try {
            // 创建httpget
            HttpGet httpget = new HttpGet(
                    "http://sportsgo.test.kuyun.com/tv_sportsgo_api/kaptcha.jpg");
            System.out.println("executing request " + httpget.getURI());

            // 执行get请求.
            HttpResponse response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            System.out.println("--------------------------------------");

            // 把生成的验证码保存下来
            File file = new File("f:/regist.jpg");
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
                "http://sportsgo.test.kuyun.com/tv_sportsgo_api/api/user/");
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        formparams.add(new BasicNameValuePair("Action", "user"));
        formparams.add(new BasicNameValuePair("cmd", "login"));
        formparams.add(new BasicNameValuePair("test", "tenfen"));
        formparams.add(new BasicNameValuePair("user_name", user_name));
        formparams.add(new BasicNameValuePair("password", password));
        formparams.add(new BasicNameValuePair("verify_code", code));

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

    private static void verify_password(HttpClient httpclient) {

        // 创建httppost
        HttpPost httppost = new HttpPost(
                "http://sportsgo.test.kuyun.com/tv_sportsgo_api/api/user/");
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        formparams.add(new BasicNameValuePair("Action", "user"));
        formparams.add(new BasicNameValuePair("cmd", "verify_password"));
        formparams.add(new BasicNameValuePair("password", "123"));

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            // System.out.println("executing request " + httppost.getURI());
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

    private static void modify_password(HttpClient httpclient) {

        System.out.println("输入新密码:");
        // 输入新密码
        Scanner scr = new Scanner(System.in);
        String new_pass = scr.nextLine();

        // 创建httppost
        HttpPost httppost = new HttpPost(
                "http://sportsgo.test.kuyun.com/tv_sportsgo_api/api/user/");
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        formparams.add(new BasicNameValuePair("Action", "user"));
        formparams.add(new BasicNameValuePair("cmd", "modify_password"));
        formparams.add(new BasicNameValuePair("password", new_pass));

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            // System.out.println("executing request " + httppost.getURI());
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
