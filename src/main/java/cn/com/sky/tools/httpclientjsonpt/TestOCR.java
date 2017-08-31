package cn.com.sky.tools.httpclientjsonpt;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.asprise.util.ocr.OCR;

/**
 * 23
 * 
 * @title: test2.java 24
 * @package 25
 * @description: TODO 26
 * @author caiyigo 27
 * @date 2012-9-15 下午9:17:59 28
 * @version v1.00 29
 */
public class TestOCR {
	public static void main(String[] args) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(
					"http://sportsgo.test.kuyun.com/tv_sportsgo_api/kaptcha.jpg");
			System.out.println(System.getProperty("java.library.path"));

			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			System.out.println("获取验证码: " + response.getStatusLine());
			/* System.out.println(EntityUtils.toString(entity)); */
			InputStream is = entity.getContent();
			BufferedImage image = ImageIO.read(is);
			String imgcode = new OCR().recognizeEverything(image);

			System.out.println("\n---- 验证码是: ------- \n" + imgcode);
			HttpPost httpost = new HttpPost(
					"http://query.5184.com/query/zk/zk_seat_2012_07.jsp");
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("name0", "010411201317"));
			nvps.add(new BasicNameValuePair("rand", imgcode));
			nvps.add(new BasicNameValuePair("serChecked", "on"));
			httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));

			response = httpclient.execute(httpost);
			entity = response.getEntity();
			System.out.println(EntityUtils.toString(entity));
			System.out.println("返回: " + response.getStatusLine());
			System.out.println(response.getProtocolVersion());
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().getReasonPhrase());
			EntityUtils.consume(entity);

		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
}
