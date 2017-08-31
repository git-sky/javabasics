package cn.com.sky.basics.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 * 
 * Java对象比较大小有两种方法 :
 * 
 * 1：实现Comparable 接口 的 public int compareTo(T o) 方法；
 * 
 * 2：实现Comparator 接口 的 int compare(T o1, T o2)方法；
 * 
 * 
 * </pre>
 * 
 */
public class TestCompare {

	public static void main(String[] args) {
		List<Dept> list = new ArrayList<>();
		list.add(new Dept("2", "研发部", 23));
		list.add(new Dept("2", "总公司", 575));
		list.add(new Dept("2", "总公司", 565));
		// Collections.sort(list);
		Collections.sort(list, new Comparator<Dept>() {
			public int compare(Dept dept1, Dept dept2) {
				return dept1.compareTo(dept2);
			}

		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println((Dept) list.get(i));
		}

		// Dept dept1 = new Dept("2", "研发部", 23);
		// Dept dept2 = new Dept("2", "kk", 44);
		// Set set = new TreeSet(new Comparator() {
		//
		// public int compare(Object arg0, Object arg1) {
		// return 0;
		// }
		//
		// });
		// set.add(dept1);
		// set.add(dept2);

	}
}

class Dept implements Comparable<Dept> {
	private String id;
	private String name;
	private long num;

	public Dept(String id, String name, long num) {
		this.id = id;
		this.name = name;
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	@Override
	public int compareTo(Dept dept) {
		int i = 0;
		i = this.id.compareTo(dept.id);
		if (i != 0) {// 部门id不相等
			return i;
		} else {// 部门id相等
			i = this.name.compareTo(dept.name);
			if (i != 0) {// 部门名称不相等
				return i;
			} else {// 部门名称不相等
				if (this.num > dept.num)
					return 1;
				else if (this.num < dept.num)
					return -1;
				else
					return 0;
			}
		}

	}

	@Override
	public String toString() {
		return this.id + "-->" + this.name + "-->" + this.num;
	}

}
