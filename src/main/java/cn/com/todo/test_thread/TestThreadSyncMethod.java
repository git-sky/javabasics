package cn.com.todo.test_thread;

public class TestThreadSyncMethod {

	/**
	 * Java�̣߳��̵߳�ͬ��-ͬ������
	 * 
	 */
	public static void main(String[] args) {
		User u = new User("����", 100);
		MyThreadT t1 = new MyThreadT("�߳�A", u, 20);
		MyThreadT t2 = new MyThreadT("�߳�B", u, -60);
		MyThreadT t3 = new MyThreadT("�߳�C", u, -80);
		MyThreadT t4 = new MyThreadT("�߳�D", u, -30);
		MyThreadT t5 = new MyThreadT("�߳�E", u, 32);
		MyThreadT t6 = new MyThreadT("�߳�F", u, 21);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class MyThreadT extends Thread {
	private User u;
	private int y = 0;

	MyThreadT(String name, User u, int y) {
		super(name);
		this.u = u;
		this.y = y;
	}

	public void run() {
		u.oper(y);
	}
}

class User {
	private String code;
	private int cash;

	User(String code, int cash) {
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
	public synchronized void oper(int x) {
		try {
			Thread.sleep(10L);
			this.cash += x;
			System.out.println(Thread.currentThread().getName() + "���н��������ӡ�"
					+ x + "������ǰ�û��˻����Ϊ��" + cash);
			Thread.sleep(10L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "User{" + "code='" + code + '\'' + ", cash=" + cash + '}';
	}
}