package cn.com.sky.tools.json.fastjson;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 *
 */
public class TestFastJson {

	@Test
	public void test1() {

		Men men = new Men();

		men.set_name("哈哈");
		men.set_age(11);

		String str = JSON.toJSONString(men);

		System.out.println(str);

		Men m = JSON.parseObject(str, Men.class);
		System.out.println(m.get_name());

		JSONObject jsonObject = JSON.parseObject(str);
		System.out.println(jsonObject.get("name"));

	}

	@Test
	public void test2() {

		WoMen w = new WoMen();

		w.set_3age(16);
		w.set_3name("老外");

		String str = JSON.toJSONString(w);

		System.out.println(str);

		WoMen m = JSON.parseObject(str, WoMen.class);
		System.out.println(m.get_3name());

		JSONObject jsonObject = JSON.parseObject(str);
		System.out.println(jsonObject.get("3nasme"));

	}
	
	

}
