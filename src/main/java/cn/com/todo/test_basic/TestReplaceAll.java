package cn.com.todo.test_basic;

/**
 * replace��replaceAll��JAVA�г��õ��滻�ַ��ķ���,���ǵ�������:
 * 
 * 1)replace�Ĳ�����char��CharSequence,������֧���ַ����滻,Ҳ֧���ַ������滻(CharSequence���ַ������е���˼,
 * ˵����Ҳ�����ַ���); 2)replaceAll�Ĳ�����regex,�����ڹ�����ʽ���滻,����,����ͨ��replaceAll("\\d","*")
 * ��һ���ַ������е������ַ��������Ǻ�;
 * ��ͬ���Ƕ���ȫ���滻,����Դ�ַ����е�ĳһ�ַ����ַ���ȫ������ָ�����ַ����ַ���,���ֻ���滻��һ�γ��ֵ�,����ʹ��
 * replaceFirst(),�������Ҳ�ǻ��ڹ�����ʽ���滻,����replaceAll()��ͬ����,ֻ�滻��һ�γ��ֵ��ַ���;
 * ����,���replaceAll
 * ()��replaceFirst()���õĲ����ݲ��ǻ��ڹ�����ʽ��,����replace()�滻�ַ�����Ч����һ����,��������Ҳ֧���ַ����Ĳ���;
 * ����һ��ע��:ִ�����滻������,Դ�ַ�����������û�з����ı��.
 * 
 * @author zxp
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
		// ��s�еķ�б��\ �滻Ϊ\\
		System.out.println(s);

		// '\'��java����һ��ת���ַ���������Ҫ����������һ��������System.out.println(
		// "\\" )
		// ;ֻ��ӡ��һ��"\"������'\'Ҳ��������ʽ�е�ת���ַ���replaceAll
		// �Ĳ�������������ʽ������Ҫ����������һ�������ԣ�\\\\��javaת����\\,\\�ֱ�������ʽת����\��

		System.out.println(s.replaceAll("\\\\", "\\\\\\\\"));
		System.out.println(s.replace("\\", "\\\\"));

		// ���ַ����е�'/'�滻��'\'�ļ��ַ�ʽ:
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
}
