package cn.com.todo.test_initialclass2;

public class C extends B{
	
	static{
		System.out.println("static in C..1");
	}

	int c=3;
	F1 f1=new F1("c1");
	
	static{
		System.out.println("static in C..2");
	}
	
	public C(){
		System.out.println("C...");
		show();
	}
	F2 f2=new F2("c2");
	
	public static void main(String[] args){
		new C();
		//B b=new C();
		//b.show();
		//System.out.println(A.aa);
		
	}
	
	public void show(){
		System.out.println("C...show()");
		System.out.println(c);
	}
	
	F2 f21=new F2("c21");
	
	static{
		System.out.println("static in C..3");
	}
}
