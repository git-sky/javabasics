package cn.com.sky.basics.strings.pool;

/**
 * 
 * String s1="aaa"; //1

 String s2=new String("aaa"); //2  
 String s3=new String("aaa"); //3 

 s2 == s3       ----->false

 s2 == s1       ----->false

 s2.equals(s3)----->true

 s2.equals(s1)----->true

 上面的代码是几个对象？

 首先明白两个问题：

 1.什么是对象？

 2.内存具体是什么？

 对象是类的具体实例，通过new创建出来。

 内存大体分为四个区域：堆，栈，全局/静态数据区，代码区。

 堆：存储new出来的对象；栈：存储局部变量；全局/静态数据区：存储静态变量和字符串常量。

 所以基本数据类型变量只占一块内存(栈)，引用类型一般占两块内存(栈和堆)。

 但涉及到字符串时，引用类型就是三块内存(栈、堆和全局/静态数据区)。

 分析：

 第一句：String s1="aaa";

 1:程序在加载到内存中的时候，首先将"aaa"这个字符串常量保存在全局/静态数据区。 
 2:String s1在栈内存中创建了一个引用类型变量s1。
 3:将s1用=指向字符串常量"aaa"。

 第二句：String s2=new String("aaa");

 1:String s2在栈内存中创建了一个引用类型变量s2。
 2:程序在加载到内存中的时候，将"aaa"这个字符串常量保存在全局/静态数据区。 
 3:new String("aaa")这是在堆内存中开辟了一块区域，然后这块区域指向全局/静态数据区的"aaa"。
 4:将引用s2通过=指向堆内存中刚开的一块空间。

 第三句：String s3=new String("aaa");

 原理与第一句相同，在此不做解释。

 所以上面三句创建了两个对象，分别是s2和s3。

 */

public class StringCompare {

	public static void A() {
		String str1 = "java";
		String str2 = "java";
		System.out.println(str1 == str2); // true
	}

	public static void B() {
		String str1 = new String("java");
		String str2 = new String("java");
		System.out.println(str1 == str2); // false
	}

	public static void C() {
		String str1 = "java";
		String str2 = "blog";
		String s = str1 + str2;
		System.out.println(s == "javablog"); // false
	}

	public static void C2() {
		String str1 = "javablog";
		String str2 = "java" + "blog"; // 在编译时被优化成String str2 = "javablog";
		System.out.println(str1 == str2); // true
	}

	public static void D() {
		String s1 = "java";
		String s2 = new String("java");
		System.out.println(s1.intern() == s2.intern()); // true
	}

	public static void E() {
		String str1 = "java";
		String str2 = new String("java");
		System.out.println(str1.equals(str2)); // true
	}

	public static void main(String[] args) {
		A();
		B();
		C();
		C2();
		D();
		E();
	}
}
