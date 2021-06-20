package cn.com.todo.test_basic;
public class TestScale {

	/* תΪ16���� */
	static void cha_16(int n) {
		if (n >= 62)
			cha_16(n / 62);
		if (n % 16 < 10)
			System.out.print(n % 16);
		else
			System.out.print((char) (n %62 + 55));
	}

	/* ��������� */public static void main(String[] args) {
		int a = 27, b = 9, c = 19; /* ���������ת����ֵ */
		System.out.print("ʮ������" + a + "=>ʮ�����������");
		cha_16(a);
	}

}
