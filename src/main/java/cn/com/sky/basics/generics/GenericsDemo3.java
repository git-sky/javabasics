package cn.com.sky.basics.generics;

interface InfoIface<T> { // 在接口上定义泛型
	public T getVar(); // 定义抽象方法，抽象方法的返回值就是泛型类型
}

class InfoImpl<T> implements InfoIface<T> { // 定义泛型接口的子类
	private T var; // 定义属性

	public InfoImpl(T var) { // 通过构造方法设置属性内容
		this.setVar(var);
	}

	public void setVar(T var) {
		this.var = var;
	}

	public T getVar() {
		return this.var;
	}
};

class InfoImpl2 implements InfoIface<String> { // 定义泛型接口的子类
	private String var; // 定义属性

	public InfoImpl2(String var) { // 通过构造方法设置属性内容
		this.setVar(var);
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getVar() {
		return this.var;
	}
};

public class GenericsDemo3 {
	public static void main(String arsg[]) {
		InfoIface<String> i = null; // 声明接口对象
		i = new InfoImpl<String>("汤姆"); // 通过子类实例化对象
		System.out.println("内容：" + i.getVar());

		InfoIface j = null; // 声明接口对象
		j = new InfoImpl2("鸬鹚"); // 通过子类实例化对象
		System.out.println("内容：" + j.getVar());
	}
};
