package cn.com.sky.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * 底层使用hashmap实现,无序。
 */
public class TestHashSet {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();

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

	}

}
