package cn.com.todo.test_basic;

/**
 * 
 * ��������ֳ�ʼ����ʽ�� 1.��̬��ʼ�� 2.��̬��ʼ�� 3.Ĭ�ϳ�ʼ��
 * 
 * @author zxp
 * 
 */
public class TestArrayInitial {

	public static void main(String[] args) {

		// 1.��̬��ʼ��
		// 1>�����������ʼ��
		int[] arrayName1;//������û�г�ʼ��
		
//		for (int i = 0; i < arrayName1.length; i++) {
//			System.out.println(arrayName1[i]);
//		}
		
		arrayName1 = new int[] { 1, 2, 3, 4 };//��ʼ��

		//���
		for (int i = 0; i < arrayName1.length; i++) {
			System.out.println(arrayName1[i]);
		}
		
		//2>������ͬʱ�����г�ʼ��
		int[] arrayName2 = new int[] { 1, 2, 3, 4 };

		// ������ͬʱ�����г�ʼ��
		int[] arrayNameSecond = { 4, 5, 6, 7 };
		
		//int[] a=new int[5]{1,2,3,4,5};   //����,����ṩ�������ʼ�����������ܶ���ά���ʽ 
		
		//int[] arrayNameSecond2;
		//arrayNameSecond2= { 4, 5, 6, 7 }; //����,���鳣��ֻ���ڳ�ʼ��������ʹ��


		for (int i = 0; i < arrayName2.length; i++) {
			System.out.println(arrayName2[i]);
		}

		for (int i = 0; i < arrayNameSecond.length; i++) {
			System.out.println(arrayNameSecond[i]);
		}

		// 2.��̬��ʼ��
		int a[];
		a = new int[3];
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
		a[0] = 10;
		a[1] = 11;
		a[2] = 12;

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		// 3.Ĭ�ϳ�ʼ��

		// ����һ������
		int[] arrayNameDong;
		arrayNameDong = new int[5];

		int[] arrayNameDongSecond = new int[9];

		for (int i = 0; i < arrayNameDong.length; i++) {
			System.out.println(arrayNameDong[i]);
		}

		for (int i = 0; i < arrayNameDongSecond.length; i++) {
			System.out.println(arrayNameDongSecond[i]);
		}

	}
}
