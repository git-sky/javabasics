package cn.com.sky.basics.calculate;

import java.math.BigInteger;

/**
 * 大数计算
 */
public class TestBigInteger {

	public static void main(String[] args) {

		String a = "12345678901234567890";
		String b = "11";

		BigInteger aa = new BigInteger(a);
		BigInteger bb = new BigInteger(b);

		System.out.println(aa.add(bb));
		System.out.println(aa.multiply(bb));

	}

}
