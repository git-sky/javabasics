package cn.com.sky.basics.calculate;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * <pre>
 * 总结
 *         (1)商业计算使用BigDecimal。
 * 
 *         (2)尽量使用参数类型为String的构造函数。
 * 
 *         (3) BigDecimal都是不可变的（immutable）的，在进行每一步运算时，都会产生一个新的对象，所以在做加减乘除运算时千万要保存操作后的值。
 * 
 *         (4)我们往往容易忽略JDK底层的一些实现细节，导致出现错误，需要多加注意。
 *         
 *         (5)比较大小使用compareTo，不能用equals。
 * </pre>
 */
public class TestBigDeciaml2 {

	@Test
	public void test1() {
		String rebateRatio = "2.3";
		double doubleRatil = 0;
		if (rebateRatio != null && !"".equals(rebateRatio)) {
			doubleRatil = Double.valueOf(rebateRatio);
		}

		int n = (int) (doubleRatil * 10000);

		System.out.println(doubleRatil);
		System.out.println(doubleRatil * 10);
		System.out.println(doubleRatil * 100);
		System.out.println(doubleRatil * 1000);
		System.out.println(doubleRatil * 10000);

		System.out.println("+++++++++++++++++++");

		System.out.println((int) (doubleRatil * 10));
		System.out.println((int) (doubleRatil * 100));
		System.out.println((int) (doubleRatil * 1000));
		System.out.println((int) (doubleRatil * 10000));
		System.out.println("==============================");

		// BigDecimal b = new BigDecimal(rebateRatio);

		BigDecimal b = new BigDecimal("0");

		BigDecimal bb = b.multiply(new BigDecimal("100"));

		bb.setScale(0).intValue();

		System.out.println(b);
		System.out.println(bb);
		System.out.println(bb.intValue());

		System.out.println(2.0 * 100);
		System.out.println(2.1 * 100);
		System.out.println(2.2 * 100);
		System.out.println(2.3 * 100);
		System.out.println(2.4 * 100);
		System.out.println(2.5 * 100);
		System.out.println(2.6 * 100);
		System.out.println(2.7 * 100);
		System.out.println(2.8 * 100);
		System.out.println(2.9 * 100);
		// System.out.println(n);

	}

	@Test
	public void testByString() {

		// float计算不精确
		BigDecimal af = new BigDecimal(9.85);
		BigDecimal bf = new BigDecimal(100);
		BigDecimal cf = af.multiply(bf);
		System.out.println(cf.intValue());

		// String 精确
		BigDecimal a = new BigDecimal("9.85");
		BigDecimal b = new BigDecimal(100);
		BigDecimal c = a.multiply(b);
		System.out.println(c.intValue());
	}

	@Test
	public void testByDe() {
		// 参数类型为double的构造方法的结果有一定的不可预知性
		BigDecimal aDouble = new BigDecimal(1.22);

		System.out.println("construct with a double value: " + aDouble);

		// String 构造方法是完全可预知的：写入 newBigDecimal("0.1") 将创建一个 BigDecimal，它正好等于预期的 0.1。
		// 因此，比较而言，通常建议优先使用String构造方法。
		BigDecimal aString = new BigDecimal("1.22");

		System.out.println("construct with a String value: " + aString);
	}

	@Test
	public void TestBye() {
		BigDecimal a = new BigDecimal("1.22");

		System.out.println("construct with a String value: " + a);

		BigDecimal b = new BigDecimal("2.22");

		a.add(b);

		System.out.println("aplus b is : " + a);

		// 我们很容易会认为会输出：
		//
		// construct with a Stringvalue: 1.22
		//
		// a plus b is :3.44
		//
		// 但实际上a plus b is : 1.22
	}

	@Test
	public void TestConstructor() {
		BigDecimal f1 = new BigDecimal("0.05");
		BigDecimal f2 = BigDecimal.valueOf(0.01);
		BigDecimal f3 = new BigDecimal(0.05);

		System.out.println("使用String作为BigDecimal构造器参数：");
		System.out.println("0.05 + 0.01 = " + f1.add(f2));
		System.out.println("0.05 - 0.01 = " + f1.subtract(f2));
		System.out.println("0.05 * 0.01 = " + f1.multiply(f2));
		System.out.println("0.05 / 0.01 = " + f1.divide(f2));

		System.out.println("使用double作为BigDecimal构造器：");
		System.out.println("0.05 + 0.01 = " + f3.add(f2));
		System.out.println("0.05 - 0.01 = " + f3.subtract(f2));
		System.out.println("0.05 * 0.01 = " + f3.multiply(f2));
		System.out.println("0.05 / 0.01 = " + f3.divide(f2));
	}

	@Test
	public void compare() {
		BigDecimal[] nums = { null, new BigDecimal(1.23), new BigDecimal(0), new BigDecimal(0.00), new BigDecimal(0.1) };
		for (BigDecimal amount : nums) {
			if (amount == null || new BigDecimal(0).compareTo(amount) >= 0) {
				System.out.println("need continue");
				continue;
			}
			System.out.println("success");
		}
	}
}
