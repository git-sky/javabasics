package cn.com.sky.tools.test_quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

public class QuartzJob3 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println(new Date() + ": doing something...");
    }
}