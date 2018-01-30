package cn.com.sky.tools.json.fastjson;

import com.alibaba.fastjson.JSONObject;

public class TestPerson {

	public static void main(String[] args) {

		Person person = new Person(new Long(123456L), "张三", 25, 160, 55.23);
		final String reqStr = JSONObject.toJSONString(person);
		System.out.println(reqStr);

		Person p = JSONObject.parseObject(reqStr, Person.class);
		System.out.println(p);
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getHeight());
		System.out.println(p.getWeight());

	}
}
