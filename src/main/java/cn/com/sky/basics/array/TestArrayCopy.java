package cn.com.sky.basics.array;

import java.util.Arrays;

/**
 * <pre>
 * 
 * System提供了一个静态方法arraycopy(),我们可以使用它来实现数组之间的复制。
 *  其函数原型是： public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 * src:源数组； 
 * srcPos:源数组要复制的起始位置； 
 * dest:目的数组；
 *  destPos:目的数组放置的起始位置； 
 *  length:复制的长度。
 *  
 * 注意：src 与 dest都必须是同类型或者可以进行转换类型的数组． 
 * 有趣的是这个函数可以实现自己到自己复制，
 * 比如： int[] fun ={0,1,2,3,4,5,6}; 
 * System.arraycopy(fun,0,fun,3,3); 
 * 则结果为：{0,1,2,0,1,2,6};
 * 实现过程是这样的，先生成一个长度为length的临时数组,
 * 将fun数组中srcPos到srcPos+length-1之间的数据拷贝到临时数组中，
 * 再执行System.arraycopy(临时数组,0,fun,3,3).
 * 
 * </pre>
 * 
 */
public class TestArrayCopy {

	public static void main(String args[]) {

		// Java数组拷贝的四种方法：for、clone、System.arraycopy、Arrays.copyOf

		// System.arraycopy 一维数组
		arraycopy1();
		// System.arraycopy 二维数组
		arraycopy2();
		// System.arraycopy 复制自身
		arraycopy3();
		// clone方法
		clone2();
		// Arrays.copyOf
		arrayscopyof();
	}

	static void arraycopy1() {
		int a[] = { 1, 2, 3 };
		int b[] = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length); // 通过arraycopy()函数拷贝数组
		b[0] = 4; // 改变数组b[0]的值
		System.out.println("a[]:");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("------------");
		System.out.println("b[]:");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

	static void arraycopy2() {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int b[][] = new int[a.length][a[0].length];
		System.arraycopy(a, 0, b, 0, a.length); // 通过arraycopy()函数拷贝数组
		// b[0][0] = 4; // 改变数组b[0][0]的值
		System.out.println("a[][]");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("b[][]");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void arraycopy3() {
		int[] fun = { 0, 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < fun.length; i++) {
			System.out.println(fun[i]);
		}
		System.out.println("------------");
		System.arraycopy(fun, 0, fun, 3, 3);
		for (int i = 0; i < fun.length; i++) {
			System.out.println(fun[i]);
		}
		System.out.println("------------");
	}

	static void clone2() {
		int[] fun = { 0, 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < fun.length; i++) {
			System.out.println(fun[i]);
		}
		System.out.println("------------");

		int[] f = fun.clone();
		f[0] = 5;
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i]);
		}
		System.out.println("------------");
	}

	static void arrayscopyof() {

		int[] arr1 = { 10, 50, 40, 30 };

		int[] arr2 = Arrays.copyOf(arr1, 3);
		System.out.println(Arrays.toString(arr2));

		int[] arr3 = Arrays.copyOf(arr1, 4);
		System.out.println(Arrays.toString(arr3));

		int[] arr4 = Arrays.copyOf(arr1, 6);
		System.out.println(Arrays.toString(arr4));

		Arrays.sort(arr1);// 排序
		System.out.println(Arrays.toString(arr1));
	}
}