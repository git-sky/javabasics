package cn.com.sky.mock.junit.TestCaseImpl2;

import junit.framework.TestCase;

public class HelloJunitTest extends TestCase {
	public void testAbs() {
		assertEquals(HelloJunit.abs(10), 10);
		assertEquals(HelloJunit.abs(-10), 10);
	}
}