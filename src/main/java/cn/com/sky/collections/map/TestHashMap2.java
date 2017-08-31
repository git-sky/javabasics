package cn.com.sky.collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 
 * 集合类			 		Key 		Value 		Super 			说明 
 * Hashtable 			不允许为null 	不允许为null 	Dictionary 		线程安全 
 * ConcurrentHashMap 	不允许为null 	不允许为null 	AbstractMap 	线程局部安全 
 * TreeMap 				不允许为null 	允许为null 	AbstractMap 	线程不安全 
 * HashMap 				允许为null 	允许为null  	AbstractMap 	线程不安全
 * 
 * </pre>
 * 
 */
public class TestHashMap2 {
	public static void main(String[] args) {

		HashMap<String, String> m = new HashMap<String, String>();
		m.put("a", "111");
		System.out.println(m.get("a"));
		m.put("a", "2222222222222");
		System.out.println(m.get("a"));

		Map<String, String> m2 = new HashMap<String, String>();
		m2.put("b", "333");

		m.putAll(m2);

		System.out.println("通过Map.entrySet遍历key和value");
		for (Map.Entry<String, String> entry : m.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
	}

}
