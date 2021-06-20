package cn.com.todo.test_basic;

public class TestUpperCase {

	public static void main(String[] args) {

		String a="aa�õ�BcD�й�";
		System.out.println("ssssssss="+a.toUpperCase());
		
		String p_="��\\t��'�й���',\"��\\��\"";
		System.out.println(p_);
		
		
		p_ = p_.replaceAll("\\\\", "\\\\\\\\");//ת�巴б�ܡ�\��
		p_ = p_.replaceAll("'", "\\\\'");//ת�嵥����
		p_ = p_.replaceAll("\"", "\\\\\"");//ת��˫����

		System.out.println(p_);
	}

}
