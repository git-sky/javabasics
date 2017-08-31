package cn.com.sky.basics.inherits;

class Grandpa {

	protected Grandpa() {
		System.out.println("default Grandpa");
	}

	public Grandpa(String name) {
		System.out.println(name);
	}

}

class Father extends Grandpa {

	protected Father() {
		System.out.println("default Father");
	}

	public Father(String grandpaName, String fatherName) {
		super(grandpaName);
		System.out.println(fatherName);
	}

}

class Child extends Father {

	public Child() {
		System.out.println("default Child");
	}

	public Child(String grandpaName, String fatherName, String sonName) {
		super(grandpaName, fatherName);
		System.out.println(sonName);
	}

}

public class TestInherit {
	public static void main(String args[]) {
		Child s1 = new Child("My Grandpa", "My Father", "My Child"); // ①
		Child s2 = new Child(); // ②
	}
}