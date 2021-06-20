package cn.com.todo.test_quartz;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.StatefulJob;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * �ڶ�ʱ����Quartz�����Ҫ����һ��Job������ʵ��Job����StatefulJob����Job��StatefulJob��������ʲô�أ���
 * Job����ͨ�����񣬻���˵��״̬��������JobDetailִ��֮�󣬲����¼״̬
 * StatefulJob���̳���Job�������ڶ���ʱ�����@PersistJobDataAfterExecutionע�ͣ�
 * ��������״̬��������Scheduleִ����triger֮�󣬻Ὣʵ���˸ýӿڵ�����״̬��¼�����ݿ��У�����Ҫ����״̬�Ķ�ʱ����
 * 
 */

public class TestJob implements StatefulJob {// ��״̬��job

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("���Ƕ�ʱ���õ�");
	}

	public void task() {
		/*-------------------SimpleTrigger����----------------*/
		// ͨ��SchedulerFactory����ȡһ��������
		/*
		 * SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		 * Scheduler scheduler =null; //������ҵ���� JobDetail jobDetail = new
		 * JobDetail("jobDetail-s1","jobDetailGroup-s1", Test.class); //newһ��������
		 * SimpleTrigger simpleTrigger = new SimpleTrigger("simpleTrigger",
		 * "triggerGroup-s1"); //������ҵ����ʱ�� long ctime =
		 * System.currentTimeMillis(); simpleTrigger.setStartTime(new
		 * Date(ctime)); //������ҵִ�м��,�Ժ���Ϊ��λ
		 * simpleTrigger.setRepeatInterval(10000); //������ҵִ�д���
		 * simpleTrigger.setRepeatCount(10); //������ҵִ�����ȼ�Ĭ��Ϊ5
		 * //simpleTrigger.setPriority(10); //��ҵ�ʹ��������õ��������� try {
		 * scheduler=schedulerFactory.getScheduler();
		 * scheduler.scheduleJob(jobDetail, simpleTrigger); //����������
		 * scheduler.start(); } catch (SchedulerException e) {
		 * e.printStackTrace(); }
		 */

		/*-------------------CronTrigger����----------------*/
		// CronTrigger ֧�ֱ� SimpleTrigger ������ĵ��ȣ�����Ҳ���Ǻܸ��ӡ�
		// ���� cron ���ʽ��CronTrigger ֧�������������ظ�����������ǵ�һ��ʱ����
		// ���� ����� SimpleTrigger ������һ��Ľ���
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		JobDetail jobDetail = new JobDetail("jobDetail2", "jobDetailGroup2",
				TestJob.class);
		CronTrigger cronTrigger = new CronTrigger("cronTrigger",
				"triggerGroup2");
		try {
			CronExpression cexp = new CronExpression("0/1 * 16 * * ?");
			// ps:����CronExpression���ʽ�����ľ��庬�壬�������һƪ����
			cronTrigger.setCronExpression(cexp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestJob t = new TestJob();
		t.task();
	}
}
