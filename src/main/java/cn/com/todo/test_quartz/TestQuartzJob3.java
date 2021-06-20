package cn.com.todo.test_quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * quartz��ʱ������
 */

public class TestQuartzJob3 {
	public static void main(String[] args) {
		// 1������JobDetial����
		JobDetail jobDetail = new JobDetail();
		// ���ù�����
		jobDetail.setJobClass(QuartzJob3.class);
		jobDetail.setName("QuartzJob3_1");
		jobDetail.setGroup("JobGroup_1");

		// 2������Trigger����
		SimpleTrigger strigger = new SimpleTrigger();
		strigger.setName("Trigger_1");
		strigger.setGroup("Trigger_Group_1");
		strigger.setStartTime(new Date());
		// �����ظ�ֹͣʱ�䣬�����ٸ�Trigger����
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis() + 1000 * 1L);
		strigger.setEndTime(c.getTime());
		strigger.setFireInstanceId("Trigger_1_id_001");
		// �����ظ����ʱ��
		strigger.setRepeatInterval(1000 * 1L);
		// �����ظ�ִ�д���
		strigger.setRepeatCount(3);

		// 3������Scheduler���󣬲�����JobDetail��Trigger����
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = sf.getScheduler();
			scheduler.scheduleJob(jobDetail, strigger);
			// 4����ִ���������رյȲ���
			scheduler.start();

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		// try {
		// //�رյ�����
		// scheduler.shutdown(true);
		// } catch (SchedulerException e) {
		// e.printStackTrace();
		// }
	}
}