package cn.com.todo.test_random;

import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {

		TestRandom tr = new TestRandom();
		// tr.testMath();
		tr.testRandom();
		// tr.testRamdom2();

	}

	void testMath() {

		for (int i = 0; i < 1000; i++) {
			double r = Math.random();// �������������0-1֮���һ��double
			System.out.println(r);
		}
	}

	// �������ӣ�
	// ���ַ�ʽ���᷵����������֣�ÿ�����н����һ��
	void testRandom() {
		Random r = new Random();
		Random r2 = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt());
			System.out.println(r2.nextInt());
		}
	}

	// �����ӣ�
	// ���ַ�ʽ�����۳������ж��ٴΣ����ؽ������һ����
	void testRamdom2() {
		Random r = new Random(10);
		Random r2 = new Random(10);
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt());
			System.out.println(r2.nextInt());
		}

	}
}
