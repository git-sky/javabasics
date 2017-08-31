package cn.com.sky.basics.strings;

import org.junit.Test;

public class TestSplit {

	/**
	 * 【推荐】使用索引访问用String的split方法得到的数组时，需做最后一个分隔符后有无内容的检查，否则会有抛IndexOutOfBoundsException的风险。
	 */
	@Test
	public void test() {
		String str = "a,b,c,,,,";
		String[] ary = str.split(",");
		// 预期大于3，结果是3
		System.out.println(ary.length);
		for (int i = 0; i < ary.length; i++) {
			System.out.println(ary[i]);
			System.out.println("---------------------");
		}
	}

	public static void main(String[] args) {
		// String divide_content="online_times_m/uv/tv_column_times_m";

		String divide_content = "a/b/c";
		String[] divides = divide_content.split("/");
		// int len=divides.length;
		// StringBuffer s_exp=new StringBuffer();
		// StringBuffer divide_exp=new StringBuffer();
		// StringBuffer round_exp=new StringBuffer();
		//
		// for(int i=len-1;i>=0;i--){
		// String divide = divides[i];
		// s_exp.append("if(").append(divide).append(" = 0,0,");
		// System.out.println(divide);
		// }
		//
		// for(int i=0;i<len;i++){
		// String divide = divides[i];
		// divide_exp.append(divide);
		// if(i<len-1){
		// divide_exp.append("/");
		// }
		// }
		//
		// round_exp.append("round(").append(divide_exp).append(",2)");
		// for(int i=0;i<len;i++){
		// round_exp.append(")");
		// }
		//
		// s_exp.append(round_exp);
		// System.out.println(s_exp);

		int len = divides.length;
		StringBuffer s_exp = new StringBuffer();
		StringBuffer divide_exp = new StringBuffer();
		StringBuffer round_exp = new StringBuffer();

		for (int i = len - 1; i >= 0; i--) {
			String divide = divides[i];
			s_exp.append("if(sum(").append(divide).append(") = 0,0,");
			System.out.println(divide);
		}

		for (int i = 0; i < len; i++) {
			String divide = divides[i];
			divide_exp.append("sum(").append(divide).append(")");
			if (i < len - 1) {
				divide_exp.append("/");
			}
		}

		round_exp.append("round(").append(divide_exp).append(",6)");
		for (int i = 0; i < len; i++) {
			round_exp.append(")");
		}
		s_exp.append(round_exp);

		System.out.println(s_exp);

		String a = "a#####��������㷢$$$$$b#####������㿪���";
		String as[] = a.split("\\$\\$\\$\\$\\$");
		for (String ai : as) {
			// System.out.println(ai);
			String bs[] = ai.split("#####");
			for (String bi : bs) {
				System.out.println(bi);
			}
		}

	}
}
