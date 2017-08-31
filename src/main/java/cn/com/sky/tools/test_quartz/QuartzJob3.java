package cn.com.sky.tools.test_quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob3 implements Job {
	public void execute(JobExecutionContext jobExecutionContext)
			throws JobExecutionException {
		System.out.println(new Date() + ": doing something...");
	}
}