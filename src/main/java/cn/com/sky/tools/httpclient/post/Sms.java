package cn.com.sky.tools.httpclient.post;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.com.sky.tools.diamond.ReloadableConfig;

import com.alibaba.fastjson.JSONObject;


public class Sms {

	private static String url = ReloadableConfig.getString("smsAddressHttp");
	private static String businessName = ReloadableConfig.getString("businessName");
	private static String templateId = ReloadableConfig.getString("templateId");

	public static void httpPostWithJSON(String url) throws Exception {

		HttpPost httpPost = new HttpPost(url);
		HttpClient client = new DefaultHttpClient();

		// json方式
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("money", "23.55");

		// 表单方式
		List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
		pairList.add(new BasicNameValuePair("businessName", businessName));
		pairList.add(new BasicNameValuePair("userId", "100011897952"));
		pairList.add(new BasicNameValuePair("templateId", templateId));
		pairList.add(new BasicNameValuePair("parameter", jsonParam.toString()));
		UrlEncodedFormEntity entry = new UrlEncodedFormEntity(pairList, "utf-8");
		httpPost.setEntity(entry);

		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			String result = EntityUtils.toString(he, "UTF-8");
			System.out.println(result);
			JSONObject json = JSONObject.parseObject(result);
			Boolean success = json.getBoolean("success");
			String message = json.getString("message");
			Integer code = json.getInteger("code");
			if (success) {
				System.out.println("Send sms success!!!");
			} else {
				System.out.println("Send sms failed!!! result:" + result);
			}
		} else {
			System.out.println("Send sms failed!!! response status is :" + resp.getStatusLine().getStatusCode());
		}
	}

	public static void main(String[] args) {
		try {
			httpPostWithJSON(url);
		} catch (Exception e) {
			System.out.println("Send sms ocur a exception!!! ");
		}
	}
}