package cn.com.sky.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class Test1 {


	@Test
	public void testFor() {

		List<Person> persons = new ArrayList<Person>();

		for (Iterator<Person> iterator = persons.iterator();;) {
			Person person = iterator.next();
			System.out.println(person.getName() + "" + person.getAge());
			if (!iterator.hasNext())
				break;
		}

	}

	@Test
	public void testWhile() {

		List<Person> persons = new ArrayList<Person>();

		Iterator<Person> it = persons.iterator();
		while (it.hasNext()) {
			Person person = it.next();
			System.out.println(person.getName() + "" + person.getAge());
		}
	}

	private class Person {

		String name;
		Integer age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
	}
}
