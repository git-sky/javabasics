package cn.com.todo.test_quartz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartzJob2 {

	public static void main(String[] args) {
		// new TestQuartz2().test1();
		new TestQuartzJob2().test2();
		// new TestQuartz2().test3();
	}

	public void test1() {
		// ͨ��SchedulerFactory����ȡһ��������
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();

			// ������ҵ����
			JobDetail jobDetail = new JobDetail("jobDetail-s1",
					"jobDetailGroup-s1", QuartzJob2.class);

			// newһ��������
			SimpleTrigger simpleTrigger = new SimpleTrigger("simpleTrigger",
					"triggerGroup-s1");

			// ������ҵ����ʱ��

			long ctime = System.currentTimeMillis();
			simpleTrigger.setStartTime(new Date(ctime));

			// ������ҵִ�м��
			simpleTrigger.setRepeatInterval(1000);

			// ������ҵִ�д���
			simpleTrigger.setRepeatCount(10);

			// ������ҵִ�����ȼ�Ĭ��Ϊ5
			// simpleTrigger.setPriority(10);

			// ��ҵ�ʹ��������õ���������
			scheduler.scheduleJob(jobDetail, simpleTrigger);

			// ����������
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void test2() {

		try {
			SchedulerFactory schedFact = new StdSchedulerFactory();
			Scheduler sched = schedFact.getScheduler();
			sched.start();
			JobDetail jobDetail = new JobDetail(" Income Report ",
					" Report Generation ", QuartzJob2.class);
			// jobDetail.getJobDataMap().put(" type ", " FULL ");
			CronTrigger trigger = new CronTrigger(" Income Report ",
					" Report Generation ");

			trigger.setCronExpression("0/1 * 16 * * ?");
			sched.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test3() {
		// ͨ��SchedulerFactory����ȡһ��������
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();
			// ������ҵ����
			JobDetail jobDetail = new JobDetail("jobDetail-s1",
					"jobDetailGroup-s1", QuartzJob2.class);
			// newһ��������
			CronTrigger cronTrigger = new CronTrigger("trigger", "group",
					"0/1 * 16 * * ?");
			// ��ҵ�ʹ��������õ���������
			scheduler.scheduleJob(jobDetail, cronTrigger);
			// ����������
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}