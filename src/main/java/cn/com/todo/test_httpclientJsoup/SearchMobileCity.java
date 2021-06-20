package cn.com.todo.test_httpclientJsoup;

import java.io.IOException;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

/**
 *�ύ������ʾ �ó������ӵ�һ�����ڲ�ѯ�ֻ����������ص�ҳ�� �Ա��ѯ�����1861041���ڵ�ʡ���Լ�����
 * 
 * @authorLiudong
 */

// http://www.114best.com/dh/114.aspx?w=1861041

public class SearchMobileCity {
	public static void main(String[] args) throws IOException {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost("www.114best.com", 80, "http");
		HttpMethod method = getPostMethod(); // ʹ�� POST ��ʽ�ύ����
		client.executeMethod(method); // ��ӡ���������ص�״̬
		System.out.println(method.getStatusLine()); // ��ӡ���ҳ��
		String response = new String(method.getResponseBodyAsString().getBytes(
				"ISO8859_1"));
		// ��ӡ���ص���Ϣ
		System.out.println(response);
		method.releaseConnection();
	}

	/**
	 * ʹ�� GET ��ʽ�ύ����
	 * 
	 * @return
	 */
	private static HttpMethod getGetMethod() {
		return new GetMethod("/dh/114.aspx?w=1861041");
	}

	/**
	 * ʹ�� POST ��ʽ�ύ����
	 * 
	 * @return
	 */
	private static HttpMethod getPostMethod() {
		PostMethod post = new PostMethod("/dh/114.aspx");
		NameValuePair simcard = new NameValuePair("w", "1861041");
		post.setRequestBody(new NameValuePair[] { simcard });
		return post;
	}
}
