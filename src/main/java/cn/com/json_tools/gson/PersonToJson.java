package cn.com.json_tools.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class PersonToJson {

	public static void main(String[] args) {
		// ���Json�ַ�

		Gson gson = new Gson();
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) {
			Person p = new Person();
			p.setName("name" + i);
			p.setAge(i * 5);
			persons.add(p);
		}
		String str = gson.toJson(persons);
		System.out.println(str);
	}
}
