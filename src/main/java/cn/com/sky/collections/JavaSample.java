package cn.com.sky.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Person implements Comparable<Person> {
	private final String name;
	private final int score;

	public Person(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null || o.getClass() != Person.class) {
			return false;
		}
		Person b = (Person) o;
		return name.equals(b.name) && score == b.score;
	}

	@Override
	public int hashCode() {
//		return name.hashCode() ^ Integer.hashCode(score);
        return 1;
	}

	@Override
	public int compareTo(Person o) {
		int result = Integer.compare(o.score, score);
		if (result != 0) {
			return result;
		}
		return name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return String.format("{name=%s, score=%d}", name, score);
	}
}

public class JavaSample {
	public static void main(String[] args) {
		{
			System.out.println("\n排序示例：");
			List<Integer> list = new ArrayList<>(Arrays.asList(81, 63, 100));
			Collections.sort(list);
			System.out.println("默认排序：" + list);
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if (o1.equals(o2)) {
						return 0;
					} else if (o1 > o2) {
						return -1;
					} else {
						return 1;
					}
					// return -o1.compareTo(o2);
					// Integer.compare(o1, o2);
				}
			});
			System.out.println("倒序排序：" + list);
		}
		{
			System.out.println("\nList与数组转换示例：");
			{
				System.out.println("数组转换List：");
				String[] array = new String[] { "Zeck", "Sony", "April" };
				List<String> list = Arrays.asList(array);
				System.out.println("List内容：" + list);
			}
			{
				System.out.println("List转换数组：");
				List<String> list = Arrays.asList("Zeck", "Sony", "April");
				String[] array = new String[list.size()];
				array = list.toArray(new String[] {});
				System.out.println("数组内容：" + Arrays.toString(array));
			}
		}
		{
			System.out.println("\nHashMap示例：");
			Map<Person, Boolean> hashmap = new HashMap<>();
			hashmap.put(new Person("Zeck", 81), true);
			hashmap.put(new Person("April", 100), true);
			hashmap.put(new Person("April", 100), false);
			System.out.println("HashMap内容：" + hashmap);
		}
		{
			System.out.println("\nTreeMap示例：");
			{
				TreeMap<String, Integer> treeMap = new TreeMap<>();
				// 使用String默认比较，按字母序
				treeMap.put("Zeck", 81);
				treeMap.put("Sony", 63);
				treeMap.put("April", 100);
				System.out.println("默认TreeMap结构：" + treeMap);
			}
			{
				TreeMap<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {
					// 重新定义比较器，按逆字母序
					@Override
					public int compare(String o1, String o2) {
						return -o1.compareTo(o2);
					}
				});
				treeMap.put("Zeck", 81);
				treeMap.put("Sony", 63);
				treeMap.put("April", 100);
				System.out.println("自定义比较器TreeMap结构：" + treeMap);
			}
		}
		{
			System.out.println("\n堆示例：");
			PriorityQueue<Person> q = new PriorityQueue<Person>();
			q.add(new Person("Zeck", 81));
			q.add(new Person("Sony", 63));
			q.add(new Person("April", 100));
			q.add(new Person("Lucy", 81));
			q.add(new Person("Belly", 81));
			System.out.println("堆结构：");
			while (!q.isEmpty()) {
				System.out.println(q.poll());
			}
		}
		{
			System.out.println("\n工具类示例：");
			// 线程安全集合
			List<String> syncList = Collections.synchronizedList(new ArrayList<String>());
			// 不可变集合
			List<String> unmodifiedList = Collections.unmodifiableList(new ArrayList<String>());
			try {
				unmodifiedList.add("a");
			} catch (Exception e) {
				// 出现UnsupportedOperationException
				System.out.println("试图更改一个不可变集合时，会出现这个异常：" + e.toString());
			}
		}
	}
}