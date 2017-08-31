package cn.com.sky.basics.enums;

public class TestEnum {
	enumDemo s = enumDemo.d;

	public static void main(String[] args) {

		new TestEnum().print();

	}

	public void print() {
		switch (s) {
		case A:
			System.out.println(s);
			break;

		case B:
			System.out.println(s);
			break;

		case C:
			System.out.println(s);
			break;

		case d:
			System.out.println(s);
			break;

		}
	}

}
