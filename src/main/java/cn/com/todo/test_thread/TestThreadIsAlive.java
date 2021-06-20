package cn.com.todo.test_thread;

/**
 * @author Rollen-Holt �ж��߳��Ƿ�����
 * */
public class TestThreadIsAlive implements Runnable {
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		TestThreadIsAlive he = new TestThreadIsAlive();
		Thread demo = new Thread(he);
		System.out.println("�߳�����֮ǰ---��" + demo.isAlive());
		demo.start();
		System.out.println("�߳�����֮��---��" + demo.isAlive());
	}
}