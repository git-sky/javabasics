package cn.com.sky.basics.class_loader;

public class A {
	static {
		System.out.println("static");
	}
	{
		System.out.println("normal");
	}

	public A() {
		System.out.println("new A()");
	}

}
