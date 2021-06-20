package cn.com.todo.test_thread;

public class TestThreadJoin {

	public static void main(String[] args) {
		System.out.println("main...............��ʼ");
		Thread t1 = new MyThread("t1");
		Thread t2 = new MyThread("t2");
		t1.start();
		t2.start();
		try {
			t1.join();//main�ȴ�t1ִ����ɣ�����ִ�С�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main...............����");
		
	}
}

class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + ": i=" + i);
		}
	}

}
