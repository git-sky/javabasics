package cn.com.sky.tools.json.gson;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonToPerson {

	public static void main(String[] args) {
		Gson gson = new Gson();

		String str="{name:'name0','age':1}";
		Person person = gson.fromJson(str, Person.class);
		System.out.println(person.toString());
		
		String str2="[{'name':'name0','age':0},{'name':'name1','age':5},{'name':'name2','age':10}]";
		
		List<Person> ps = gson.fromJson(str2, new TypeToken<List<Person>>(){}.getType());
		for (int i = 0; i < ps.size(); i++) {
			Person p = ps.get(i);
			System.out.println(p.toString());
		}
		

		
	}

}
