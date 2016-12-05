package com.sahoora.rest.service.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/StudentService_1")
public class StudentService {

	@GET
	@Path("/get_data")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStudent() {
		String reponse = "This is standard response from REST";
		return reponse;
	}
}
