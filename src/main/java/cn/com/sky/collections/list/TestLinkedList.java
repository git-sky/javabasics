package cn.com.sky.collections.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.Test;

/**
 * 带有头指针和尾指针的双向链表实现的双端队列。
 */
public class TestLinkedList {

	@Test
	public void test1() {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("a");
		list.addLast("b");
	}

	@Test
	public void traversal() {
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < 10; i++) {
			System.out.println(list.add(i + ""));
		}

		System.out.println("---------------------------");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
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
}
