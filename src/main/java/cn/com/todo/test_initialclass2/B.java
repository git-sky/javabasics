package cn.com.todo.test_initialclass2;

public class B extends A{
	int c=2;
	
	static{
		System.out.println("static in B..1");
	}
	
	public static A a=new A();
	

	F1 f1=new F1("b1");
	
	static{
		System.out.println("static in B..2");
	}
	
	public B(){
		System.out.println("B...");
		//show(); //����������show��������Ϊ��ʱ����ı�����δ��ʼ�����������Ϊ0.
	}
	F2 f2=new F2("b2");
	
	static{
		System.out.println("static in B..3");
	}
	
	public void show(){
		System.out.println("B...show()");
		System.out.println(c);
	}
	
	static{
		System.out.println("static in B..4");
	}
	
	public static void main(String[] args){
		new B();
		//B b=new C();
		//b.show();
	}
	
}
