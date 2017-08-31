package cn.com.sky.alpha_work;

import java.io.File;

public class TestM {
	public static void main(String[] args) {
		System.out.println("ps1" + 3 + 1 + "X");

		// Objects.equals(a, b);

		String str = "a,b,c,,";
		String[] ary = str.split(","); // 预期大于3，结果是3 System.out.println(ary.length);

		// Arrays.asList();

		String kvConfigPath = System.getProperty("user.home") + File.separator + "namesrv" + File.separator + "kvConfig.json";

		System.out.println(kvConfigPath);

	}
}
