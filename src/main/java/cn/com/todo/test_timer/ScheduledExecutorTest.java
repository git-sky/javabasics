package cn.com.todo.test_timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ���� Timer ��ȱ�ݣ�Java 5 �Ƴ��˻����̳߳���Ƶ�
 * ScheduledExecutor�������˼���ǣ�ÿһ�������ȵ����񶼻����̳߳���һ���߳�ȥִ��
 * ����������ǲ���ִ�еģ��໥֮�䲻���ܵ����š���Ҫע����ǣ�ֻ�е������ִ��ʱ�䵽��ʱ��ScheduedExecutor �Ż���������һ���̣߳�����ʱ��
 * ScheduledExecutor ��������ѯ�����״̬��
 * 
 */

public class ScheduledExecutorTest implements Runnable {
	private String jobName = "";

	public ScheduledExecutorTest(String jobName) {
		super();
		this.jobName = jobName;
	}

	@Override
	public void run() {
		System.out.println("execute " + jobName);
	}

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

		long initialDelay1 = 1;
		long period1 = 1;
		// �����ڿ�ʼ1����֮��ÿ��1����ִ��һ��job1
		service.scheduleAtFixedRate(new ScheduledExecutorTest("job1"),
				initialDelay1, period1, TimeUnit.SECONDS);

		long initialDelay2 = 2;
		long delay2 = 2;
		// �����ڿ�ʼ2����֮��ÿ��2����ִ��һ��job2
		service.scheduleWithFixedDelay(new ScheduledExecutorTest("job2"),
				initialDelay2, delay2, TimeUnit.SECONDS);
	}
}