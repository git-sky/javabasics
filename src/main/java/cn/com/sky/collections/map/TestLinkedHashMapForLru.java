package cn.com.sky.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * 
 * LinkedHashMap<Integer, Integer>(int initialCapacity, float loadFactor,boolean accessOrder);
 * 
 * accessOrder是true，按访问顺序进行迭代。(可以实现“最近最少使用”算法)
 * accessOrder是false，按插入顺序迭代。(默认值)
 * 
 * 实现LRU(Least Recently Used最近最少算法，以access模式创建LinkedHashMap)。
 * 
 */
public class TestLinkedHashMapForLru<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;

	// 重写removeEldestEntry方法，实现缓存功能（该map最多存放10个元素）
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > 10;
	}

	public static void main(String[] args) {

		TestLinkedHashMapForLru<String, String> m = new TestLinkedHashMapForLru<>();
		
		for (int i = 0; i < 100; i++) {
			m.put("" + i, String.valueOf(i));
		}

		for (Map.Entry<String, String> entry : m.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
	}

}
