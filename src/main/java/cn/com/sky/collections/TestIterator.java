package cn.com.sky.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * 
 * 【强制】不要在foreach循环里进行元素的remove/add操作。
 * remove元素请使用Iterator方式，如果并发操作，需要对Iterator对象加锁。
 * 正例：
 * Iterator<String> it = a.iterator(); 
 * while(it.hasNext()){ 
 * 	String temp = it.next(); 
 * 	if(删除元素的条件){ 
 * 		it.remove(); 
 * 	} 
 * }
 * 
 * </pre>
 */
public class TestIterator {

	@Test
	public void testRemove1() {
		// 1、 remove()去掉的是当前it.next()返回的元素

		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String str = String.valueOf(i);
			list.add(str);
		}

		Iterator<String> it = list.iterator();
		for (int i = 0; i < 5; i++) {
			System.out.println((String) it.next());
		}
		it.remove();
		System.out.println("////////////////////////");
		it = list.iterator();
		while (it.hasNext()) {
			System.out.println((String) it.next());
		}

	}

	@Test
	public void testRemove() {
		// 2、 remove()后，对下面的元素遍历没影响

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Integer str = Integer.valueOf(i);
			list.add(str);
		}
		System.out.println("=========================");
		Iterator<Integer> it2 = list.iterator();
		while (it2.hasNext()) {
			Integer s = it2.next();
			System.out.println(s);
			if (s % 2 == 1)
				it2.remove();
		}
		System.out.println("=========================");
		Iterator<Integer> it3 = list.iterator();
		while (it3.hasNext()) {
			System.out.println((Integer) it3.next());
		}
	}
}
