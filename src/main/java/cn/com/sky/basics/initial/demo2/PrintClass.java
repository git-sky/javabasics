package cn.com.sky.basics.initial.demo2;

/**
 * 类的初始化顺序。
 * 1.先父类和子类子类的静态初始化(只会初始化一次。)
 * 2.父类实例初始化
 * 3.父类构造方法(如果有多个构造方法，取决于子类调用父类构造方法的方式。默认是使用默认构造方法。)
 * 4.子类实例初始化
 * 5.子类构造方法
 */
public class PrintClass {
	public static void main(String[] args) {
		new B();
	}

	PrintClass(String var) {
		System.out.println(var);
	}
}

class A {
	static PrintClass pClassA1 = new PrintClass("A. 静态成员的初始化1");
	static {
		System.out.println("A. 静态初始化块1");
	}
	static {
		System.out.println("A. 静态初始化块2");
	}
	static PrintClass pClassA2 = new PrintClass("A. 静态成员的初始化2");

	{
		System.out.println("A. 实例初始化块1");
	}
	PrintClass pClassA = new PrintClass("A. 实例成员的初始化");
	{
		System.out.println("A. 实例初始化块2");
	}

	public int Avar;

	public A() {
		System.out.println("A. 构造方法");
		doSomething();
	}
	
	public A(String str) {
		System.out.println("A. 有参构造方法");
		doSomething();
	}

	private void doSomething() {
		// public void doSomething() {
		Avar = 1111;
		System.out.println("Avar=" + Avar);
	}
}

// class B extends A
class B extends A {
	public static void main(String[] args) {
		new B();
	}

	public int Bvar = 2222;

	{
		System.out.println("B. 实例初始化块1");
	}
	{
		System.out.println("B. 实例初始化块2");
	}
	PrintClass pClassB = new PrintClass("B. 实例成员的初始化");

	static {
		System.out.println("B. 静态初始化块1");
	}
	static PrintClass pClassB1 = new PrintClass("B. 静态成员的初始化1");
	static PrintClass pClassB2 = new PrintClass("B. 静态成员的初始化2");
	static {
		System.out.println("B. 静态初始化块2");
	}

	public B() {
//		super("a");//默认调用无参构造方法
		System.out.println("B. 构造方法");
		doSomething();
	}

	public void doSomething() {
		System.out.println("Bvar=" + Bvar);
	}
}

// 可以看到运行结果为：
// A. 静态成员的初始化1
// A. 静态初始化块1
// A. 静态初始化块2
// A. 静态成员的初始化2
// B. 静态初始化块1
// B. 静态成员的初始化1
// B. 静态成员的初始化2
// B. 静态初始化块2
// A. 实例初始化块1
// A. 实例成员的初始化
// A. 实例初始化块2
// A. 构造方法
// Avar=1111
// B. 实例初始化块1
// B. 实例初始化块2
// B. 实例成员的初始化
// B. 构造方法
// Bvar=2222
//

// 由此可知当新建一java对象（上面main方法中new B()）时，它的内部初始化顺序为：
// 1． 父类静态成员和静态初始化块 ，按在代码中出现的顺序依次执行
// 2． 子类静态成员和静态初始化块 ，按在代码中出现的顺序依次执行
// 3． 父类实例成员和实例初始化块 ，按在代码中出现的顺序依次执行
// 4． 父类构造方法
// 5． 子类实例成员和实例初始化块 ，按在代码中出现的顺序依次执行
// 6． 子类构造方法
