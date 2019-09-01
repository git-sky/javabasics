package cn.com.sky.tools.test_quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class QuartzJob2 implements Job {

    @Override
    public void execute(JobExecutionContext arg0) {
        System.out.println("。。。。");
    }
}