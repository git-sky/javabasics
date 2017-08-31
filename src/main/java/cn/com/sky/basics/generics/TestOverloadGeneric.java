package cn.com.sky.basics.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型擦除
 *
 */
public class TestOverloadGeneric {

	public static String method(List<String> list) {
		System.out.println("List<String> list");
		return "";
	}

	// public static int method(List<Integer> list) {
	// System.out.println("List<Integer> list");
	// return 1;
	// }

	public static void main(String args[]) {
		method(new ArrayList<String>());
		// method(new ArrayList<Integer>());
	}

}
