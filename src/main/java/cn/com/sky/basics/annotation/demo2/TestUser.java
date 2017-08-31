package cn.com.sky.basics.annotation.demo2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import cn.com.sky.basics.annotation.demo2.anno.Column;
import cn.com.sky.basics.annotation.demo2.anno.Table;

public class TestUser {

	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setId(3);
		user.setName("aaaaaaaaa");
		user.setAge(125);

		// Class<User> userClazz = (Class<User>) Class.forName( "anotation.User");
		Class<? extends User> userClazz = user.getClass();
		// Class userClazz = user.getClass();
		Table table = (Table) userClazz.getAnnotation(Table.class); // 类的注解
		System.out.println("表名称 ： " + table.name()); // 注解的名称

		Field[] fields = userClazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			Column column = field.getAnnotation(Column.class);// 属性的注解
			System.out.println("column的注解名称:" + column.value() + ",注解：isKey:" + column.isKey());// 打印属性上的注解

			String fieldName = field.getName(); // 得到属性名称
			Class<?> clazz = field.getType();// 得到属性类型
			System.out.println(fieldName + "  字段类型    " + clazz);

			field.setAccessible(true);// 可以访问私有变量
			System.out.println(fieldName + "  调用字段变量取得字段值  " + field.get(user));// 打印对象的该属性的值
			Method method = userClazz.getMethod("get" + toUpperCaseFirstOne(fieldName));// 调用get取得该对象的值
			System.out.println(fieldName + "  调用字段get方法取出字段值  " + method.invoke(user));

			System.out.println("判断字段类型是否为整形：" + (clazz == Integer.class));// 判断一个字段的类型
			System.out.println("============");

		}
		// Object name = 1;
		// System.out.println( name.getClass().equals( Integer.class) );

	}

	/**
	 * 首字母转大写
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}
}
