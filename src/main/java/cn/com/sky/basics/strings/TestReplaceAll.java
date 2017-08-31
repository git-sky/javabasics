package cn.com.sky.basics.strings;

/**
 * <pre>
 * 
 * replace和replaceAll是JAVA中常用的替换字符的方法,它们的区别是:
 * 
 * 1) replace 的参数是char和CharSequence,即可以支持字符的替换,也支持字符串的替换(CharSequence即字符串序列的意思,说白了也就是字符串);
 * 
 *  2) replaceAll 的参数是regex,即基于规则表达式的替换,比如,可以通过replaceAll("\\d","*")把一个字符串所有的数字字符都换成星号;
 *  
 * 相同点是都是全部替换,即把源字符串中的某一字符或字符串全部换成指定的字符或字符串,如果只想替换第一次出现的,可以使用
 * replaceFirst(),这个方法也是基于规则表达式的替换,但与replaceAll()不同的是,只替换第一次出现的字符串;
 * 另外,如果replaceAll()和replaceFirst()所用的参数据不是基于规则表达式的,则与replace()替换字符串的效果是一样的,即这两者也支持字符串的操作;
 * 还有一点注意:执行了替换操作后,源字符串的内容是没有发生改变的.
 * 
 */
public class TestReplaceAll {
	public static void main(String[] args) {

		test1();
		System.out.println("---------test2-----------------");
		test2();
		System.out.println("---------test3-----------------");
		test3();
		System.out.println("---------test4-----------------");
		test4();

		System.out.println("---------test5-----------------");
		test5();

		System.out.println("---------test6-----------------");
		test6();

	}

	static void test1() {
		String s = "asdf'sdfasdf";
		System.out.println(s);
		s = s.replaceAll("\'", "\\\\&apos;");
		System.out.println(s);
	}

	static void test2() {
		String d = "as-defs-e-fgsd-g";
		System.out.println(d);
		System.out.println(d.replace("-", ","));
		System.out.println(d);
		System.out.println(d.replaceAll("-", ","));
		System.out.println(d);
	}

	static void test3() {
		String s = "sdf\\a\\aa";
		// 把s中的反斜杠\ 替换为\\
		System.out.println(s);

		// '\'在java中是一个转义字符，所以需要用两个代表一个。例如System.out.println(
		// "\\" )
		// ;只打印出一个"\"。但是'\'也是正则表达式中的转义字符（replaceAll
		// 的参数就是正则表达式），需要用两个代表一个。所以：\\\\被java转换成\\,\\又被正则表达式转换成\。

		System.out.println(s.replaceAll("\\\\", "\\\\\\\\"));
		System.out.println(s.replace("\\", "\\\\"));

		System.out.println(s.replaceAll("\\\\", "\\\\"));

		// 将字符串中的'/'替换成'\'的几种方式:
		String msgIn = "adkf/dfsd/ssaf/sss/ddd/";
		String msgOut1 = msgIn.replaceAll("/", "\\\\");
		String msgOut2 = msgIn.replace("/", "\\");
		String msgOut3 = msgIn.replace('/', '\\');
		System.out.println(msgOut1);
		System.out.println(msgOut2);
		System.out.println(msgOut3);
	}

	static void test4() {
		String src = new String("ab43a24c43d");

		System.out.println(src.replace("3", "f"));
		System.out.println(src.replace('3', 'f'));
		System.out.println(src.replaceAll("\\d", "f"));
		System.out.println(src.replaceAll("a", "f"));
		System.out.println(src.replaceFirst("\\d", "f"));
		System.out.println(src.replaceFirst("4", "h"));

		System.out.println(src.replace("43", "H"));
		System.out.println(src.replace('4', 'H'));
		System.out.println(src.replaceAll("43", "H"));
	}

	static void test5() {
		String s = "sdf\\\"a\\\"aa";
		System.out.println(s);

		// '\'在java中是一个转义字符，所以需要用两个代表一个。例如System.out.println(
		// "\\" )
		// ;只打印出一个"\"。但是'\'也是正则表达式中的转义字符（replaceAll
		// 的参数就是正则表达式），需要用两个代表一个。所以：\\\\被java转换成\\,\\又被正则表达式转换成\。

		System.out.println(s.replaceAll("\\\\\"", "\""));
	}

	static void test6() {
		String s = "sdf[aaa]";
		System.out.println(s);

		// '\'在java中是一个转义字符，所以需要用两个代表一个。例如System.out.println(
		// "\\" )
		// ;只打印出一个"\"。但是'\'也是正则表达式中的转义字符（replaceAll
		// 的参数就是正则表达式），需要用两个代表一个。所以：\\\\被java转换成\\,\\又被正则表达式转换成\。

		System.out.println(s.replaceAll("\\\\\"", "\""));
	}
}
