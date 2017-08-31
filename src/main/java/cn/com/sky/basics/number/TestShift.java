package cn.com.sky.basics.number;

public class TestShift {

	public static void main(String[] args) {

		int number = 10;
		// 原始数二进制
		printInfo(number);

		// 左移一位
		number = number << 1;
		printInfo(number);

		// 右移一位
		number = number >> 1;
		printInfo(number);

		// 无符号右移一位,无符号右移，忽略符号位，空位以0补齐。
		number = number >>> 1;
		printInfo(number);

	}

	/**
	 * 输出一个int的二进制数
	 */
	private static void printInfo(int num) {
		System.out.println(num);
		System.out.println(Integer.toBinaryString(num));
	}
}