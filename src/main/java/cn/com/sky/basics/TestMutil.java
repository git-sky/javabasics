package cn.com.sky.basics;

public class TestMutil {

	public static void main(String[] args) {
		/**
		 * test A
		 * 
		 * i am B
		 */
		A a = new B();
		test(a);
	}

	public static void test(A a) {
		System.out.println("test A");
		a.print();

	}

	public static void test(B b) {
		System.out.println("test B");
		b.print();
	}

}

class A {
	public void print() {
		System.out.println("i am A");
	}
}

class B extends A {
	public void print() {
		System.out.println("i am B");
	}
}
