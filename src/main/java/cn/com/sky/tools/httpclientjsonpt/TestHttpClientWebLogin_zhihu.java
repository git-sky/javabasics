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
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 模拟登陆知乎平台并设置
 * 
 * @author zxp
 * 
 */

public class TestHttpClientWebLogin_zhihu {

	public static void main(String[] args) {

		// 创建默认的httpClient实例.
		HttpClient httpclient = new DefaultHttpClient();

		//设置自动跳转
		((AbstractHttpClient) httpclient)
				.setRedirectStrategy(new LaxRedirectStrategy());
		
		login_web(httpclient);//登录
		verify_password(httpclient);//设置

		httpclient.getConnectionManager().shutdown();
	}

	private static void login_web(HttpClient httpclient) {

		// 创建httppost
		HttpPost httppost = new HttpPost("http://www.zhihu.com/login");

		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		formparams.add(new BasicNameValuePair("_xsrf",
				"5c726f857fd341e484fa234d6d373732"));
		formparams.add(new BasicNameValuePair("email", "xxxxxxxxxx@qq.com"));
		formparams.add(new BasicNameValuePair("password", "xxxxxxx"));
		formparams.add(new BasicNameValuePair("rememberme", "y"));

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

	private static void verify_password(HttpClient httpclient) {

		// 创建httpget
		HttpGet httpget = new HttpGet("http://www.zhihu.com/settings/account");

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
