package cn.com.todo.test_netty;

/**
 * Netty ����֮hello word��client���
 * 
 * @author Ransom
 * 
 */
public class HelloWordMain {
	public static void main(String[] args) {
		ClientThread r = new ClientThread();
		Thread t = new Thread(r);
		t.setName("client thread");
		t.start();

		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			r.sendMsg();
		}

	}
}
