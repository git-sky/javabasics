package cn.com.todo.test_basic;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {

		Map<String, String> m = new HashMap<String, String>();
		m.put("a", "111");
		System.out.println(m.get("a"));
		m.put("a", "2222222222222");
		System.out.println(m.get("a"));
	}

}
