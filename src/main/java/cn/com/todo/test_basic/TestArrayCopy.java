package cn.com.todo.test_basic;

import java.util.Arrays;

/**
 * 
 * @author zxp
 * 
 *         System�ṩ��һ����̬����arraycopy(),���ǿ���ʹ������ʵ������֮��ĸ��ơ��亯��ԭ���ǣ� public static
 *         void arraycopy(Object src, int srcPos, Object dest, int destPos, int
 *         length) src:Դ���飻 srcPos:Դ����Ҫ���Ƶ���ʼλ�ã� dest:Ŀ�����飻 destPos:Ŀ��������õ���ʼλ�ã�
 *         length:���Ƶĳ��ȡ� ע�⣺src and dest��������ͬ���ͻ��߿��Խ���ת�����͵����飮
 *         ��Ȥ���������������ʵ���Լ����Լ����ƣ����磺 int[] fun ={0,1,2,3,4,5,6};
 *         System.arraycopy(fun,0,fun,3,3); ����Ϊ��{0,1,2,0,1,2,6};
 *         ʵ�ֹ����������ģ�������һ������Ϊlength����ʱ����,��fun������srcPos
 *         ��srcPos+length-1֮������ݿ�������ʱ�����У���ִ��System.arraycopy(��ʱ����,0,fun,3,3).
 * 
 */
public class TestArrayCopy {
	public static void main(String args[]) {

		// arraycopy1();
		// arraycopy2();
		// arraycopy3();
		// clone2();
		arrayscopyof();
	}

	static void arraycopy1() {
		int a[] = { 1, 2, 3 };
		int b[] = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length); // ͨ��arraycopy()������������
		b[0] = 4; // �ı�����b[0]��ֵ
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
		System.arraycopy(a, 0, b, 0, a.length); // ͨ��arraycopy()������������
		// b[0][0] = 4; // �ı�����b[0][0]��ֵ
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

		Arrays.sort(arr1);// ����
		System.out.println(Arrays.toString(arr1));
	}
}