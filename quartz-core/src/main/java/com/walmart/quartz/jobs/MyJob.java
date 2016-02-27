package com.walmart.quartz.jobs;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.walmart.quartz.helpers.ILatch;
import com.walmart.quartz.helpers.MyJobHelper;

public class MyJob extends QuartzJobBean {

	private static int count;

	private static final Logger logger = LoggerFactory.getLogger(MyJob.class);

	@Override
	protected void executeInternal(JobExecutionContext jobContext) throws JobExecutionException {
		try {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("MyJob start: " + jobContext.getFireTime());
			JobDetail jobDetail = jobContext.getJobDetail();
			MyJobHelper jobHelper = (MyJobHelper) jobDetail.getJobDataMap().get("jobState");
			System.out.println("Example name is: " + jobHelper.getSomeStr());
			System.out.println("MyJob end: " + jobContext.getJobRunTime() + ", key: " + jobDetail.getKey());
			System.out.println("MyJob next scheduled time: " + jobContext.getNextFireTime());
			System.out.println("--------------------------------------------------------------------");

			count++;
			System.out.println("Job count " + count);
			ILatch latch = (ILatch) jobDetail.getJobDataMap().get("jobLatch");
			if (latch != null) {
				latch.countDown();
				System.out.println("Job executed, release latch");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}
