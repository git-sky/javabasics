package cn.com.todo.test_initialclass;

/**
 * ��ĳ�ʼ��˳��
 * @author zxp
 *
 */
public class PrintClass {
	public static void main(String[] args) {
		new B();
	}

	PrintClass(String var) {
		System.out.println(var);
	}
}

class A {
	static PrintClass pClassA1 = new PrintClass("A. ��̬��Ա�ĳ�ʼ��1");
	static {
		System.out.println("A. ��̬��ʼ����1");
	}
	static {
		System.out.println("A. ��̬��ʼ����2");
	}
	static PrintClass pClassA2 = new PrintClass("A. ��̬��Ա�ĳ�ʼ��2");

	{
		System.out.println("A. ʵ����ʼ����1");
	}
	PrintClass pClassA = new PrintClass("A. ʵ����Ա�ĳ�ʼ��");
	{
		System.out.println("A. ʵ����ʼ����2");
	}

	public int Avar;

	public A() {
		System.out.println("A. ���췽��");
		doSomething();
	}

	private void doSomething() {
		// public void doSomething() {
		Avar = 1111;
		System.out.println("Avar=" + Avar);
	}
}

// class B extends A
class B extends A {
	public static void main(String[] args) {
		new B();
	}

	public int Bvar = 2222;

	{
		System.out.println("B. ʵ����ʼ����1");
	}
	{
		System.out.println("B. ʵ����ʼ����2");
	}
	PrintClass pClassB = new PrintClass("B. ʵ����Ա�ĳ�ʼ��");

	static {
		System.out.println("B. ��̬��ʼ����1");
	}
	static PrintClass pClassB1 = new PrintClass("B. ��̬��Ա�ĳ�ʼ��1");
	static PrintClass pClassB2 = new PrintClass("B. ��̬��Ա�ĳ�ʼ��2");
	static {
		System.out.println("B. ��̬��ʼ����2");
	}

	public B() {
		System.out.println("B. ���췽��");
		doSomething();
	}

	public void doSomething() {
		System.out.println("Bvar=" + Bvar);
	}
}

// ���Կ������н��Ϊ��
// A. ��̬��Ա�ĳ�ʼ��1
// A. ��̬��ʼ����1
// A. ��̬��ʼ����2
// A. ��̬��Ա�ĳ�ʼ��2
// B. ��̬��ʼ����1
// B. ��̬��Ա�ĳ�ʼ��1
// B. ��̬��Ա�ĳ�ʼ��2
// B. ��̬��ʼ����2
// A. ʵ����ʼ����1
// A. ʵ����Ա�ĳ�ʼ��
// A. ʵ����ʼ����2
// A. ���췽��
// Avar=1111
// B. ʵ����ʼ����1
// B. ʵ����ʼ����2
// B. ʵ����Ա�ĳ�ʼ��
// B. ���췽��
// Bvar=2222
// 

// �ɴ˿�֪���½�һjava��������main������new B()��ʱ�������ڲ���ʼ��˳��Ϊ��
// 1�� ���ྲ̬��Ա�;�̬��ʼ���� �����ڴ����г��ֵ�˳������ִ��
// 2�� ���ྲ̬��Ա�;�̬��ʼ���� �����ڴ����г��ֵ�˳������ִ��
// 3�� ����ʵ����Ա��ʵ����ʼ���� �����ڴ����г��ֵ�˳������ִ��
// 4�� ���๹�췽��
// 5�� ����ʵ����Ա��ʵ����ʼ���� �����ڴ����г��ֵ�˳������ִ��
// 6�� ���๹�췽��
