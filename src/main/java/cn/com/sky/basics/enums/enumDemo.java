package cn.com.sky.basics.enums;

public enum enumDemo {
	A, B, C, d;

	public static void main(String[] args) {
		for (enumDemo c : enumDemo.values()) {
			System.out.println(c.ordinal() + ":" + c.name());
		}
	}

}
