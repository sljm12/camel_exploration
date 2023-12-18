package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;

public class HttpRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jetty:http://localhost:8081/test")
	    .log("Message Received")
	    .process(new HttpProcessor())
	    .to("jdbc:postgresSql");
	}
}
