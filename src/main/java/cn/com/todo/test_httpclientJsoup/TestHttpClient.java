package cn.com.todo.test_httpclientJsoup;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 *��򵥵�HTTP�ͻ���,������ʾͨ��GET����POST��ʽ����ĳ��ҳ��
 * 
 * @authorLiudong
 */
public class TestHttpClient {
	public static void main(String[] args) throws IOException {
		HttpClient client = new HttpClient();
		// ���ô����������ַ�Ͷ˿�

		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		// ʹ�� GET ���� �������������Ҫͨ�� HTTPS ���ӣ���ֻ��Ҫ������ URL �е� http ���� https
		HttpMethod method = new GetMethod("http://tieba.baidu.com/");
		// ʹ��POST����
		// HttpMethod method = new PostMethod("http://java.sun.com");
		client.executeMethod(method);

		
		//System.out.println("a");
		
		// ��ӡ���������ص�״̬
		System.out.println(method.getStatusLine());
//		// ��ӡ���ص���Ϣ
		System.out.println(method.getResponseBodyAsString());
		// �ͷ�����
		method.releaseConnection();
	}
}
