package cn.com.sky.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 
 * isAssignableFrom 是用来判断一个类Class1和另一个类Class2是否相同或是另一个类的超类或接口。
 * 
 * Class1.isAssignableFrom(Class2)
 * 
 * 
 * instanceof 是用来判断一个对象实例是否是一个类或接口的或其子类子接口的实例。
 * 
 */
public class TestAssignable {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		System.out.println(list instanceof List);
		System.out.println(list instanceof ArrayList);

		/*
		 * System.out.println(list.getClass()); System.out.println(List.class);
		 * System.out.println(ArrayList.class);
		 */

		System.out.println(list.getClass().isAssignableFrom(ArrayList.class));
		System.out.println(list.getClass().isAssignableFrom(List.class));
		System.out.println(List.class.isAssignableFrom(list.getClass()));
		System.out.println(List.class.isAssignableFrom(ArrayList.class));
		System.out.println(ArrayList.class.isAssignableFrom(List.class));

	}
}