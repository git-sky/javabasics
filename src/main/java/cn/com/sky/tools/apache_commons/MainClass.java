package cn.com.sky.tools.apache_commons;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class MainClass {
	public static void main(String[] args) {
		MyClass one = new MyClass("Becker", 35);
		MyClass two = new MyClass("Becker", 35);
		MyClass three = new MyClass("Agassi", 33);

		System.out.println("One>>>" + one);
		System.out.println("Two>>>" + two);
		System.out.println("Three>>>" + three);

		System.out.println("one equals two? " + one.equals(two));
		System.out.println("one equals three? " + one.equals(three));

		System.out.println("One HashCode>>> " + one.hashCode());
		System.out.println("Two HashCode>>> " + two.hashCode());
		System.out.println("Three HashCode>>> " + three.hashCode());
	}
}

class MyClass {
	private String name = null;
	private int age = 0;

	public MyClass(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public String toString() {
//		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}