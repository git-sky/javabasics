package cn.com.sky.basics.inherits;

class fruit {
	static String color = "父类的黄色";
	String size = "父类大";

	static String getFruitColor() {
		return color;
	}

	String getFruitSize() {
		return size;
	}
}

public class TestOverrideApple extends fruit {
	static String appleColor = "子类的绿色";
	String appleSize = "子类小";

	static String getFruitColor() {
		return appleColor;
	}

	String getFruitSize() {
		return appleSize;
	}

	public static void main(String args[]) {
		fruit f = new TestOverrideApple();
		System.out.println(f.getFruitColor());
		System.out.println(f.getFruitSize());
	}
}

// 输出结果为：父类的黄色 子类小