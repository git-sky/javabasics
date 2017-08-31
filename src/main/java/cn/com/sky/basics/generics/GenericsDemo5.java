package cn.com.sky.basics.generics;

/**
 * <pre>
 * 
 * <?>
 * 通配符，适配所有类型
 * 
 * <? extends Number>
 * 上界用extends关键字声明，表示参数化的类型可能是所指定的类型，或者是此类型的子类。
 * 
 * <? super String>
 * 下界用super进行声明，表示参数化的类型可能是所指定的类型，或者是此类型的父类型，直至Object。
 * 
 * </pre>
 */
class Info<T> {
	private T var; // 定义泛型变量

	public void setVar(T var) {
		this.var = var;
	}

	public T getVar() {
		return this.var;
	}

	public String toString() {
		return this.var.toString();
	}
}

public class GenericsDemo5 {
	public static void main(String args[]) {

		wildcard();// 通配符
		// son();// 子类
		// father();// 父类
	}

	static void wildcard() {
		Info<String> i = new Info<String>(); // 使用String为泛型类型
		i.setVar("it");
		fun(i);

		Info<Integer> t = new Info<Integer>(); // 使用Integer为泛型类型
		t.setVar(8);
		fun(t);
	}

	public static void fun(Info<?> temp) { // 通配符，可以接收任意的泛型对象
		System.out.println(temp);
	}

	static void son() {
		Info<Integer> i1 = new Info<Integer>(); // 声明Integer的泛型对象
		Info<Float> i2 = new Info<Float>(); // 声明Float的泛型对象
		i1.setVar(30); // 设置整数，自动装箱
		i2.setVar(30.1f); // 设置小数，自动装箱
		fun2(i1);
		fun2(i2);
	}

	static void fun2(Info<? extends Number> temp) { // 只能接收Number及Number的子类
		System.out.println(temp);
	}

	static void father() {
		Info<String> i1 = new Info<String>(); // 声明String的泛型对象
		Info<Object> i2 = new Info<Object>(); // 声明Object的泛型对象
		i1.setVar("hello");
		i2.setVar(new Object());
		fun3(i1);
		fun3(i2);
	}

	static void fun3(Info<? super String> temp) { // 只能接收String及String的父类
		System.out.println(temp);
	}

}