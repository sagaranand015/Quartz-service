package com.walmart.quartz.helpers;

import java.util.concurrent.CountDownLatch;

public class SpringQuartzSchedulerExample implements ILatch {

	 private int repeatCount = 3;
	 private CountDownLatch latch;
	  
	 public SpringQuartzSchedulerExample() {
		 System.out.println("Create count down latch for 3");
         latch = new CountDownLatch(repeatCount + 1);
     }
 
     public void countDown() {
         latch.countDown();
     }

     public void waitTillJobsExecute() throws InterruptedException {
         latch.await();
     }

}
