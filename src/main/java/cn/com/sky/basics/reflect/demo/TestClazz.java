package cn.com.sky.basics.reflect.demo;

import org.junit.Test;

public class TestClazz {

	@Test
	public void define() {
		Parent pa = new Parent();
		try {
			Class paClazz = Class.forName("cn.com.sky.basics.reflect.demo.Parent");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class paClazz2 = Parent.class;
		Class paClazz3 = pa.getClass();
		Class iclazz = int.class;
		Class dclazz = Double[].class;
	}

	@Test
	public void compare() {

		Parent parent = new Parent();
		Son son = new Son();

		Class parentClazz = null;
		Class sonClazz = null;
		try {
			parentClazz = Class.forName("cn.com.sky.basics.reflect.Parent");
			sonClazz = Class.forName("cn.com.sky.basics.reflect.Son");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(Parent.class == Parent.class);
		System.out.println(Parent.class == parent.getClass());
		System.out.println(Parent.class == parentClazz);

		System.out.println(Son.class == Son.class);
		System.out.println(Son.class == son.getClass());
		System.out.println(Son.class == sonClazz);

		System.out.println(parentClazz == sonClazz);

		System.out.println(parent instanceof Parent);

		// 父类不是子类的instance
		System.out.println("parent instanceof Son:" + (parent instanceof Son));

		// 子类是父类的instance
		System.out.println("son instanceof Parent:" + (son instanceof Parent));

		System.out.println(son instanceof Son);

	}
}
