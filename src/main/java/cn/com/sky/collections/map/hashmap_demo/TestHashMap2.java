package cn.com.sky.collections.map.hashmap_demo;

import org.junit.Test;

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
 */
public class TestHashMap2 {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "111");
        System.out.println(map.get("a"));
        map.put("a", "222");
        System.out.println(map.get("a"));

        Map<String, String> m2 = new HashMap<>();
        m2.put("b", "333");

        map.putAll(m2);

        map.get("b");
        map.containsKey("b");

        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }


    @Test
    public void test2() {
        HashMap<Integer, String> map = new HashMap<>();
        //不能putAll放null元素，报错
        map.putAll(null);

    }

}
