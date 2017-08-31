package cn.com.sky.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestList {

	public static void main(String args[]) {
		// new TestList().arraylist_add();
		// new TestList().arraylist_contains();

		new TestList().collectionsSort();

	}

	public void collectionsSort() {
		List<String> a = new ArrayList<>();
		a.add("c");
		a.add("g");
		a.add("a");
		a.add("b");
		a.add("e");
		a.add("f");

		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
		Collections.sort(a, new DicComparator());

		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

	class DicComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			return s1.toLowerCase().compareTo(s2.toLowerCase());
		}
	}

	public void arraylist_add() {
		List result = new ArrayList();
		List result2 = new ArrayList();

		Collection<String> c = new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		result.addAll(c);// 把list中的每一个元素加到result中，result.size()==list.size()
		result2.add(c);// 将list作为一个元素加到result中，则result.size()为1

		// System.out.println(result.size());
		// System.out.println(result2.size());
		//
		// for (Object obj : result) {
		// System.out.println(obj);
		// }
		//
		// for (Object obj : result2) {
		// System.out.println(obj);
		// }
		//
		System.out.println(result.contains("d"));
		System.out.println(result.contains(c));
		System.out.println(result.containsAll(c));

		System.out.println(result2.contains("d"));
		System.out.println(result2.contains(c));
		System.out.println(result2.containsAll(c));

	}

}
