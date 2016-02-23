package com.walmart.quartz.logic.impl;

import com.walmart.quartz.constants.ErrorCodes;
import com.walmart.quartz.constants.ErrorMessages;
import com.walmart.quartz.logic.QuartzLogic;
import com.walmart.quartz.model.Response;

public class QuartzLogicImpl implements QuartzLogic {

	public String getVersion() {
		Package p = QuartzLogicImpl.class.getPackage();
		if(p != null) {
			if(p.getImplementationVersion() != null) {
				return p.getImplementationVersion();
			} else {
				return "";
			}
		}
		return "";
	}

	public Response doJob() {
		return new Response(ErrorCodes.DUMMY_RESPONSE.getValue(), ErrorMessages.DUMMY_RESPONSE.getValue());
	}

	
	
}
