package cn.com.todo.test_initialclass2;

public class A {
	
	public static int aa=12;
	
	static{
		System.out.println(aa);
	}
	
	static{
		System.out.println("static in A..1");
	}
	
	{
		System.out.println("NOMARL in A..1");
	}
	
	F1 f1=new F1("a1");
	
	static{
		System.out.println("static in A..2");
	}
	
	{
		System.out.println("NOMARL in A..2");
	}
	
	public A(){
		System.out.println("A...");
	}
	
	F2 f2=new F2("a2");
	
	static{
		System.out.println("static in A..3");
	}
	
	{
		System.out.println("NORMAL in A..3");
	}
}
