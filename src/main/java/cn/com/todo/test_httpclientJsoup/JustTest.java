package cn.com.todo.test_httpclientJsoup;

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
 * ����HttpClient��ȡhtml���룬Ȼ��ʹ��jsoup��html������н���
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
			// ���ϴ������˼�� ��idΪ��page����div���� idΪ��content����div���� idΪ��main����div����
			// classΪ��left����div���� idΪ��recommend����div����ul����li����a��ǩ
			for (Element ele : linksElements) {
				String href = ele.attr("href");
				String title = ele.text();
				System.out.println(href + "," + title);
			}
		}
	}

	/**
	 * ����URL������е�html��Ϣ
	 * 
	 * @param url
	 * @return
	 */
	public static String getHtmlByUrl(String url) {
		String html = null;
		HttpClient httpClient = new DefaultHttpClient();// ����httpClient����
		HttpGet httpget = new HttpGet(url);// ��get��ʽ�����URL
		try {
			HttpResponse responce = httpClient.execute(httpget);// �õ�responce����
			int resStatu = responce.getStatusLine().getStatusCode();// ������
			if (resStatu == HttpStatus.SC_OK) {// 200���� �����Ͳ���
				// �����Ӧʵ��
				HttpEntity entity = responce.getEntity();
				if (entity != null) {
					html = EntityUtils.toString(entity);// ���htmlԴ����
					System.out.println(html);
				}
			}
		} catch (Exception e) {
			System.out.println("���ʡ�" + url + "�������쳣!");
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return html;
	}
}