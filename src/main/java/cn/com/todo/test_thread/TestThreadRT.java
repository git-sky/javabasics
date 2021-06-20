package cn.com.todo.test_thread;

class Tson extends Thread {
	public int x = 0;

	public void run() {
		System.out.println(++x);
	}
}

class Rson implements Runnable {
	private int x = 0;

	public void run() {
		System.out.println(++x);
	}
}

public class TestThreadRT {
	public static void main(String[] args) throws Exception {

//10���̶߳��������10���߳�����ʱ��ӡ��10��1
//		for (int i = 0; i < 10; i++) {
//			Thread t = new Tson();
//			t.start();
//		}
		
		
//10���̶߳��������10���߳�����ʱ��ӡ��10��1		
//		for (int i = 0; i < 10; i++) {
//			Thread t = new Thread(new Rson());
//			t.start();
//		}
		
		
//10���̶߳��������10���߳�����ʱ��ӡ��1��10(����˳��ȷ��)�����ǰ������10���̳߳�Ϊͬһʵ��(Runnableʵ��)�Ķ���߳�		
//		Rson r = new Rson();
//		for (int i = 0; i < 10; i++) {
//			Thread t = new Thread(r);
//			t.start();
//		}
	
	}
}