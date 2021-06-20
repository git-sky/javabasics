package cn.com.todo.test_generics;

interface InfoIface<T> { // �ڽӿ��϶��巺��
	public T getVar(); // ������󷽷������󷽷��ķ���ֵ���Ƿ�������
}

class InfoImpl<T> implements InfoIface<T> { // ���巺�ͽӿڵ�����
	private T var; // ��������

	public InfoImpl(T var) { // ͨ�����췽��������������
		this.setVar(var);
	}

	public void setVar(T var) {
		this.var = var;
	}

	public T getVar() {
		return this.var;
	}
};

class InfoImpl2 implements InfoIface<String> { // ���巺�ͽӿڵ�����
	private String var; // ��������

	public InfoImpl2(String var) { // ͨ�����췽��������������
		this.setVar(var);
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getVar() {
		return this.var;
	}
};

public class GenericsDemo24 {
	public static void main(String arsg[]) {
		InfoIface<String> i = null; // �����ӿڶ���
		i = new InfoImpl<String>("��ķ"); // ͨ������ʵ��������
		System.out.println("���ݣ�" + i.getVar());

		InfoIface j = null; // �����ӿڶ���
		j = new InfoImpl2("���"); // ͨ������ʵ��������
		System.out.println("���ݣ�" + j.getVar());
	}
};
