package cn.com.todo.test_generics;

//	����Ҳ��generics�����ͷַ��ͷ����ͷ����࣬���ֶ��巽ʽ�����ͻ����Ͻ��½��˵����
//
//	�ȿ���ʲô�з��ͷ����ͷ����࣬һ�������ϵ�һ�����ͣ����˾����Ѿ����ĺ�����ˣ�
//
//	2�����ǽ�Dao�����д�ɷ��͵���ʽ��������д���� 
//	��һ�� 

class TestGenerics {

	public <T> void add(T t) {
		// ��ѯʵ��Ĵ���
	}

	public <T, ID> T get(ID id) {
		// .����ʵ��Ĵ���
		return null;
	}

}

// ����һ�����ڷ����Ĳ������߷����ķ���ֵ�������д��������Ҫʹ������Ч�������ڷ����ķ�������ǰ����ǿ�Ʒ���ת�������У�add(T
// t)�Ĳ������˷��ͣ����ķ���ֵ��void�ͣ�����void ǰ��ǿ������ת����������<T>��ǿ��ת���ɷ��͵���ʽ�������Ͳ��ᱨ���ˡ���T get(ID
// id)���������Ĳ����ͷ������Ͷ����˷��ͣ���Ҫ�ڷ�������Tǰǿ��ת������<T,ID>��

// ���������Ҳ��д��������ʽ��

class TestGenerics2<T, ID> {

	public void add(T t) {
		// ..����ʵ��Ĵ���
	}

	public T get(ID id) {
		// .��ѯʵ��Ĵ���
		return null;
	}

}
// ������ʽ���ǰѷ����������������ˣ��Ͳ���ÿ��������дǿ������ת����
//
// ��ʵ����Ҫ�����ַ�������������ְɣ����͸�Java��̴�������෽�㣬�ú����ã���ﵽ�°빦����Ч����

