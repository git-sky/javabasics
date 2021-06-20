package cn.com.todo;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<=12000;i++){
			sb.append(String.valueOf(i));
			sb.append(",");
			System.out.println(String.valueOf(i));
		}
		String s=sb.substring(0, sb.length()-1);
		
		System.out.println(s.length());
		
		 String[] strArray=s.split(",");
		 
		 System.out.println(strArray.length);
		 for(int i=0;i<=strArray.length-1;i++){
			 System.out.println(strArray[i]);
		 }
		 
		 String act_desc="asdv	d        \r\t\n         				";
		 String sd=act_desc.trim();
		 System.out.println(sd);
		 
	}

}
