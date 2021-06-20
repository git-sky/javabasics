package cn.com.todo.test_thread_concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Java�̣߳�������-��������
 * 
 */
public class TestThreadBlockingQueue {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue bqueue = new ArrayBlockingQueue(20);
		for (int i = 0; i < 30; i++) {
			// ��ָ��Ԫ����ӵ��˶����У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ����
			bqueue.put(i);
			System.out.println("�����������������Ԫ��:" + i);
		}
		System.out.println("���򵽴����н���......");
	}
}