package cn.com.sky.basics.test_polymorphism;

//多态性
class Father {
	public int a = 1;

	public void method(int a) {
		System.out.println("I'm a father ");
		System.out.println("a = " + a);
	}
}

public class Child extends Father {
	public int a = 2;

	public void method(int a) {
		System.out.println("I'm a child ");
		System.out.println("a = " + a);

	}

	public static void main(String[] args) {
		Father f = new Child();
		f.method(f.a);
	}
}

/**
 * <pre>
 * 结果是：I'm a child a = 1
 * 
 * 可以看出在JAVA中，父子类之间实例方法采用的是动态绑定，即运行时绑定类型而非编译时，所以f在运行时指向的是Child对象，所以调用子类方法，
 *  而对于实例变量则采用静态绑定，即编译时决定的，编译做的事主要是就是把java文件编译成.class文件，而接下来Java虚拟机会把.class文件装载到虚拟机中进行包括验证 ，静态变量初始化 ，符号引用转直接引用等，
 * 然后执行器会执行.class文件，相应的会有对象的初始化等，编译时是不知道f实际的指向的 ，只知道f是Father类型的，所以f.a拿到的是父类的变量a的值。 这是JAVA的多态特征。
 */
