package cn.com.sky.basics;

/**
 * static不能修饰局部变量
 */
public class TestStaticField {
	public static int a = 1;// 成员变量，允许

	public static void main(String[] args) {
		// static int b = 1;// 错误,static不能修饰局部变量
	}

}
