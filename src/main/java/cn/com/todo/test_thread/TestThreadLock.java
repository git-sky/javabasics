package cn.com.todo.test_thread;

/**
 * �߳�A�� ѭ��50�κ�ȴ��������������߳�Bִ�С�
 */
class ThreadAA extends Thread {
	// �߳�ͬ���Ĺ���������
	Object oa = null;

	ThreadAA(Object o) {
		this.oa = o;
	}

	// �߳�Aִ���߼�
	public void run() {
		// �߳�ͬ��������Ҫ���빫�����ݵ���
		synchronized (oa) {
			System.out.println("ThreadAA is running......");
			for (int i = 0; i < 100; i++) {
				System.out.println("   ThreadAA value is " + i);
				if (i == 50) {
					try {
						// ��ǰ�̵߳ȴ�
						oa.wait();//Thread.currentThread().wait();����
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}// if(i==50)
			}// for(int i)
		}
	}
}

/**
 * �߳�B���ȴ��߳�A��������Ȼ��������ִ�У���ɺ����߳�A
 */
class ThreadBB extends Thread {
	// �߳�ͬ���Ĺ���������
	Object ob = null;

	ThreadBB(Object o) {
		this.ob = o;
	}

	// �߳�Bִ���߼�
	public void run() {
		// �߳�ͬ��������Ҫ���빫�����ݵ���
		synchronized (ob) {
			System.out.println("ThreadBB is running......");
			for (int i = 0; i < 50; i++) {
				System.out.println("   ThreadBB value is " + i);
			}
			// ���ѵȴ����߳�
			ob.notify();//notify();����
		}
	}
}

// ����
public class TestThreadLock {
	public static void main(String[] args) {
		Object lock = new Object(); // ����������
		ThreadAA threada = new ThreadAA(lock);
		ThreadBB threadb = new ThreadBB(lock);
		threada.start(); // �߳�Aִ��
		threadb.start(); // �߳�Bִ��
	}
}
