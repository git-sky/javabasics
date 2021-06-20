package cn.com.todo.test_thread;

public class TestThreadSyncBlock {

	/**
	 * Java�̣߳��̵߳�ͬ��-ͬ�������
	 * 
	 */
	public static void main(String[] args) {
		UserB u = new UserB("����", 100);
		MyThreadB t1 = new MyThreadB("�߳�A", u, 20);
		MyThreadB t2 = new MyThreadB("�߳�B", u, -60);
		MyThreadB t3 = new MyThreadB("�߳�C", u, -80);
		MyThreadB t4 = new MyThreadB("�߳�D", u, -30);
		MyThreadB t5 = new MyThreadB("�߳�E", u, 32);
		MyThreadB t6 = new MyThreadB("�߳�F", u, 21);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class MyThreadB extends Thread {
	private UserB u;
	private int y = 0;

	MyThreadB(String name, UserB u, int y) {
		super(name);
		this.u = u;
		this.y = y;
	}

	public void run() {
		u.oper(y);
	}
}

class UserB {
	private String code;
	private int cash;

	UserB(String code, int cash) {
		this.code = code;
		this.cash = cash;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ҵ�񷽷�
	 * 
	 * @param x
	 *            ���x��Ԫ
	 */
	public void oper(int x) {
		try {
			Thread.sleep(10L);
			synchronized (this) {
				this.cash += x;
				System.out.println(Thread.currentThread().getName()
						+ "���н��������ӡ�" + x + "������ǰ�û��˻����Ϊ��" + cash);
			}
			Thread.sleep(10L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "UserB{" + "code='" + code + '\'' + ", cash=" + cash + '}';
	}
}