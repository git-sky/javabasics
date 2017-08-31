package cn.com.sky.tools.serializable.fastjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;

public class TestJSONString {
	// 填充user对象
	public static void setUser(User user) {
		user.setId(1);
		user.setUsername("xiaoxiang");
		Link lk = new Link();
		lk.setName("rongrong");
		lk.setPhone("1234234");
		Link lk1 = new Link();
		lk1.setName("rongrong");
		lk1.setPhone("1234234");
		ArrayList<Link> list = new ArrayList();
		list.add(lk1);
		list.add(lk);
		user.setLink(list);
		Map map = new HashMap();
		map.put("123", lk);
		map.put("234", lk1);
		user.setResult(map);
	}

	public static void main(String[] args) {
		User user = new User();
		setUser(user);
		// 将javabean转成json
		String str = JSON.toJSONString(user);
		System.out.println("fastJson:" + str);
		// 将json转成java bean
		User myuser = JSON.parseObject(str, User.class);
		System.out.println(myuser.getResult().get("123").getName());
	}
}