package cn.com.sky.collections.map;

import java.util.HashMap;

import org.junit.Test;

/**
 * <pre>
 * 
 * 如果你知道所要插入的数据的个数N，那么你可以定义HashMap的容量大小为：N/0.75,
 * 有因为HashMap的容量必须是2的幂次方，找一个接近的即可；
 * 如果你还知道其近似一个均匀分布的话， 那么装填因子也可以自己定义，接近于1会更效率。
 * 
 * 
 * 链表数组实现(数组与单链表)
 * 
 * </pre>
 */
public class TestHashMap {

	@Test
	public void test2() {
		HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>(2 << 14);

		int count = 10000;

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			hm1.put(i, i);
		}
		long time2 = System.currentTimeMillis();

		System.out.println("默认初始容量16所用时间为：" + (time2 - time1));

		long time3 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			hm2.put(i, i);
		}
		long time4 = System.currentTimeMillis();

		System.out.println("定义初始容量" + (2 << 14) + "所用时间为：" + (time4 - time3));
	}
}