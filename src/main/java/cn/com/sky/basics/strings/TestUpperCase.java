package cn.com.sky.basics.strings;

public class TestUpperCase {

	public static void main(String[] args) {

		String a="aa得到BcD中国";
		System.out.println("ssssssss="+a.toUpperCase());
		
		String p_="你\\t好'中国人',\"呵\\呵\"";
		System.out.println(p_);
		
		
		p_ = p_.replaceAll("\\\\", "\\\\\\\\");//转义反斜杠“\”
		p_ = p_.replaceAll("'", "\\\\'");//转义单引号
		p_ = p_.replaceAll("\"", "\\\\\"");//转义双引号

		System.out.println(p_);
	}

}
