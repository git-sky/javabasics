package cn.com.todo.test_basic;

import java.util.Arrays;

public class TestAsList {

	public static void main(String[] args) {
		int[] a1 = new int[] { 1, 2, 3 };
		String[] a2 = new String[] { "a", "b", "c" };

		Integer[] a3 = new Integer[] { 4, 5, 6 };

		// JDK5��asList���ܱ䳤�������ˣ���a1��Ϊ�����Ĳ������ݸ�asList������ʱ�򣬱��������������һ��Object�������Ƿ�����ֻ��һ��Ԫ�ص�List�������Ԫ��Ӧ�þ���ָ��int[]�����á�
		System.out.println(Arrays.asList(a1));
		System.out.println(Arrays.toString(a1));

		System.out.println(Arrays.asList(a2));
		System.out.println(Arrays.asList(a3));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(a3));
	}

}
