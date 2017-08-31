package cn.com.sky.basics;

class Parent {
	int a = 5;
	int b = 3;

	public void show() {
		System.out.println(a + b);
	}
}

class Son extends Parent {

}

public class TestOverride2 {

	public static void main(String args[]) {

		Parent parent = new Parent() {
			@Override
			public void show() {// 重写show方法
				System.out.println(a * b);
			}
		};

		parent.show();

		Parent parent2 = new Parent();
		parent2.show();

		Son son = new Son();
		son.show();
	}
}
