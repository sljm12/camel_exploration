package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;

public class HttpRouteBuilder extends RouteBuilder{

	@Override
	/**
	 * Gets from a Http Jetty Endpoint that restricts to only POST requests and
	 * saves the result into a Postgresql DB
	 */
	public void configure() throws Exception {
		from("jetty:http://localhost:8081/test?httpMethodRestrict=POST")
	    .log("Message Received")
	    //.process(new HttpProcessor())
		.to("http://localhost:8000/items/?bridgeEndpoint=true");
	    //.to("jdbc:postgresSql");
		
		from("jetty:http://localhost:8081/test?httpMethodRestrict=POST")
		.process(new HttpProcessor());
	}
}
