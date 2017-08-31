package cn.com.sky.collections.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 
 * LinkedHashMap<Integer, Integer>(int initialCapacity, float loadFactor,boolean accessOrder);
 * 
 * accessOrder是true，按访问顺序进行迭代。(可以实现“最近最少使用LRU”算法)
 * accessOrder是false，按插入顺序迭代。(默认值)
 * 
 */
public class TestLinkedHashMap {

	@Test
	public void test() {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(128, 0.75f, true);

		for (int i = 0; i < 20; i++) {
			map.put(i, i);
		}

		Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();

		while (iter.hasNext()) {
			Entry<Integer, Integer> entry = iter.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		System.out.println("------------------");

		for (int i = 0; i < 2; i++) {
			Random random = new Random();
			int key = random.nextInt(20);
			System.out.println("访问key：" + key);
			map.get(key);
			// map.put(key, key);
			System.out.println("------------------");

			Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
			while (itr.hasNext()) {
				Entry<Integer, Integer> entry = itr.next();
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}
	}
}
