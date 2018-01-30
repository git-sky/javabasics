package cn.com.sky.collections.list;

import org.apache.storm.guava.collect.Lists;
import org.junit.Test;

import java.util.*;

/**
 * 底层是数组结构， 初始化大小10，每次扩容50%，如果不够，直接扩容到需要的大小。
 * 
 * <pre>
 * 
 *   private void grow(int minCapacity) {
 *         // overflow-conscious code
 *         int oldCapacity = elementData.length;
 *         int newCapacity = oldCapacity + (oldCapacity >> 1);//扩容50%
 *         if (newCapacity - minCapacity < 0)
 *             newCapacity = minCapacity;//直接扩容到需要的大小。
 *         if (newCapacity - MAX_ARRAY_SIZE > 0)
 *             newCapacity = hugeCapacity(minCapacity);
 *         // minCapacity is usually close to size, so this is a win:
 *         elementData = Arrays.copyOf(elementData, newCapacity);
 * }
 * 
 * <pre>
 */
public class TestArrayList {

	@Test
	public void init() {

		List<String> list = new ArrayList<String>() {

			{
				add("A");
				add("B");
				add("C");
			}
		};

		System.out.println(Arrays.toString(list.toArray()));

	}

	/**
	 * list遍历
	 */
	@Test
	public void traversal() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			System.out.println(list.add(i + ""));
		}

		System.out.println("---------------------------");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			// list.remove(i);
		}

		System.out.println("---------------------------");
		Iterator<String> iter = list.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("---------------------------");
		ListIterator<String> listIter = list.listIterator();
		while (listIter.hasNext()) {
			System.out.println(listIter.next());
		}

		System.out.println("---------------------------");
		ListIterator<String> listIter2 = list.listIterator(10);
		while (listIter2.hasPrevious()) {
			System.out.println(listIter2.previous());

		}
	}

	/**
	 * 【强制】在subList场景中，高度注意对原集合元素个数的修改，会导致子列表的遍历、增加、删除均产生ConcurrentModificationException 异常。
	 * 
	 * 【强制】ArrayList的subList结果不可强转成ArrayList，否则会抛出ClassCastException异常：java.util.RandomAccessSubList
	 * cannot be cast to java.util.ArrayList ; 说明：subList 返回的是 ArrayList 的内部类 SubList，并不是 ArrayList
	 * ，而是 ArrayList 的一个视图，对于SubList子列表的所有操作最终会反映到原列表上。
	 */
	@Test
	public void testSubList() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}

		System.out.println("-----------------------------");

		List<Integer> subList = list.subList(3, 5);

		list.add(3);// 会产生ConcurrentModificationException异常

		for (Iterator<Integer> iter = subList.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}

		subList.add(4);

		for (Iterator<Integer> iter = subList.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}

		System.out.println("-----------------------------");

		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}

	}

	@Test
	public void test() {

		ArrayList list = Lists.newArrayList();
		System.out.println(list.get(0));
		//
		// ArrayList list2;
		// list.retainAll(list2);
		// list.contains(o)

	}
}
