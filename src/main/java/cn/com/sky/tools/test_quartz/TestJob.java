package cn.com.sky.tools.test_quartz;

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
 * 在定时任务Quartz中如果要创建一个Job，可以实现Job或者StatefulJob，那Job和StatefulJob的区别是什么呢？？
 * Job：普通的任务，或者说无状态的任务，在JobDetail执行之后，不会记录状态
 * StatefulJob：继承自Job，由于在定义时添加了@PersistJobDataAfterExecution注释，
 * 所以是有状态的任务，在Schedule执行完triger之后，会将实现了该接口的任务状态记录到数据库中，所以要是有状态的定时任务
 * 
 */

public class TestJob implements StatefulJob {// 有状态的job

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("我是定时调用的");
	}

	public void task() {
		/*-------------------SimpleTrigger调度----------------*/
		// 通过SchedulerFactory来获取一个调度器
		/*
		 * SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		 * Scheduler scheduler =null; //引进作业程序 JobDetail jobDetail = new
		 * JobDetail("jobDetail-s1","jobDetailGroup-s1", Test.class); //new一个触发器
		 * SimpleTrigger simpleTrigger = new SimpleTrigger("simpleTrigger",
		 * "triggerGroup-s1"); //设置作业启动时间 long ctime =
		 * System.currentTimeMillis(); simpleTrigger.setStartTime(new
		 * Date(ctime)); //设置作业执行间隔,以毫秒为单位
		 * simpleTrigger.setRepeatInterval(10000); //设置作业执行次数
		 * simpleTrigger.setRepeatCount(10); //设置作业执行优先级默认为5
		 * //simpleTrigger.setPriority(10); //作业和触发器设置到调度器中 try {
		 * scheduler=schedulerFactory.getScheduler();
		 * scheduler.scheduleJob(jobDetail, simpleTrigger); //启动调度器
		 * scheduler.start(); } catch (SchedulerException e) {
		 * e.printStackTrace(); }
		 */

		/*-------------------CronTrigger调度----------------*/
		// CronTrigger 支持比 SimpleTrigger 更具体的调度，而且也不是很复杂。
		// 基于 cron 表达式，CronTrigger 支持类似日历的重复间隔，而不是单一的时间间隔
		// —— 这相对 SimpleTrigger 而言是一大改进。
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		JobDetail jobDetail = new JobDetail("jobDetail2", "jobDetailGroup2",
				TestJob.class);
		CronTrigger cronTrigger = new CronTrigger("cronTrigger",
				"triggerGroup2");
		try {
			CronExpression cexp = new CronExpression("0/1 * 16 * * ?");
			// ps:关于CronExpression表达式所表达的具体含义，请参阅下一篇文章
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
