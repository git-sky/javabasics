package cn.com.sky.tools.test_quartz;

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
		// 通过SchedulerFactory来获取一个调度器
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();

			// 引进作业程序
			JobDetail jobDetail = new JobDetail("jobDetail-s1",
					"jobDetailGroup-s1", QuartzJob2.class);

			// new一个触发器
			SimpleTrigger simpleTrigger = new SimpleTrigger("simpleTrigger",
					"triggerGroup-s1");

			// 设置作业启动时间

			long ctime = System.currentTimeMillis();
			simpleTrigger.setStartTime(new Date(ctime));

			// 设置作业执行间隔
			simpleTrigger.setRepeatInterval(1000);

			// 设置作业执行次数
			simpleTrigger.setRepeatCount(10);

			// 设置作业执行优先级默认为5
			// simpleTrigger.setPriority(10);

			// 作业和触发器设置到调度器中
			scheduler.scheduleJob(jobDetail, simpleTrigger);

			// 启动调度器
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
		// 通过SchedulerFactory来获取一个调度器
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();
			// 引进作业程序
			JobDetail jobDetail = new JobDetail("jobDetail-s1",
					"jobDetailGroup-s1", QuartzJob2.class);
			// new一个触发器
			CronTrigger cronTrigger = new CronTrigger("trigger", "group",
					"0/1 * 16 * * ?");
			// 作业和触发器设置到调度器中
			scheduler.scheduleJob(jobDetail, cronTrigger);
			// 启动调度器
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}