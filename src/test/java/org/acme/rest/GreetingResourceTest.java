package org.acme.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response.Status;

import org.acme.service.GreetingService;
import org.junit.jupiter.api.Test;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
class GreetingResourceTest {

	@InjectMock
	GreetingService greetingService;

	@Test
	void testHelloEndpoint() {
		when(greetingService.getWelcomeMessage()).thenCallRealMethod();
		given()
				.when().get("/hello")
				.then()
				.statusCode(Status.OK.getStatusCode())
				.body(is("Hello from RESTEasy Reactive"));
	}

	@Test
	void testHelloEndpointWithMock() {
		String expectedValue = "Hi Hi";

		when(greetingService.getWelcomeMessage()).thenReturn(expectedValue);

		given()
				.when().get("/hello")
				.then()
				.statusCode(Status.OK.getStatusCode())
				.body(is(expectedValue));
	}

	@Test
	void testWithQuarkusLogger() {
		Log.info("This is a Quarkus logger test example");
		assertTrue(true);
	}

}