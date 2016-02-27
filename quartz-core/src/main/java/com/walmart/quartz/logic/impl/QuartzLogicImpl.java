package com.walmart.quartz.logic.impl;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.walmart.quartz.constants.ErrorCodes;
import com.walmart.quartz.constants.ErrorMessages;
import com.walmart.quartz.helpers.ILatch;
import com.walmart.quartz.helpers.SpringQuartzSchedulerExample;
import com.walmart.quartz.logic.QuartzLogic;
import com.walmart.quartz.model.Response;

public class QuartzLogicImpl implements QuartzLogic, ILatch {

	private int repeatCount = 3;
	private CountDownLatch latch;

	private static final Logger logger = LoggerFactory.getLogger(QuartzLogicImpl.class);

	public String getVersion() {
		Package p = QuartzLogicImpl.class.getPackage();
		if (p != null) {
			if (p.getImplementationVersion() != null) {
				return p.getImplementationVersion();
			} else {
				return "";
			}
		}
		return "";
	}

	public Response doJob(String name) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"springQuartzSchedulerContext.xml");
			try {
				SpringQuartzSchedulerExample example = (SpringQuartzSchedulerExample) context.getBean("jobLatch");
				example.waitTillJobsExecute();
				System.out.println("All triggers executed. Shutdown scheduler");
			} finally {
				context.close();
			}
			return new Response(ErrorCodes.SUCCESS_RESPONSE.getValue(), ErrorMessages.SUCCESS_RESPONSE.getValue());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new Response(ErrorCodes.ERROR_RESPONSE.getValue(), ErrorMessages.ERROR_RESPONSE.getValue());
		}
	}

	public void countDown() {
		latch.countDown();
	}

	public void waitTillJobsExecute() throws InterruptedException {
		latch.await();
	}

}
