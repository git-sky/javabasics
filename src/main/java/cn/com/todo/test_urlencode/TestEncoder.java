package cn.com.todo.test_urlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 
 * ���룺URLEncoder.encode(String s, String enc)
 * ����: URLDecoder.decode(String s, String enc)
 * 
 */

public class TestEncoder {

	public static void main(String args[]) {

		try {
			String str = URLEncoder.encode("��ʿ���dfas33ddsd���ٷ�", "utf-8");

			System.out.println(str);

			String str2 = URLDecoder.decode(str, "utf-8");

			System.out.println(str);
			System.out.println(str2);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
