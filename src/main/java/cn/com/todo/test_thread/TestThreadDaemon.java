package cn.com.todo.test_thread;

/**
 * 
 * ��ִ�н�����Կ����� ǰ̨�߳��Ǳ�ִ֤����ϵģ���̨�̻߳�û��ִ����Ͼ��˳��ˡ�
 * 
 * ʵ���ϣ�JRE�жϳ����Ƿ�ִ�н����ı�׼�����е�ǰִ̨�߳�������ˣ������ܺ�̨�̵߳�״̬����ˣ���ʹ�ú�̨�߳�ʱ��һ��Ҫע��������⡣
 * 
 */
public class TestThreadDaemon {

	/**
	 * Java�̣߳��̵߳ĵ���-�ػ��߳�
	 */
	public static void main(String[] args) {
		Thread t1 = new MyCommon();
		Thread t2 = new Thread(new MyDaemon());
		t2.setDaemon(true); // ����Ϊ�ػ��߳�

		t2.start();
		t1.start();
	}
}

class MyCommon extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("�߳�1��" + i + "��ִ�У�");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyDaemon implements Runnable {
	public void run() {
		for (long i = 0; i < 9999999L; i++) {
			System.out.println("��̨�̵߳�" + i + "��ִ�У�");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}