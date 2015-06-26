package org.jataylor.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jataylor.model.PingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Path("/ping")
public class PingService {

	@Value("${ping.message}")
	private String message;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PingResponse ping() {
		PingResponse response = new PingResponse();
		response.setMessage(message);
		response.setServiceName(getClass().getCanonicalName());
		return response;
	}
}
