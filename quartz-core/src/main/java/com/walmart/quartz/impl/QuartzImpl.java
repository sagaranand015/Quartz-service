package com.walmart.quartz.impl;

import org.dozer.Mapper;

import com.walmart.quartz.api.Quartz;
import com.walmart.quartz.dto.ResponseDto;
import com.walmart.quartz.logic.QuartzLogic;
import com.walmart.quartz.model.Response;

public class QuartzImpl implements Quartz {

	private QuartzLogic quartzLogic;
	private Mapper mapper;

	public QuartzImpl(QuartzLogic quartzLogic, Mapper mapper) {
		this.quartzLogic = quartzLogic;
		this.mapper = mapper;
	}

	public String getVersion() {
		return quartzLogic.getVersion();
	}

	public ResponseDto doJob(String name) {
		Response response = quartzLogic.doJob(name);
		return mapper.map(response, ResponseDto.class);
	}

}
