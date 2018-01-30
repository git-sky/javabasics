package cn.com.sky.collections.queue;

import org.junit.Test;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * <pre>
 * 
 * 优先级队列
 * 
 * 优先队列本质上就是一个最小堆。
 * 
 * 迭代顺序：不确定。
 * 删除顺序：默认从小到大删除。
 * 
 */
public class TestPriotyQueue {

	@Test
	public void test1() {
		//
		// 按照比较器顺序进行删除。
		// PriorityQueue<Integer> pq = new PriorityQueue<Integer>(16, new Comparator<Integer>() {
		// @Override
		// public int compare(Integer o1, Integer o2) {
		// return o2-o1;
		// }
		// });

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

//        PriorityBlockingQueue

//        TransferQueue

		for (int i = 10; i > 0; i--) {
			pq.add(i);
		}

		del(pq);

	}

	@Test
	public void test2() {

		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("a");
		pq.add("c");
		pq.add("b");
		pq.add("d");
		pq.add("f");
		pq.add("e");
		pq.add("g");

		del(pq);

	}

	private void del(PriorityQueue pq) {

		for (Iterator iterator = pq.iterator(); iterator.hasNext();) {
			Object str = iterator.next();
			System.out.println(str);
		}
		System.out.println("-------------------");
		while (!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
	}
}
