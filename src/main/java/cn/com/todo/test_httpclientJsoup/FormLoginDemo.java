package cn.com.todo.test_httpclientJsoup;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.*;
import org.apache.commons.httpclient.methods.*;

/**
 * ������ʾ��¼����ʾ��
 * 
 * @author Liudong
 */
//http://www.iteye.com/login
//http://58.248.254.37/ReaderStatmanage
public class FormLoginDemo {
	static final String LOGON_SITE = "58.248.254.37";
	static final int LOGON_PORT = 8080;

	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT,"http");

		// ģ���¼ҳ�� login.jsp->main.jsp
		PostMethod post = new PostMethod("/ReaderStatmanage/login.jsp");
		NameValuePair name = new NameValuePair("username", "sysadmin");
		NameValuePair pass = new NameValuePair("password", "superadmin");
		post.setRequestBody(new NameValuePair[] { name, pass });
		int status = client.executeMethod(post);
		System.out.println(post.getResponseBodyAsString());
		post.releaseConnection();

		// �鿴 cookie ��Ϣ
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

		// ���������ҳ�� main2.jsp
//		GetMethod get = new GetMethod("/main.jsp");
//		client.executeMethod(get);
//		System.out.println(get.getResponseBodyAsString());
//		get.releaseConnection();
	}
}
