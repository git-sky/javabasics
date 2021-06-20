package cn.com.todo.test_thread;

class TestSynchronized extends Thread {
	public TestSynchronized(String name) {
		super(name);
	}

	public synchronized void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
		}
	}
}

public class TestThreadSynchronized {
	public static void main(String[] args) {
		TestSynchronized t1 = new TestSynchronized("t1");
		TestSynchronized t2 = new TestSynchronized("t2");
		t1.start();
		//t1.start();////�߳�ֻ������һ��,�ٴ������ᱬIllegalThreadStateException�쳣��
		//t2.start();//// ����t1��t2���������������������������߳̿�ͬʱ����run()������
		
	}
}