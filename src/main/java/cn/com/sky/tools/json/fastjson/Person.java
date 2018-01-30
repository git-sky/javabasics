package cn.com.sky.tools.json.fastjson;

public class Person {

	private Long id;
	private String name;
	private int age;
	private Integer height;

	private double weight;

	public Person() {
		super();
	}

	public Person(Long id, String name, int age, Integer height, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
