package cn.com.sky.mock.junit.TestCaseImpl;

import junit.framework.TestCase;

public class CalculateTest extends TestCase {

	Calculate cal = null;

	protected void setUp() throws Exception {

		super.setUp();

		// 做测试前的初始化工作

		cal = new Calculate();

	}

	public void testAdd1() {

		int result = cal.add(3, 4);

		// 判断result和本来应该得到的结果是否相等

		// 还有别的比较方法

		assertEquals("与预期不符合!!", 7, result);

	}

	public void testAdd2() {

		int result = cal.add(1, 4);

		// 判断result和本来应该得到的结果是否相等

		// 还有别的比较方法

		assertEquals("与预期不符合!!", 5, result);

	}

	protected void tearDown() throws Exception {

		super.tearDown();

		// 做测试后的善后工作

		cal = null;
	}

}
