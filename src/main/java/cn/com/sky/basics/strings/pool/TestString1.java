package cn.com.sky.basics.strings.pool;

/**
 * <pre>
 * 
 * jdk1.7的常量池已经在Java堆上分配内存。
 * 
 * HotSpot1.7实现的常量池在java堆上分配内存，执行intern方法时，如果常量池已经存在相等的字符串，则直接返回字符串引用，否则复制该字符串引用到常量池中并返回；
 */
public class TestString1 {
	public static void main(String[] args) {

		String s2 = new String("abc");
		String s3 = new String("abc");
		String s1 = "abc";

		System.out.println(s1 == s2.intern());
		System.out.println(s1 == s3.intern());
		System.out.println(s2.intern() == s3.intern());

	}
}
