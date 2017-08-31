package cn.com.sky.tools.json.fastjson;

import com.alibaba.fastjson.JSONObject;

public class Test {

	public static void main(String[] args) {
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("businessName", "tc_cashBackToAccountNotify");
		jsonParam.put("userId", "123456");
		jsonParam.put("templateId", "3047");
		jsonParam.put("money", "123");
		System.out.println(jsonParam);
	}
}
