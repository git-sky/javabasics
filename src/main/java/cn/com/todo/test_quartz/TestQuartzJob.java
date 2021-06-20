package cn.com.todo.test_quartz;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;

public class TestQuartzJob {
	private static Scheduler sched;

	public static void run() throws Exception {
		// ����LzstoneTimeTask�Ķ�ʱ����
		JobDetail jobDetail = new JobDetail("lzstoneJob",
				Scheduler.DEFAULT_GROUP, QuartzJob.class);
		// Ŀ�� ��������ƻ�
		CronTrigger trigger = new CronTrigger("lzstoneTrigger", "lzstone",
				"0/1 * 16 * * ?");
		sched = new org.quartz.impl.StdSchedulerFactory().getScheduler();
		sched.scheduleJob(jobDetail, trigger);
		sched.start();
	}

	// ֹͣ
	public static void stop() throws Exception {
		sched.shutdown();
	}

	public static void main(String[] args) throws Exception {
		TestQuartzJob.run();
	}
}
