package com.walmart.quartz.logic;

import com.walmart.quartz.model.Response;

public interface QuartzLogic {

	public String getVersion();
	
	public Response doJob(String name);

}
