package cn.com.sky.tools.httpclientjsonpt;

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

			// 　getDefaultPort()： 返回默认的端口号。
			// 　　getFile()： 获得URL指定资源的完整文件名。
			// 　　getHost()： 返回主机名。
			// 　　getPath()： 返回指定资源的文件目录和文件名。
			// 　　getPort()： 返回端口号，默认为-1。
			// 　　getProtocol()： 返回表示URL中协议的字符串对象。
			// 　　getRef()： 返回URL中的HTML文档标记，即#号标记。
			// 　　getUserInfo： 返回用户信息。
			// 　　toString： 返回完整的URL字符串。

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

		// 　　java.net包可以用32位int形式来操作32位的IP地址(即Internet主机地址)。类InetAddress实际上是可以把Internet地址换算成代表该地址的对象。Java就是靠这个类来显示Internet地址已经相关信息的。
		// 　　InetAddress有以下常用方法：
		// 　　getAddress()： 返回IP地址的字节形式。
		// 　　getAllByName()： 返回指定主机名的IP地址。
		// 　　getbyAddress()： 返回指定字节数组的IP地址形式。
		// 　　getByName()： 返回指定主机名的IP地址对象。
		// 　　getHostAddress()： 返回主机地址的字符串形式。
		// 　　getLocalHost()： 返回当前主机名。
		// 　　hastCode()： 返回InetAddress对象的哈希码。
		// 　　toString： 返回地址转换成的字符串。
		// 　　InetAddress类没有提供返回构造函数，所以不能用new()方法来创建它的对象，而只可以调用静态方法getLocalHost()、getByName()、getByAddress()等来生成InetAddress类的实质。

		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("本机地址字符串:" + address.getHostAddress());
			System.out.println("本机主机名:" + address.getHostName());
			System.out.println("本机主机名:" + InetAddress.getLocalHost());
			System.out.println("哈希码:" + address.hashCode());
			byte b[] = address.getAddress();
			System.out.println("字符形式:" + b);
			System.out.println("地址字符串:" + address.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	// 有两种方法可以用来访问Internet。一是利用URL类的openStream()方法；二是使用openConnection()方法创建一个URLConnection类的对象。
	// 　　其中，方法openStream()与指定的URL建立连接并返回InputStream类的对象，以从这一连接中读取数据。openStream()方法只能读取网络资源，若要既能读取又能发送数据，则要用到URL类的openConnection()方法来创建一个
	// URLConnection类的对象，此对象在本地机和URL指定的远程节点建立一条HTTP协议的数据通道，可进行双向数据传输。

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
			System.out.println("没有结果！" + e);
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
			System.out.println("没有结果！" + e);
		}
		System.out.println(result);
	}
}