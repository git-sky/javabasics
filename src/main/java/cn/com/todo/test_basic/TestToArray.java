package cn.com.todo.test_basic;
import java.util.ArrayList;

public class TestToArray {
	public static void main(String args[]) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("j");
		a.add("k");
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.toArray()[i]);
		}
		
		System.out.println("========================");
		
		vectorToArray2(a);
		
		System.out.println("========================");
		
		Object[] obj =new Object[] {11,31,3,2};
		
		System.out.println(obj[0]);
		System.out.println(obj[3]);
		System.out.println(obj[2]);
		System.out.println(obj[1]);
	}

	public static String[] vectorToArray2(ArrayList<String> a) {
		String[] newText = (String[]) a.toArray(new String[0]);
		System.out.println(newText[0]);
		System.out.println(newText[1]);
		
		String[] newStrings = (String[])a.toArray(newText);  

		System.out.println(newStrings[0]);
		System.out.println(newStrings[1]);
		return newText;
	}

}