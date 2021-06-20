package cn.com.todo.test_generics;

/**
 * 
 * 
 * �Ͻ���extends�ؼ�����������ʾ�����������Ϳ�������ָ�������ͣ������Ǵ����͵����ࡣ
 * �½���super������������ʾ�����������Ϳ�������ָ�������ͣ������Ǵ����͵ĸ����ͣ�ֱ��Object��
 * 
 */

class Info<T> {
	private T var; // ���巺�ͱ���

	public void setVar(T var) {
		this.var = var;
	}

	public T getVar() {
		return this.var;
	}

	public String toString() { // ֱ�Ӵ�ӡ
		return this.var.toString();
	}
};

public class GenericsDemo14 {
	public static void main(String args[]) {

		// wildcard();// ͨ���
		// son();//����
		father();// ����
	}

	static void wildcard() {
		Info<String> i = new Info<String>(); // ʹ��StringΪ��������
		i.setVar("it"); // ��������
		fun(i);

		Info<Integer> t = new Info<Integer>(); // ʹ��IntegerΪ��������
		t.setVar(8); // ��������
		fun(t);
	}

	public static void fun(Info<?> temp) { // ͨ��������Խ�������ķ��Ͷ���
		System.out.println("���ݣ�" + temp);
	}

	static void son() {
		Info<Integer> i1 = new Info<Integer>(); // ����Integer�ķ��Ͷ���
		Info<Float> i2 = new Info<Float>(); // ����Float�ķ��Ͷ���
		i1.setVar(30); // �����������Զ�װ��
		i2.setVar(30.1f); // ����С�����Զ�װ��
		fun2(i1);
		fun2(i2);
	}

	public static void fun2(Info<? extends Number> temp) { // ֻ�ܽ���Number����Number������
		System.out.print(temp + ";");
	}

	static void father() {
		Info<String> i1 = new Info<String>(); // ����String�ķ��Ͷ���
		Info<Object> i2 = new Info<Object>(); // ����Object�ķ��Ͷ���
		i1.setVar("hello");
		i2.setVar(new Object());
		fun3(i1);
		fun3(i2);
	}

	public static void fun3(Info<? super String> temp) { // ֻ�ܽ���String��Object���͵ķ���
		System.out.print(temp + ";");
	}

};