package com.walmart.quartz.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.walmart.quartz.model.Response;

public interface Quartz {

	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_PLAIN)
	public String getVersion();
	
	@POST
	@Path("/{jobName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response doJob(@PathParam("jobName") String name);
	
}
