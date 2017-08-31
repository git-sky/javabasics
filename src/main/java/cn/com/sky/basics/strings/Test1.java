package cn.com.sky.basics.strings;

public class Test1 {

	public static void main(String[] args) {

		String loginName = " a中 国            b ";
		System.out.println(loginName.trim().length());

		loginName = loginName.trim();

		System.out.println(loginName);

		if (loginName.length() > 5) {
			String begin = loginName.substring(0, 2);
			String end = loginName.substring(loginName.length() - 2, loginName.length());

			loginName = begin + "*" + end;
		}

		System.out.println(loginName);

	}

}
