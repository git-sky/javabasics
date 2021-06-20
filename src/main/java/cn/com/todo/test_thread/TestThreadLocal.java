package cn.com.todo.test_thread;

public class TestThreadLocal {
	// �����������ഴ��ThreadLocal�ı���
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		// ���ǳ�ʼ������
		public Integer initialValue() {
			return 0;
		}
	};

	// ��һ�����к�
	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	private static class TestClient extends Thread {
		private TestThreadLocal sn;

		public TestClient(TestThreadLocal sn) {
			this.sn = sn;
		}

		// �̲߳������к�
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println("thread[" + Thread.currentThread().getName()
						+ "] sn[" + sn.getNextNum() + "]");
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestThreadLocal sn = new TestThreadLocal();
		// �����̲߳������Ե����к�
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
	}
}
