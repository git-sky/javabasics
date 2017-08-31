package cn.com.sky.tools.json.org_json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;

public class Test2 {
	public static void main(String[] args) throws JSONException {

		// 创建JSONObject对象
		JSONObject json = new JSONObject();

		// 向json中添加数据
		json.put("username", "wanglihong");
		json.put("height", 12.5);
		json.put("age", 24);

		System.out.println(json);
		System.out.println(json.getString("username"));
		System.out.println(json.getDouble("height"));
		System.out.println(json.getInt("age"));
		System.out.println(json.isNull("weight"));

		// 创建JSONArray数组，并将json添加到数组
		JSONArray array = new JSONArray();
		array.put(json);

		// 转换为字符串
		String jsonStr = array.toString();

		System.out.println(jsonStr);
		System.out.println(array.getJSONObject(0).get("username"));
		
	}
}
