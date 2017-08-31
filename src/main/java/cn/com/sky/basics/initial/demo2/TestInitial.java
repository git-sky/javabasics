package cn.com.sky.basics.initial.demo2;

class bike {
	static {
		System.out.println("父类的静态块语句");
	}

	{
		System.out.println("父类的实例块语句");
	}

	public String color;

	public bike() {
		System.out.println("父类bike的无参构造函数");
	}

	public bike(String color) {
		this.color = color;
		System.out.println("父类bike的有参构造函数");
	}

	public void show() {
		System.out.println("父类的show方法");
	}
}

class aceing extends bike {
	static {
		System.out.println("子类的静态块语句");
	}
	{
		System.out.println("子类的实例块语句");
	}
	public int size;

	public aceing() {
		super("黄色");// 调用父类有参构造函数
		this.size = size;
		System.out.println("子类aceing的无参构造函数");
	}

	public void show() {
		System.out.println(color + ":" + size);
	}
}

public class TestInitial {
	public static void main(String args[]) {
		aceing a = new aceing();
		a.show();
	}

}
