package cn.com.sky.tools.json.gson;

import cn.com.sky.tools.json.fastjson.domain.Men;

import com.google.gson.Gson;

public class TestGson2 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		Men men = new Men();

		men.set_name("哈哈");
		men.set_age(11);

		System.out.println(gson.toJson(men)); // prints [1,2,3,4,5]
	}

}
