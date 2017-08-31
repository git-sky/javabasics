package cn.com.sky.property_copy;

public class Person2 {
	private String name;
	private String sex;
	private String age;

	public Person2(String name, String sex, String age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public Person2() {

	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person2[" + name + ", " + sex + ", " + age + "]";
	}
}
