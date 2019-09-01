package cn.com.sky.tools.test_quartz;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartzJob {

    private static Scheduler sched;

    public static void run() throws Exception {
        // 创建LzstoneTimeTask的定时任务
        JobDetail jobDetail = new JobDetail("lzstoneJob",
                Scheduler.DEFAULT_GROUP, QuartzJob.class);
        // 目标 创建任务计划
        CronTrigger trigger = new CronTrigger("lzstoneTrigger", "lzstone",
                "0/1 * * * * ?");
        sched = new StdSchedulerFactory().getScheduler();
        sched.scheduleJob(jobDetail, trigger);
        sched.start();
    }

    // 停止
    public static void stop() throws Exception {
        sched.shutdown();
    }

    public static void main(String[] args) throws Exception {
        TestQuartzJob.run();
    }
}
