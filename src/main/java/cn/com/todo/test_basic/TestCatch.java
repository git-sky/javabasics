package cn.com.todo.test_basic;
public class TestCatch {

	public static void main(String ars[]){
		
		System.out.println("result="+new TestCatch().test());
	
	}
	
	public int  test(){
		int x;
		//System.out.println(x);
		try{
			x=1;
			System.out.println(x);
			return x;
			
			
		}catch(Exception e){
			x=2;
			return x;
			
		}finally{
			x=3;
			System.out.println(x);
		}
	}
}
