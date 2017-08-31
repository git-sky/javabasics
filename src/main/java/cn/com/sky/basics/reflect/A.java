package cn.com.sky.basics.reflect;

import java.lang.reflect.Modifier;

import java.lang.reflect.Field;

public class A {
	private String str1;
	private static final String str2 = "str";

	public static void main(String[] args) {
		Field[] fields = A.class.getDeclaredFields();
		for (Field f : fields) {
			System.out.println("字段" + f.getName() + "访问修饰符是否包括 private:" + Modifier.isPrivate(f.getModifiers()));
			System.out.println("字段" + f.getName() + "访问修饰符是否包括 static:" + Modifier.isStatic(f.getModifiers()));
			System.out.println("字段" + f.getName() + "访问修饰符是否包括 public:" + Modifier.isPublic(f.getModifiers()));
		}
	}

}