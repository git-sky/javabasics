package cn.com.todo.test_quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob implements Job {
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("-------QuartzJob------------");
	}
}