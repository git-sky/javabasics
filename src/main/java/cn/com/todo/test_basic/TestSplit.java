package cn.com.todo.test_basic;

public class TestSplit {

	public static void main(String[] args) {
		//String divide_content="online_times_m/uv/tv_column_times_m";
		
		String divide_content="a/b/c";
		String[] divides = divide_content.split("/");
//		int len=divides.length;
//		StringBuffer s_exp=new StringBuffer();
//		StringBuffer divide_exp=new StringBuffer();
//		StringBuffer round_exp=new StringBuffer();
//
//		for(int i=len-1;i>=0;i--){
//			String divide = divides[i];
//			s_exp.append("if(").append(divide).append(" = 0,0,");
//			System.out.println(divide);
//		}
//
//		for(int i=0;i<len;i++){
//			String divide = divides[i];
//			divide_exp.append(divide);
//			if(i<len-1){
//				divide_exp.append("/");
//			}
//		}
//		
//		round_exp.append("round(").append(divide_exp).append(",2)");
//		for(int i=0;i<len;i++){
//			round_exp.append(")");
//		}
//		
//		s_exp.append(round_exp);
//		System.out.println(s_exp);
		
		
		
		int len=divides.length;
		StringBuffer s_exp=new StringBuffer();
		StringBuffer divide_exp=new StringBuffer();
		StringBuffer round_exp=new StringBuffer();

		for(int i=len-1;i>=0;i--){
			String divide = divides[i];
			s_exp.append("if(sum(").append(divide).append(") = 0,0,");
			System.out.println(divide);
		}

		for(int i=0;i<len;i++){
			String divide = divides[i];
			divide_exp.append("sum(").append(divide).append(")");
			if(i<len-1){
				divide_exp.append("/");
			}
		}
		
		round_exp.append("round(").append(divide_exp).append(",6)");
		for(int i=0;i<len;i++){
			round_exp.append(")");
		}
		s_exp.append(round_exp);
		
		System.out.println(s_exp);
		
	}
}
