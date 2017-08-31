package cn.com.sky.tools.httpclientjsonpt;

import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.HttpStatus;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.util.EntityUtils;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;


/**
 * 利用HttpClient获取html代码，然后使用jsoup对html代码进行解析
 * @author Administrator
 *
 */
public class JustTest {
	public static void main(String[] args) {
		String html = getHtmlByUrl("http://www.iteye.com/");
		if (html != null && !"".equals(html)) {
			Document doc = Jsoup.parse(html);
			Elements linksElements = doc
					.select("div#page>div#content>div#main>div.left>div#recommend>ul>li>a");
			// 以上代码的意思是 找id为“page”的div里面 id为“content”的div里面 id为“main”的div里面
			// class为“left”的div里面 id为“recommend”的div里面ul里面li里面a标签
			for (Element ele : linksElements) {
				String href = ele.attr("href");
				String title = ele.text();
				System.out.println(href + "," + title);
			}
		}
	}

	/**
	 * 根据URL获得所有的html信息
	 * 
	 * @param url
	 * @return
	 */
	public static String getHtmlByUrl(String url) {
		String html = null;
		HttpClient httpClient = new DefaultHttpClient();// 创建httpClient对象
		HttpGet httpget = new HttpGet(url);// 以get方式请求该URL
		try {
			HttpResponse responce = httpClient.execute(httpget);// 得到responce对象
			int resStatu = responce.getStatusLine().getStatusCode();// 返回码
			if (resStatu == HttpStatus.SC_OK) {// 200正常 其他就不对
				// 获得相应实体
				HttpEntity entity = responce.getEntity();
				if (entity != null) {
					html = EntityUtils.toString(entity);// 获得html源代码
					System.out.println(html);
				}
			}
		} catch (Exception e) {
			System.out.println("访问【" + url + "】出现异常!");
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return html;
	}
}