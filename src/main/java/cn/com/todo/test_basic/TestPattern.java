package cn.com.todo.test_basic;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

	public static void main(String[] args) {

		Pattern p = Pattern.compile("\\d{2}");
		Matcher m = p.matcher("one cat two cat3452345s in the yard");
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			//m.appendReplacement(sb, "dog");
			 System.out.println(m.group()); 
		}
		//m.appendTail(sb);
		//System.out.println(sb.toString());
		
		

		String str="        10Ԫ 1000��   ���  10000Ԫ   100000RMB       "; 

		System.out.println(str);
		str=str.replaceAll("^\\s+|\\s+$", ""); 
		System.out.println(str);

	}

}
