package cn.com.sky.basics;

public class TestThis {

	public TestThis() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		TestThis obj = new TestThis();
		System.out.println(obj.toString());
		obj.print();
	}

	void print() {
		System.out.println(this);
	}

}