package cn.com.todo.test_thread_concurrent;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Java�̣߳�������-����ջ
 * 
 * �ӽ�����Կ���������û��������������ס�ˣ�ԭ����ջ�Ѿ����ˣ�����׷��Ԫ�صĲ������������ˡ�
 * 
 */
public class TestThreadBlockingDeque {
	public static void main(String[] args) throws InterruptedException {
		BlockingDeque bDeque = new LinkedBlockingDeque(20);
		for (int i = 0; i < 30; i++) {
			// ��ָ��Ԫ����ӵ�������ջ�У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ����
			bDeque.putFirst(i);
			System.out.println("������ջ�������Ԫ��:" + i);
		}
		System.out.println("���򵽴����н����������˳�----");
	}
}