package cn.com.todo.test_httpclientJsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Top100Mp3Downloader {

	private static final String MJ_INDEX = "http://www.top100.cn/artist/songs.php?singerid=1669";
	// http://www.top100.cn/artist/info-agr5dcqe.shtml
	// http://www.top100.cn/artist/songs.php?singerid=1669

	private static final String DOWNLOAD = "http://www.top100.cn/download/download.php?Productid=";

	/**
	 * ���������б�ҳ��,���ظ������ƺͼ���id�ļ�ֵ��
	 * 
	 * @param url
	 *            �����б��ַ,��:http://www.top100.cn/artist/info-agr5dcqe.shtml
	 * @return ��ֵ��
	 */
	private Map<String, String> findIds(String url) {
		try {
			URL u = new URL(url);
			Document doc = Jsoup.parse(u, 1000 * 10);
			Element listDiv = doc.getElementById("songsListDiv");
			Elements uls = listDiv.getElementsByTag("ul");
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < uls.size(); i++) {
				Element ul = uls.get(i);
				Element hidden = ul.getElementById("hidValue");
				String id = hidden.val();
				Element li = ul.getElementsByAttributeValue("class", "No2")
						.first();
				Element href = li.getElementsByTag("a").first();
				String name = href.attr("title");

				map.put(name, id);
			}
			return map;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �Ӹ����ļ���id��ȡ����������ҳ��,�������õ����ص�ַ
	 * 
	 * @param id
	 *            ����id
	 * @return ��������ҳ���ַ
	 */
	private String findDownPathById(String id) {
		if (id.startsWith("m")) {// ����id����m��ͷ
			id = id.substring(1);
		}
		String path = "http://www.top100.cn";
		URL url = null;
		try {
			url = new URL(DOWNLOAD + id);
			Document doc = Jsoup.parse(url, 1000 * 2);
			Elements lis = doc.select(".Listen_downloadtopcon ul li");
			path += lis.get(5).getElementsByTag("a").first().attr("href");
			// for (int i = 0; i < lis.size(); i++) {
			// Element e = lis.get(i);
			// if (e.tagName().equals("a")) {
			// path = e.attr("href");
			// break;
			// }
			// }
		} catch (MalformedURLException e) {
			System.out.println("����url��" + url + "������");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�ļ����ش���");
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * �ӻ�ȡ�����ص�ַ��ȡ��������
	 * 
	 * @param dir
	 *            ���浽Ŀ¼
	 * @param name
	 *            ��������
	 * @param path
	 *            �������ص�ַ
	 */
	private void downByPath(String dir, String name, String path) {
		System.out.println("path=" + path);
		File parent = new File(dir);
		if (!parent.exists()) {
			parent.mkdirs();
		}
		File mp3 = new File(parent, name + ".mp3");
		try {
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// �˴�����α��referer,������Զ�������ҳ.������,��cookie�޹�
			con
					.setRequestProperty("User-Agent",
							"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon;)");
			con.setRequestProperty("Accept-Encoding", "gzip");
			con.setRequestProperty("referer", "http://www.top100.cn");
			con.setDoInput(true);
			con.connect();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream is = con.getInputStream();
				byte[] b = new byte[1024 * 5];
				int length = -1;
				OutputStream os = new FileOutputStream(mp3);
				while ((length = is.read(b)) != -1) {
					os.write(b, 0, length);
				}
				os.flush();
				os.close();
				is.close();
			} else {
				System.out.println("����������:" + con.getResponseCode());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Top100Mp3Downloader m = new Top100Mp3Downloader();
		for (Map.Entry<String, String> e : m.findIds(MJ_INDEX).entrySet()) {
			String name = e.getKey();
			String path = m.findDownPathById(e.getValue());
			m.downByPath("E:\\music\\files\\Michael Jackson1", name, path);
			System.out.println(name + " from " + path + " has down!");
		}
	}
}
