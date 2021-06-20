package cn.com.todo.test_thread;

class TestThreadShare implements Runnable {

	public synchronized void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + "i=" + i);
		}
	}
}

public class TestThreadRunnable {

	public static void main(String[] args) {

		// ÿ�ζ�����ͬһ��TestThreadShare����������Thread����ģ����Բ���������Thread������ͬһ��������̣߳�����ʵ��run()������ͬ����
		TestThreadShare my = new TestThreadShare();
		new Thread(my, "1�Ŵ���").start();
		new Thread(my, "2�Ŵ���").start();
		new Thread(my, "3�Ŵ���").start();

//		// ÿ�ζ�����һ���µ�TestThreadShare����������Thread����ģ����Բ���������Thread�����ǲ�ͬ������̣߳���������Thread���󶼿�ͬʱ����run()������
//		 TestThreadShare my1 = new TestThreadShare();
//		 TestThreadShare my2 = new TestThreadShare();
//		 TestThreadShare my3 = new TestThreadShare();
//		 new Thread(my1, "1�Ŵ���").start();
//		 new Thread(my2, "2�Ŵ���").start();
//		 new Thread(my3, "3�Ŵ���").start();

	}
}