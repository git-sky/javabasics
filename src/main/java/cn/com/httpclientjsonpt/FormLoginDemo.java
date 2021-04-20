package cn.com.httpclientjsonpt;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.*;
import org.apache.commons.httpclient.methods.*;

/**
 * 用来演示登录表单的示例
 *
 */
//http://www.iteye.com/login
//http://58.248.254.37/ReaderStatmanage
public class FormLoginDemo {
    static final String LOGON_SITE = "58.248.254.37";
    static final int LOGON_PORT = 8080;

    public static void main(String[] args) throws Exception {
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT, "http");

        // 模拟登录页面 login.jsp->main.jsp
        PostMethod post = new PostMethod("/ReaderStatmanage/login.jsp");
        NameValuePair name = new NameValuePair("username", "sysadmin");
        NameValuePair pass = new NameValuePair("password", "superadmin");
        post.setRequestBody(new NameValuePair[]{name, pass});
        int status = client.executeMethod(post);
        System.out.println(post.getResponseBodyAsString());
        post.releaseConnection();

        // 查看 cookie 信息
        CookieSpec cookiespec = CookiePolicy.getDefaultSpec();
        Cookie[] cookies = cookiespec.match(LOGON_SITE, LOGON_PORT, "/", false,
                client.getState().getCookies());
        if (cookies.length == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < cookies.length; i++) {
                System.out.println(cookies[i].toString());
            }
        }

        // 访问所需的页面 main2.jsp
//		GetMethod get = new GetMethod("/main.jsp");
//		client.executeMethod(get);
//		System.out.println(get.getResponseBodyAsString());
//		get.releaseConnection();
    }
}
