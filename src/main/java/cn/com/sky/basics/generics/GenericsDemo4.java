package cn.com.sky.basics.generics;

/**
 * 泛型方法
 */
class Demo {
	public <T> T fun(T t) { // 可以接收任意类型的数据
		return t; // 直接把参数返回
	}
}

public class GenericsDemo4 {
	public static void main(String args[]) {
		Demo d = new Demo();

		String str = d.fun("汤姆");
		System.out.println(str);

		int i = d.fun(30);
		System.out.println(i);

	}
}