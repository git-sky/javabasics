package cn.com.sky.basics.strings;

/**
 * <pre>
 * 
 * 1、同一个字符串常量，在常量池只有一份副本；
 * 2、通过双引号声明的字符串，直接保存在常量池中；
 * 3、如果是String对象，可以通过String.intern方法，把字符串常量保存到常量池中；
 * 
 * </pre>
 */
public class StringEquals {
	public static void main(String args[]) {
		String a = new String("abc");
		String b = new String("abc");
		String c = "abc";
		String d = "abc";
		System.out.println(a.equals(b));// true
		System.out.println(a.equals(c));// true
		System.out.println(b.equals(c));// true
		System.out.println(a == b);// false
		System.out.println(a == c);// false
		System.out.println(b == c);// false

		System.out.println(c == d);// true

		String a1 = "abc";
		String b1 = "ab";
		String c1 = b1 + "c";
		System.out.println(c1);// abc
		System.out.println(a1.equals(c1)); // true
		System.out.println(a1 == c1); // false

		int i = 1;
		int j = 2;
		double k = 1.2;
		String s = "0";
		System.out.println(i + s + j + k);// 1021.2

		String s1 = new String();

		String s2 = new String("");

		String s3 = new String();
		String s4 = new String("");

		System.out.println(s1.equals(s2));// true
		System.out.println(s1 == s2);// false
		System.out.println(s1 == s3);// false
		System.out.println(s1.equals(s3));// true
		System.out.println(s2 == s4);// false

		Integer aa = null;

		System.out.println(2 == aa);

	}

}