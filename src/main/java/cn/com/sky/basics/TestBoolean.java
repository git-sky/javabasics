package cn.com.sky.basics;

/**
 * 答案是：c
 */
public class TestBoolean {

	public static void main(String[] args) {
		boolean bool = true;
		// System.out.println(bool = false);
		if (bool = false) {// bool赋值为false
			System.out.println("a");
		} else if (bool) {
			System.out.println("b");
		} else if (!bool) {
			System.out.println("c");
		} else {
			System.out.println("d");
		}

	}
}
