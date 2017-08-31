package cn.com.sky.basics.initial.demo2;

class S {
	private int i = 5;
	
	
	static {
		System.out.println("aaaaaaaaa");
	}

	{
		System.out.println(i);
		System.out.println("创建新对象");
	}

	public S() {
		System.out.println("sdjfksd");
	}

	public S(int a) {
		System.out.println("开始执行构造方法");
		i = a;
		System.out.println("执行完毕");
	}
}

public class TestNonStaicBlock {

	public static void main(String[] args) {
		new S();
		new S();
		new S(3);
		new S(5);

		System.out.println("Hello World!");
	}
}
