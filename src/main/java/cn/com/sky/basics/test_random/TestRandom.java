package cn.com.sky.basics.test_random;

import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 【强制】注意 Math.random() 这个方法返回是double类型，注意取值范围 0≤x<1（能够取到零值，注意除零异常），
 * 如果想获取整数类型的随机数，不要将x放大10的若干倍然后取整，直接使用Random对象的nextInt或者nextLong方法。
 * 
 * </pre>
 */
public class TestRandom {

	/**
	 * Math.Random()函数能够返回带正号的double值，该值大于等于0.0且小于1.0，即取值范围是[0.0,1.0)的左闭右开区间，返回值是一个伪随机选择的数，在该范围内（近似）
	 * 均匀分布。
	 * 
	 * Math.random()实际上是调用Random对象的nextDouble方法。
	 */
	@Test
	public void testMath() {

		for (int i = 0; i < 1000; i++) {
			double r = Math.random();// 产生的随机数是0-1之间的一个double
			System.out.println(r);

			double r2 = Math.random();// 产生的随机数是0-1之间的一个double
			System.out.println(r2);
		}
	}

	// 不带种子：
	// 此种方式将会返回随机的数字，每次运行结果不一样
	// 默认是使用“与当前系统时间有关的数字”作为种子数
	@Test
	public void testRandom() {
		Random r = new Random();
		Random r2 = new Random();
		for (int i = 0; i < 10; i++) {
//			System.out.println(r.nextInt());
//			System.out.println(r2.nextInt());
			// 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
			System.out.println(r.nextInt(10));
		}
	}

	// 带种子：
	// 此种方式，无论程序运行多少次，返回结果都是一样的
	// 相同种子数的Random对象，相同次数生成的随机数字是完全相同的
	@Test
	public void testRamdom2() {
		Random r = new Random(10);
		Random r2 = new Random(10);
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt());
			System.out.println(r2.nextInt());
		}

	}
}
