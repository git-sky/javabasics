package cn.com.sky.tools.test_quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * quartz定时器测试
 */

public class TestQuartzJob3 {
	public static void main(String[] args) {
		// 1、创建JobDetial对象
		JobDetail jobDetail = new JobDetail();
		// 设置工作项
		jobDetail.setJobClass(QuartzJob3.class);
		jobDetail.setName("QuartzJob3_1");
		jobDetail.setGroup("JobGroup_1");

		// 2、创建Trigger对象
		SimpleTrigger strigger = new SimpleTrigger();
		strigger.setName("Trigger_1");
		strigger.setGroup("Trigger_Group_1");
		strigger.setStartTime(new Date());
		// 设置重复停止时间，并销毁该Trigger对象
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis() + 1000 * 1L);
		strigger.setEndTime(c.getTime());
		strigger.setFireInstanceId("Trigger_1_id_001");
		// 设置重复间隔时间
		strigger.setRepeatInterval(1000 * 1L);
		// 设置重复执行次数
		strigger.setRepeatCount(3);

		// 3、创建Scheduler对象，并配置JobDetail和Trigger对象
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = sf.getScheduler();
			scheduler.scheduleJob(jobDetail, strigger);
			// 4、并执行启动、关闭等操作
			scheduler.start();

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		// try {
		// //关闭调度器
		// scheduler.shutdown(true);
		// } catch (SchedulerException e) {
		// e.printStackTrace();
		// }
	}
}