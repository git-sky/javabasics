package cn.com.sky.basics.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 通过反射来规避泛型类型检查
 */
public class ReflectDemo {

	public static void main(String[] args) throws Exception, Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);
		list.add(789);
		// list.add("abc");
		// list.add("abc") 如何存进去呢？
		/*
		 * 使用反射技术绕过泛型编译期间检查，将不同的数据类型 存储到带有泛型的集合 （泛型的擦除）
		 */
		// 获取list字节文字对象
		Class clazz = list.getClass();
		System.out.println(clazz);

		// 存储对象 调用的是集合中的 add()方法 那么通过反射获取add方法

		Method m = clazz.getMethod("add", Object.class);
		System.out.println(m);

		// 对象有了 方法有了 运行add方法
		m.invoke(list, "abc");
		m.invoke(list, "sss");
		m.invoke(list, "qqq");

		System.out.println(list);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}