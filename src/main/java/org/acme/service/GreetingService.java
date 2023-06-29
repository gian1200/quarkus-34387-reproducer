package org.acme.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

	public String getWelcomeMessage() {
		return "Hello from RESTEasy Reactive";
	}

}