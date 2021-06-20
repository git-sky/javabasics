package cn.com.todo.test_httpclientJsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class TestURL {
	public static void main(String[] args) {

		TestURL tu = new TestURL();
		// tu.url();
		 tu.inetAddress();
////		tu.readURL();
////		tu.sendGet();
//		tu.sendPost();

	}

	void url() {
		try {

			// ��getDefaultPort()�� ����Ĭ�ϵĶ˿ںš�
			// ����getFile()�� ���URLָ����Դ�������ļ�����
			// ����getHost()�� ������������
			// ����getPath()�� ����ָ����Դ���ļ�Ŀ¼���ļ�����
			// ����getPort()�� ���ض˿ںţ�Ĭ��Ϊ-1��
			// ����getProtocol()�� ���ر�ʾURL��Э����ַ�������
			// ����getRef()�� ����URL�е�HTML�ĵ���ǣ���#�ű�ǡ�
			// ����getUserInfo�� �����û���Ϣ��
			// ����toString�� ����������URL�ַ�����

			URL hecnyurl = new URL("http://www.hokoexp.com/hecny/login.jsp");
			System.out.println(hecnyurl.getContent());
			System.out.println(hecnyurl.getHost());
			System.out.println(hecnyurl.getPort());
			System.out.println(hecnyurl.getProtocol());
			System.out.println(hecnyurl.getFile());
			System.out.println(hecnyurl.getPath());
			System.out.println(hecnyurl.getAuthority());
			System.out.println(hecnyurl.getDefaultPort());
			System.out.println(hecnyurl.getQuery());
			System.out.println(hecnyurl.getRef());
			System.out.println(hecnyurl.getUserInfo());
			System.out.println(hecnyurl.getClass());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void inetAddress() {

		// ����java.net��������32λint��ʽ������32λ��IP��ַ(��Internet������ַ)����InetAddressʵ�����ǿ��԰�Internet��ַ����ɴ���õ�ַ�Ķ���Java���ǿ����������ʾInternet��ַ�Ѿ������Ϣ�ġ�
		// ����InetAddress�����³��÷�����
		// ����getAddress()�� ����IP��ַ���ֽ���ʽ��
		// ����getAllByName()�� ����ָ����������IP��ַ��
		// ����getbyAddress()�� ����ָ���ֽ������IP��ַ��ʽ��
		// ����getByName()�� ����ָ����������IP��ַ����
		// ����getHostAddress()�� ����������ַ���ַ�����ʽ��
		// ����getLocalHost()�� ���ص�ǰ��������
		// ����hastCode()�� ����InetAddress����Ĺ�ϣ�롣
		// ����toString�� ���ص�ַת���ɵ��ַ�����
		// ����InetAddress��û���ṩ���ع��캯�������Բ�����new()�������������Ķ��󣬶�ֻ���Ե��þ�̬����getLocalHost()��getByName()��getByAddress()��������InetAddress���ʵ�ʡ�

		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("������ַ�ַ���:" + address.getHostAddress());
			System.out.println("����������:" + address.getHostName());
			System.out.println("����������:" + InetAddress.getLocalHost());
			System.out.println("��ϣ��:" + address.hashCode());
			byte b[] = address.getAddress();
			System.out.println("�ַ���ʽ:" + b);
			System.out.println("��ַ�ַ���:" + address.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	// �����ַ���������������Internet��һ������URL���openStream()����������ʹ��openConnection()��������һ��URLConnection��Ķ���
	// �������У�����openStream()��ָ����URL�������Ӳ�����InputStream��Ķ����Դ���һ�����ж�ȡ���ݡ�openStream()����ֻ�ܶ�ȡ������Դ����Ҫ���ܶ�ȡ���ܷ������ݣ���Ҫ�õ�URL���openConnection()����������һ��
	// URLConnection��Ķ��󣬴˶����ڱ��ػ���URLָ����Զ�̽ڵ㽨��һ��HTTPЭ�������ͨ�����ɽ���˫�����ݴ��䡣

	void readURL() {
		try {
			URL url = new URL("http://www.baidu.com");
			InputStreamReader isr = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(isr);

			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}

			br.close();
			isr.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		 try {
		 URL url = new URL(
		 "http://campus4.chinaacc.com/MessageBoard.aspx?groupID=1991");
		 InputStream is = url.openStream();
		
		 BufferedReader in = new BufferedReader(new InputStreamReader(is,
		 "UTF-8"));
		 String readLine = in.readLine();
		 while (readLine != null) {
		 System.out.println(readLine);
		 readLine = in.readLine();
		 }
		 in.close();
		 is.close();
		 } catch (Exception e) {
		 System.out.println(e);
		 }

	}

	void sendGet() {
		String result = "";
		try {
			URL u = new URL("http://www.baidu.com");
			URLConnection conn = u.openConnection();
			conn.connect();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
		} catch (Exception e) {
			System.out.println("û�н����" + e);
		}
		System.out.println(result);
	}

	void sendPost() {
		String result = "";
		try {
			URL httpurl = new URL("http://www.baidu.com");
			HttpURLConnection httpConn = (HttpURLConnection) httpurl
					.openConnection();
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			PrintWriter out = new PrintWriter(httpConn.getOutputStream());
			out.print("");
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					httpConn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
		} catch (Exception e) {
			System.out.println("û�н����" + e);
		}
		System.out.println(result);
	}
}