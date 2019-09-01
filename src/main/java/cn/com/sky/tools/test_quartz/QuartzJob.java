package cn.com.sky.tools.test_quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class QuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("-------QuartzJob------------");
    }

}