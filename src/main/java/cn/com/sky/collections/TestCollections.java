package cn.com.sky.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class TestCollections {

	@Test
	public void test1() {
		ArrayList<Integer> alist = new ArrayList<>();

		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			alist.add(ran.nextInt(100));
		}
		System.out.println(alist.toString());

		Collections.sort(alist);
		System.out.println(alist);

		Collections.shuffle(alist);// 打乱顺序
		System.out.println(alist);

		Collections.sort(alist);// 顺序排序
		System.out.println(alist);

		Collections.sort(alist, Collections.reverseOrder());// 逆序排序
		System.out.println(alist);

	}

	@Test
	public void test2() {

		List list = Collections.nCopies(100, "defalut");
		list.add("a");

		Map m = new HashMap();
		Map map = Collections.synchronizedMap(m);
		map.put("key", "value");

	}

	/**
	 * 获取不可修改视图
	 */
	@Test
	public void test3() {

		ArrayList list = new ArrayList();
		Map m = new HashMap();

		Collections.unmodifiableList(list);
		Collections.unmodifiableCollection(list);
		Collections.unmodifiableMap(m);

	}

	@Test
	public void test4() {

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		int key = 3;

		int pos = Collections.binarySearch(list, key);// 二分查找
		System.out.println(pos);
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		System.out.println(list);
		Collections.fill(list, 11);// 所有位置设置为11.
		System.out.println(list);

	}
}
