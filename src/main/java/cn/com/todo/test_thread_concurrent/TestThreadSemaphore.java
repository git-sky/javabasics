package cn.com.todo.test_thread_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Java�̣߳�������-�ź���
 * 
 */
public class TestThreadSemaphore {
	public static void main(String[] args) {
		MyPool myPool = new MyPool(20);
		// �����̳߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		MyThread t1 = new MyThread("����A", myPool, 3);
		MyThread t2 = new MyThread("����B", myPool, 12);
		MyThread t3 = new MyThread("����C", myPool, 7);
		// ���̳߳���ִ������
		threadPool.execute(t1);
		threadPool.execute(t2);
		threadPool.execute(t3);
		// �رճ�
		threadPool.shutdown();
	}
}

/**
 * һ����
 */
class MyPool {
	private Semaphore sp; // ����ص��ź���

	/**
	 * �صĴ�С�������С�ᴫ�ݸ��ź���
	 * 
	 * @param size
	 *            �صĴ�С
	 */
	MyPool(int size) {
		this.sp = new Semaphore(size);
	}

	public Semaphore getSp() {
		return sp;
	}

	public void setSp(Semaphore sp) {
		this.sp = sp;
	}
}

class MyThread extends Thread {
	private String threadname; // �̵߳�����
	private MyPool pool; // �Զ����
	private int x; // �����ź����Ĵ�С

	MyThread(String threadname, MyPool pool, int x) {
		this.threadname = threadname;
		this.pool = pool;
		this.x = x;
	}

	public void run() {
		try {
			// �Ӵ��ź�����ȡ������Ŀ�����
			pool.getSp().acquire(x);
			// todo��Ҳ����������������ӵ�ҵ��
			System.out.println(Thread.currentThread().getName()+threadname + "�ɹ���ȡ��" + x + "����ɣ�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// �ͷŸ�����Ŀ����ɣ����䷵�ص��ź�����
			pool.getSp().release(x);
			System.out.println(Thread.currentThread().getName()+threadname + "�ͷ���" + x + "����ɣ�");
		}
	}
}