package cn.com.todo.test_basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestList {

	public static void main(String args[]) {
		new TestList().arraylist_add();
		new TestList().arraylist_contains();

	}

	@SuppressWarnings("unchecked")
	public void arraylist_add() {
		List result = new ArrayList();
		List result2 = new ArrayList();

		Collection c = new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		result.addAll(c);// ��list�е�ÿһ��Ԫ�ؼӵ�result�У�result.size()==list.size()
		result2.add(c);// ��list��Ϊһ��Ԫ�ؼӵ�result�У���result.size()Ϊ1

//		System.out.println(result.size());
//		System.out.println(result2.size());
//
//		for (Object obj : result) {
//			System.out.println(obj);
//		}
//
//		for (Object obj : result2) {
//			System.out.println(obj);
//		}
//		
		System.out.println(result.contains("d"));
		System.out.println(result.contains(c));
		System.out.println(result.containsAll(c));
		
		System.out.println(result2.contains("d"));
		System.out.println(result2.contains(c));
		System.out.println(result2.containsAll(c));

	}

	@SuppressWarnings("unchecked")
	public void arraylist_contains() {
	}

}
