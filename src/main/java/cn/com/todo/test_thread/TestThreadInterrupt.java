package cn.com.todo.test_thread;

/**
 * @author Rollen-Holt �̵߳��ж�
 * */
public class TestThreadInterrupt implements Runnable {
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("ִ��run����");
			try {
				Thread.sleep(2000);
				System.out.println("�߳��������");
			} catch (Exception e) {
				System.out.println("���߱����");
				//return; // ���ص�����ĵ��ô�
			}
			System.out.println("�߳�������ֹ");
		}
	}

	public static void main(String[] args) {
		TestThreadInterrupt he = new TestThreadInterrupt();
		Thread demo = new Thread(he, "�߳�");
		demo.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		demo.interrupt(); // 2s���ж��߳�
		System.out.println(demo.isInterrupted());
		
		Thread.interrupted();
		demo.isInterrupted();
		demo.interrupted();
		demo.interrupt();
	}
}