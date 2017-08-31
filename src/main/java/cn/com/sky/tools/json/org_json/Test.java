package cn.com.sky.tools.json.org_json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main(String args[]) throws JSONException {
		String jsonContent = "{'hello':world,'abc':'xyz'}";
		JSONObject jsonObject = new JSONObject(jsonContent);
		String str1 = jsonObject.getString("hello");
		String str2 = jsonObject.getString("abc");
		System.out.println(str1);
		System.out.println(str2);

		System.out.println("------------------");
		jsonContent = "[{'hello':333,'abc':'false','xyz':{'a':1,'b':'ab'}},{'hello':555,'abc':'true','xyz':{'a':2,'b':'ba'}}]";
		JSONArray jsonArray = new JSONArray(jsonContent);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonobject2 = jsonArray.getJSONObject(i);
			int value1 = jsonobject2.getInt("hello");
			boolean value2 = jsonobject2.getBoolean("abc");
			// String value3=jsonobject2.getString("xyz");
			JSONObject jsonobject3 = jsonobject2.getJSONObject("xyz");
			int value4 = jsonobject3.getInt("a");
			String value5 = jsonobject3.getString("b");
			System.out.println(value1);
			System.out.println(value2);
			// System.out.println(value3);
			System.out.println(value4);
			System.out.println(value5);
			System.out.println("==========================");

		}

	}
}