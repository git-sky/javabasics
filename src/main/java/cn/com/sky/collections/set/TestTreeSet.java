package cn.com.sky.collections.set;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 * 底层使用红黑树实现，默认按照自然顺序排序。底层使用的TreeMap实现。
 */
public class TestTreeSet {

	public static void main(String[] args) {

		TreeSet<String> set = new TreeSet<String>();
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			int num = ran.nextInt(10);
			System.out.println(num);
			set.add("a" + num + "b");
		}

		System.out.println("--------------------");
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		// 返回集合中最小/大元素
		System.out.println("first():" + set.first());
		System.out.println("last():" + set.last());

		// 返回比较器
		System.out.println(set.comparator());
		// 大于指定元素的最小元素
		System.out.println("higher():" + set.higher("a5b"));

		// 递减顺序遍历
		Iterator<String> iter2 = set.descendingIterator();
		while (iter2.hasNext()) {
			System.out.println(iter2.next());
		}

	}
}
