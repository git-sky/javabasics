package cn.com.sky;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * <pre>
 * 
 * 为了让程序员们更好的操作Java对象的属性，SUN公司开发了一套API，被业界内称为：内省；内省的出现有利于了对类对象属性的操作，减少了代码的数量。
 * 
 * 内省访问JavaBean有两种方法：
 * 
 * 一、通过Introspector类获得Bean对象的 BeanInfo，然后通过 BeanInfo 来获取属性的描述器（ PropertyDescriptor ），通过这个属性描述器就可以获取某个属性对应的 getter/setter 方法，然后通过反射机制来调用这些方法。
 * 
 * 二、通过PropertyDescriptor来操作Bean对象。
 * 
 * </pre>
 */
public class TestIntrospector {
	@Test
	public void test() throws Exception {

		Student student = new Student();

		// 1.通过Introspector来获取bean对象的beaninfo
		BeanInfo bif = Introspector.getBeanInfo(Student.class);

		// 2.通过beaninfo来获得属性描述器(propertyDescriptor)
		PropertyDescriptor pds[] = bif.getPropertyDescriptors();

		// 3.通过属性描述器来获得对应的get/set方法
		for (PropertyDescriptor pd : pds) {

			// 4.获得并输出字段的名字
			System.out.println(pd.getName());

			// 5.获得并输出字段的类型
			System.out.println(pd.getPropertyType());

			if (pd.getName().equals("name")) {

				// 6.获得PropertyDescriptor对象的写方法
				Method md = pd.getWriteMethod();

				// 7.执行写方法
				md.invoke(student, "Lou_Wazor");

			}

		}

		// 8.输出所赋值字段的值
		System.out.println(student.getName());
	}
	
	@Test
    public void test01()throws Exception{

           Student st = new Student();

           //1.通过构造器来创建PropertyDescriptor对象
           PropertyDescriptor pd = new PropertyDescriptor("name", Student.class);

           //2.通过该对象来获得写方法
           Method method = pd.getWriteMethod();

           //3.执行写方法
           method.invoke(st, "Lou_Wazor");

           //4.输出对象字段的值
           System.out.println(st.getName());

           //5.通过对象获得读方法
           method = pd.getReadMethod();

           //6.执行读方法并定义变量接受其返回值并强制塑形
           String name = (String) method.invoke(st, null);

           //7.输出塑形后的值
           System.out.println(name);

    }
	
	
}