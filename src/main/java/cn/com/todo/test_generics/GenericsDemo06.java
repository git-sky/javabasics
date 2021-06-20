package cn.com.todo.test_generics;

class Point<T> { // �˴��������д��ʶ���ţ�T��type�ļ��
	private T var; // var��������Tָ�����������ⲿָ��

	public T getVar() { // ����ֵ���������ⲿ����
		return var;
	}

	public void setVar(T var) { // ���õ�����Ҳ���ⲿ����
		this.var = var;
	}
};

public class GenericsDemo06 {
	public static void main(String args[]) {
		Point<String> p = new Point<String>(); // �����var����ΪString����
		p.setVar("it"); // �����ַ���
		System.out.println(p.getVar()); // ȡ���ַ���
		System.out.println(p.getVar().length()); // ȡ���ַ����ĳ���
	}
};
