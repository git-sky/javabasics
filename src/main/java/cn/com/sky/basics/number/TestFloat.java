package cn.com.sky.basics.number;

import org.junit.Test;

public class TestFloat {

	@Test
	public void test2() {
		float a = 0.00f;
		System.out.println(a == 0);
		Float b=new Float(0.0);
		System.out.println(b==0);
		System.out.println(b>0);
	}

	@Test
	public void test1() {
		float a = 0.23f;
		System.out.println(a * 100);
	}
}
