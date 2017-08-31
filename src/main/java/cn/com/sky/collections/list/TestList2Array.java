package cn.com.sky.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import cn.com.sky.alpha_work.Person;

/**
 * <pre>
 * 
 * 【强制】使用集合转数组的方法，必须使用集合的toArray(T[] array)，传入的是类型完全一样的数组，大小就是list.size()。
 * 反例：直接使用toArray无参方法存在问题，此方法返回值只能是Object[]类，若强转其它类型数组将出现ClassCastException错误。
 * 
 * </pre>
 */
public class TestList2Array {

	@Test
	public void test1() {

		List<String> alist = new ArrayList<>(3);
		alist.add("a");
		alist.add("b");
		alist.add("c");

		for (Object a : alist.toArray()) {
			System.out.println(a);
		}
		System.out.println("------------------------");

		String[] arr = new String[alist.size()];
		for (String a : alist.toArray(arr)) {
			System.out.println(a);
		}
	}

	@Test
	public void test2() {

		List<Person> alist = new ArrayList<Person>();
		Person p = new Person("aaa", 10);
		alist.add(p);
		p = new Person("bbb", 15);
		alist.add(p);
		p = new Person("ccc", 23);
		alist.add(p);

		for (Object a : alist.toArray()) {
			System.out.println(((Person) a).getName());
//			try {
//				System.out.println(JSONUtils.serializeObject(a));
//				System.out.println(JSON.toJSONString(a));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
	}


	public static void main(String[] args) {

		ArrayList<Object> al = new ArrayList<Object>();
		al.add(new Point(1, 1));
		al.add(new Point(2, 2));
		al.add(new Point(3, 3));
		al.add(4);
		al.add(5);

		Object[] obj = al.toArray();
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}

		List<Object> l = Arrays.asList(obj);
		System.out.println(l);

		Iterator<Object> it = l.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}