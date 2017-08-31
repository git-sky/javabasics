package cn.com.sky.basics.strings.pool;

/**
 * <pre>
 * 
 *  HotSpot1.7 实现的常量池在java堆上分配内存，执行intern方法时，如果常量池已经存在相等的字符串，则直接返回字符串引用，否则复制该字符串引用到常量池中并返回；
 * 
 * 
 * 1、JDK1.6的结果：false false
 * 2、JDK1.7的结果：true false
 * 
 * </pre>
 */
public class TestString3 {

	public static void main(String args[]) {

		// String s1=new String("StringTest");
		String s1 = new StringBuffer().append("String").append("Test").toString();
		System.out.println(s1.intern() == s1);
		
//		s1.intern()

		// String s2=new String("java");
		String s2 = new StringBuffer().append("ja").append("va").toString();
		System.out.println(s2.intern() == s2);

	}

}
