package cn.com.todo.test_inner;

public class testInfer {

	public static void main(String args []){
	
		tt action = new tt() {
			public Object a(){
				return "hhhhhh";
			}
		};

		System.out.println(action.a());
	}

}
