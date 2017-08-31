package cn.com.sky.tools.json.simple_json;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import cn.com.sky.tools.json.fastjson.Men;

public class JsonTest2 {

	public static void main(String[] args) {


		Men men = new Men();

		men.set_name("哈哈");
		men.set_age(11);

		String str = JSONValue.toJSONString(men);
		
		JSONObject j=new JSONObject();

		System.out.println(str);

	}

}