package cn.com.sky.basics.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestReflect {

	public String name = "john";
	protected String addr = "american";
	private int age = 12;

	@Before
	public void setUp() {
		System.out.println(this.name);
		System.out.println(this.addr);
		System.out.println(this.age);
		System.out.println("=============setUp=================");
	}

	@After
	public void tearDown() {
		System.out.println(this.name);
		System.out.println(this.addr);
		System.out.println(this.age);

		System.out.println("=============tearDown=================");

	}

	@Test
	public void getName() {
		// 获取类名称
		System.out.println(getClass().getName());
		System.out.println(this.getClass().getName());
		System.out.println(this);
	}

	@Test
	public void getFields() {

		try {

			// //getField只能获取public域，正常设置
			Field field = this.getClass().getField("name");
			field.setAccessible(true);
			field.set(this, "jobs");

			// // getField只能获取public域，所以会报错
			// Field field2 = this.getClass().getField("addr");
			// field2.setAccessible(true);
			// field2.set(this, "china");
			//
			// // getField只能获取public域，所以会报错
			// Field field3 = this.getClass().getField("age");
			// field3.setAccessible(true);
			// field3.set(this, "222");

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	@Test
	public void getMethod() {

		try {

			// //getField只能获取public域，正常设置
			Method method = this.getClass().getMethod("setName", String.class);

			method.invoke(this, "hasd");

			// Field field2 = this.getClass().getField("addr");
			// field2.setAccessible(true);
			// field2.set(this, "china");
			//
			// // getField只能获取public域，所以会报错
			// Field field3 = this.getClass().getField("age");
			// field3.setAccessible(true);
			// field3.set(this, "222");

		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getDeclareFields() {

		try {

			// getDeclaredField 获取全部域

			Field field = this.getClass().getDeclaredField("name");
			field.setAccessible(true);
			field.set(this, "jobs");

			Field field2 = this.getClass().getDeclaredField("addr");
			field2.setAccessible(true);
			field2.set(this, "china");

			Field field3 = this.getClass().getDeclaredField("age");
			field3.setAccessible(true);
			field3.set(this, 45);

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
