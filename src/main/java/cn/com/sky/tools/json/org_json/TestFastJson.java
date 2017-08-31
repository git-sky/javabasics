package cn.com.sky.tools.json.org_json;

import cn.com.sky.tools.json.fastjson.Men;

public class TestFastJson {

	public static void main(String[] args) {

		Men men = new Men();

		men.set_name("哈哈");
		men.set_age(11);

		String str = null;
		try {
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(str);
	}

}
