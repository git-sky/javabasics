package cn.com.sky.basics.number;

import org.junit.Test;

public class TestInteger4 {

	@Test
	public void test() {
		for (Integer i = 0; i < 10; i++) {
			System.out.println("i=" + i);
			System.out.println("numberOfLeadingZeros=" + Integer.numberOfLeadingZeros(i));// 高位0的个数
			System.out.println("toBinaryString=" + Integer.toBinaryString(i));
			System.out.println("----------");
		}
	}
}
