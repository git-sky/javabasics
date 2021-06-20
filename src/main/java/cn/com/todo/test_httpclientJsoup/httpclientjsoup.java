package cn.com.todo.test_httpclientJsoup;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class httpclientjsoup {

	/**
	 * heepclient ץȡҳ�� jroup ����ҳ������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("�������ֻ����룺");
		String strphone = reader.nextLine();

		HttpClient client = new HttpClient();
		// ���ô����������ַ(URL)�Ͷ˿�
		client.getHostConfiguration().setHost("haoma.imobile.com.cn", 80);
		HttpMethod method = getPostMethod(strphone);
		try {
			client.executeMethod(method);
			// System.out.println(method.getStatusLine()); //��ӡ���ҳ��
			String response = new String(method.getResponseBodyAsString());

			 System.out.println(response);
			// �ͷ�����
			method.releaseConnection();

			// ����ҳ������
			Document doc = Jsoup.parse(response); // ���ַ����м���
			// ֱ�Ӵ�URL �м���ҳ����Ϣ��timeout�������ӳ�ʱʱ�� post�ύ��ʽ ����get()
			// Document document = (Document)
			// Jsoup.connect("http://haoma.imobile.com.cn/index.php?mob=18710115102").timeout(3000).post();

			// Elements �� Element �ļ�����
			Elements element = doc.select("table"); // �Ӽ��ص���Ϣ�в���table ��ǩ

			// �Ӳ��ҵ�table���Ե�Elements�����л�ȡ��ǩ tr ����tr[class$=alt] ��ʾ
			// tr��ǩ��class����=alt
			// Elements titleName=element.select("tr[class$=alt]");
			Elements titleName = element.select("tr");
			for (Element name : titleName) {
				System.out.println(name.text());
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static HttpMethod getPostMethod(String phone) {
		PostMethod post = new PostMethod("/index.php");
		// POST�ύ����Ҫͨ��NameValuePair�������ò������Ͷ�Ӧ��ֵ
		NameValuePair simcard = new NameValuePair("mob", phone);
		post.setRequestBody(new NameValuePair[] { simcard });
		return post;
	}

	/**
	 * ʹ�� GET ��ʽ�ύ����
	 * 
	 * @return
	 */

	private static HttpMethod getGetMethod() {
		return new GetMethod("/index.php?simcard=1330227");
	}

}
