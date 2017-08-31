package cn.com.sky.alpha_work;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");// 读取bean.xml中的内容
		Person p = ctx.getBean("person", Person.class);// 创建bean的引用对象
		p.info();
	}
}