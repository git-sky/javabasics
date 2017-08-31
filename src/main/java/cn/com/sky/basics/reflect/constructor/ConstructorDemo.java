package cn.com.sky.basics.reflect.constructor;

import java.lang.reflect.Constructor;

import org.junit.Test;

/**
 * 获取指定的构造方法: getConstructor(cls)
 */
public class ConstructorDemo {

	@Test
	public void test1() {

		try {
			Class cls[] = new Class[] { String.class };
			Constructor c = String.class.getConstructor(cls);
			System.out.println(c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void test2() {

		try {
			Class cls[] = new Class[] { String.class, Integer.class };
			Constructor c = Target.class.getConstructor(cls);// 获取指定的构造方法
			System.out.println(c);
			Target target = (Target) c.newInstance("abc", 123);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void test3() {

		try {
			Constructor c = Target.class.getConstructor();// 获取指定的构造方法
			System.out.println(c);
			Target target = (Target) c.newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}