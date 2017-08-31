package cn.com.sky.basics.array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 去掉字符串前后的特殊字符。
 */
public class TestStringTrim {

	@Test
	public void test() {
		String str = "a,";

		String[] s = str.split(",");

		System.out.println(s.length);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	@Test
	public void test2() {
		String str = " a ";

		System.out.println(str);

		String s = str.trim();
		System.out.println(s);

	}

	@Test
	public void test3() {
		String[] strs = { "1,2,5,", ",,,1,2,5,", ",,,,,,," };

		String regex = "^,*|,*$";

		//  需要处理多个字符串
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("");
		for (int i = 0; i < strs.length; i++) {
			System.out.println(matcher.reset(strs[i]).replaceAll(""));
		}

		// 只处理一个字符串
		String str = ",,,,1,2,3,,,,,";
		System.out.println(str.replaceAll(regex, ""));
	}

	@Test
	public void test4() {
		String s = ",,,12,34,,,3,,,";
//		s="1,";
		System.out.println(s);
		s = s.replaceAll("^,*|,*$", "");
		System.out.println(s);
		
		System.out.println(s.contains(","));
		System.out.println(s.equalsIgnoreCase("1"));

	}
}
