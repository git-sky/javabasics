package cn.com.sky.basics.annotation.user;

import cn.com.sky.basics.annotation.user.anno.Column;
import cn.com.sky.basics.annotation.user.anno.Table;

@Table(name = "s_user")
public class User {

	@Column(value = "id", isKey = true)
	private Integer id;

	// 等同于 value="s_name"
	@Column("s_name")
	private String name;

	@Column(value = "s_age")
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
