package cn.com.todo.test_thread;

/**
 * @author Rollen-Holt ��̨�߳�
 * */
public class hello implements Runnable {
	int i=0;
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "������"+i++);
        }
    }
 
    public static void main(String[] args) {
        hello he = new hello();
        Thread demo = new Thread(he, "�߳�");
        demo.setDaemon(true);
        demo.start();
    }
}