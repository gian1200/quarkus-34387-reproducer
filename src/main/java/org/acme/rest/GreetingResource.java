package org.acme.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.service.GreetingService;

import io.quarkus.logging.Log;

@Path("/hello")
public class GreetingResource {

	@Inject
	GreetingService greetingService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		Log.info(greetingService.getWelcomeMessage());
		return greetingService.getWelcomeMessage();
	}

}