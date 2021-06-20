package cn.com.todo.test_thread_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java�̣߳���
 * 
 */
public class TestThreadNewLock {
	public static void main(String[] args) {
		// �����������ʵ��˻�
		MyCountCard myCount = new MyCountCard("95599200901215522", 10000);
		// ����һ��������
		Lock lock = new ReentrantLock();
		// ����һ���̳߳�
		ExecutorService pool = Executors.newCachedThreadPool();
		// ����һЩ���������û���һ�����ÿ�����Ĵ棬ȡ��ȡ�������ְ�
		MyUser u1 = new MyUser("����", myCount, -4000, lock);
		MyUser u2 = new MyUser("��������", myCount, 6000, lock);
		MyUser u3 = new MyUser("��������", myCount, -8000, lock);
		MyUser u4 = new MyUser("����", myCount, 800, lock);
		// ���̳߳���ִ�и����û��Ĳ���
		pool.execute(u1);
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u4);
		// �ر��̳߳�
		pool.shutdown();
	}
}

/**
 * ���ÿ����û�
 */
class MyUser implements Runnable {
	private String name; // �û���
	private MyCountCard myCount; // ��Ҫ�������˻�
	private int iocash; // �����Ľ���Ȼ������֮����
	private Lock myLock; // ִ�в��������������

	MyUser(String name, MyCountCard myCount, int iocash, Lock myLock) {
		this.name = name;
		this.myCount = myCount;
		this.iocash = iocash;
		this.myLock = myLock;
	}

	public void run() {
		// ��ȡ��
		myLock.lock();
		// ִ���ֽ�ҵ��
		System.out.println(name + "���ڲ���" + myCount + "�˻������Ϊ" + iocash
				+ "����ǰ���Ϊ" + myCount.getCash());
		myCount.setCash(myCount.getCash() + iocash);
		System.out.println(name + "����" + myCount + "�˻��ɹ������Ϊ" + iocash
				+ "����ǰ���Ϊ" + myCount.getCash());
		// �ͷ������������߳�û�л���ִ����
		myLock.unlock();
	}
}

/**
 * ���ÿ��˻���������͸֧
 */
class MyCountCard {
	private String oid; // �˺�
	private int cash; // �˻����

	MyCountCard(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "MyCountCard{" + "oid='" + oid + '\'' + ", cash=" + cash + '}';
	}
}