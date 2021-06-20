package cn.com.todo.test_pinyin4j;

/**
 * ���ݺ��ֵõ���Ӧ��ƴ��
 * @author zxp
 *
 */
public class MyPinYin {
	public static void main(String[] args) {
		Hanyu hanyu = new Hanyu();
		// ��Ӣ�Ļ�ϵ�һ������
		String str = "�й�����";
		String strPinyin = hanyu.getStringPinYin(str);
		System.out.println(strPinyin);
	}
}
