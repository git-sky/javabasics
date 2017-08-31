package cn.com.sky.basics.strings;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestString2 extends Object {

	public static void main(String[] args) {
		String a = new String("abc");
		String b = new String("edf");
		System.out.println(test1(a, b));

		String icon = String.valueOf(null == null ? "" : "b");
		System.out.println(icon);

		System.out.println(String.valueOf(null));
	}

	public static String test1(String a, String b) {
		a = new String("aaaaaaaa");
		return a;
	}

	@Test
	public void testEquals() {
		String a = "";
		System.out.println(a == "");
		System.out.println("".equals(a));
	}

	@Test
	public void testcontains() {
		String src = "13";
		String dest = "5,14,17,2";
		String[] values = dest.split(",");
		List<String> list = Arrays.asList(values);
		System.out.println(list.contains(src));
	}

	@Test
	public void aa() {
		String a = new String("a");
		System.out.println(a);
		a = new String("b");
		System.out.println(a);
		a.substring(0);

	}

}
