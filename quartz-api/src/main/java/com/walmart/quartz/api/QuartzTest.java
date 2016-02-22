package com.walmart.quartz.api;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.TEXT_PLAIN)
public interface QuartzTest {

	@GET
	@Path("/version")
	public String getVersion();
	
}
