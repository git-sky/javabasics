package cn.com.sky.tools.serializable.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * Fastjson序列化与反序列化对象
 * 
 * Fastjson支持java bean的直接序列化。 可以使用com.alibaba.fastjson.JSON这个类进行序列化和反序列化。
 * 
 * 常用的序列化操作都可以在JSON类上的静态方法直接完成。
 */
public class TestSerial {

	public static void main(String[] args) {
		Student user = new Student();
		user.setName("张三");
		user.setAge(22);

		// 序列化,//将JavaBean序列化为JSON文本(常用)
		String text = JSON.toJSONString(user);
		System.out.println(text);

		// 反序列化,//把JSON文本parse为JavaBean(常用)
		Student user1 = JSON.parseObject(text, Student.class);
		System.out.println(user1.getName());
		System.out.println(user1.getAge());
	}

}