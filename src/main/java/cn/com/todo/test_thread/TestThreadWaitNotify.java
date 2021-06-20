package cn.com.todo.test_thread;

/**
 * 
 * ע�⣺ ���ڶ����ϵ���wait()����ʱ��ִ�иô�����߳������������ڶ����ϵ����� Ȼ������notify()ʱ��������ζ����ʱ�̻߳����������
 * ����߳���Ȼ�����ͬ�����룬���߳����Ƴ�֮ǰ����������� ��ˣ�ֻҪ����notify()������ζ����ʱ������ÿ��á� wait()
 * ������synchronized �������ߴ�������档
 * 
 * [wait(),notify()/notityAll()��������ͨ����ķ���(Object������ʵ��),�������̶߳���ķ���]
 * ����[wait(),notify()/notityAll()����ֻ����ͬ�������е���]
 */
public class TestThreadWaitNotify {

	/**
	 * ������������߳������������
	 */
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		// ���������߳�
		b.start();

		// try {
		// Thread.sleep(1000);//Ϊ�������߳���ִ�С�
		// } catch (InterruptedException e1) {
		// e1.printStackTrace();
		// }

		// �߳�Aӵ��b�����ϵ������߳�Ϊ�˵���wait()��notify()���������̱߳������Ǹ���������ӵ����
		synchronized (b) {
			try {
				System.out.println("�ȴ�����b��ɼ��㡣����");
				// ��ǰ�߳�A�ȴ������ͷ�b�����ϵ�����
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("b���������ܺ��ǣ�" + b.total);
		}
	}
}

/**
 * ����1+2+3 ... +100�ĺ�
 * 
 */
class ThreadB extends Thread {
	int total;

	public void run() {
		try {
			Thread.sleep(1000);// Ϊ�������̵߳ȴ��������߳���ִ�С�
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		synchronized (this) {
			System.out.println("����b��ʼ���㡣����");
			for (int i = 0; i < 101; i++) {
				total += i;
			}
			// ����ɼ����ˣ������ڴ˶���������ϵȴ��ĵ����̣߳��ڱ������߳�A������
			notify();
		}
	}
}