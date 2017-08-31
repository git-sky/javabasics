package cn.com.sky.basics.exceptions;

public class TestCatchException {

	public static void main(String ars[]) {
		int i = 1;
		try {
			System.out.println("result=" + new TestCatchException().test(i));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int test(int i) throws Exception {
		try {
			if (i == 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
//		
		System.out.println("..............");
		return 2;
	}
}
