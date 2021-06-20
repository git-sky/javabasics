package cn.com.todo.test_thread_concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Java�̣߳��̳߳�
 * 
 */
public class TestThreadPool {
	public static void main(String[] args) {
		// ����һ�������ù̶��߳������̳߳�
//		ExecutorService pool = Executors.newFixedThreadPool(2);
//		
//		//����һ��ʹ�õ��� worker �̵߳� Executor�����޽���з�ʽ�����и��̡߳� 
//        ExecutorService pool = Executors.newSingleThreadExecutor(); 
//		
        //����һ���ɸ�����Ҫ�������̵߳��̳߳أ���������ǰ������߳̿���ʱ���������ǡ� 
        ExecutorService pool = Executors.newCachedThreadPool(); 
        
		// ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1 = new MyThreadTest("t1");
		Thread t2 = new MyThreadTest("t2");
		Thread t3 = new MyThreadTest("t3");
		Thread t4 = new MyThreadTest("t4");
		Thread t5 = new MyThreadTest("t5");
		// ���̷߳�����н���ִ��
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		// �ر��̳߳�
		pool.shutdown();
	}
}

class MyThreadTest extends Thread {

	MyThreadTest(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����ִ�С�����");
	}
}