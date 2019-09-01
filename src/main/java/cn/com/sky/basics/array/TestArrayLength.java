package cn.com.sky.basics.array;

import java.util.ArrayList;

public class TestArrayLength {

	public static void main(String[] args) {

		// 数组是length属性
		String[] a = new String[10];
		System.out.println(a.length);

		// String对象是length()方法
		String b = "";
		b.length();
		System.out.println(b.length());

		// list是size()方法
		ArrayList list = new ArrayList();
		list.size();
		System.out.println(list.size());

	}
}
