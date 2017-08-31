package cn.com.sky.basics.exceptions;

public class TestCatch {

	public static void main(String ars[]) {

		// 最终的值，是return的值，不是fianlly中的值。
		System.out.println("result=" + new TestCatch().test());

	}

	public int test() {
		int x;
		// System.out.println(x);
		try {
			x = 1;
			System.out.println("try:" + x);
			 throw new Exception();
//			return x;

		} catch (Exception e) {
			x = 2;
			System.out.println("catch:" + x);
			return x;

		} finally {
			x = 3;
			System.out.println("finally:" + x);
			// return x;// 不能在finally块中使用return，finally块中的return返回后方法结束执行，不会再执行try块中的return语句。
		}
	}
}
