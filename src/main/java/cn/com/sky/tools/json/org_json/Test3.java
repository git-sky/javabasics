package cn.com.sky.tools.json.org_json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;

public class Test3 {

	public static void main(String[] args) throws JSONException {
		// 初始化ArrayList集合并添加数据
		List<String> list = new ArrayList<String>();
		list.add("username");
		list.add("age");
		list.add("sex");

		// 初始化HashMap集合并添加数组
		Map map = new HashMap();
		map.put("bookname", "CSS3实战");
		map.put("price", 69.0);

		// 初始化JSONArray对象，并添加数据
		JSONArray array = new JSONArray();
		array.put(list);
		array.put(map);
		System.out.println(array);
		
		// 生成的JSON字符串为：[["username","age","sex"],{"bookname":"CSS3实战","price":69}]
	}
}