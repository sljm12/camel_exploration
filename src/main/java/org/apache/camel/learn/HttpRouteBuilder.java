package org.apache.camel.learn;

import java.util.HashMap;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class HttpRouteBuilder extends RouteBuilder{

	@Override
	/**
	 * Gets from a Http Jetty Endpoint that restricts to only POST requests and
	 * saves the result into a Postgresql DB amd reroute to another http endpoint
	 */
	public void configure() throws Exception {
		
		from("direct:saveToDB")
		.unmarshal().json(JsonLibrary.Gson, HashMap.class) //Unmarshal the JSON to a HashMap
		.log("SaveToDB")
		.process(new SQLProcessor())//SQLProcessor sets the headers 
		.to("jdbc:postgresSql?useHeadersAsParameters=true");
		
		from("jetty:http://localhost:8081/test?httpMethodRestrict=POST")
	    .log("Message Received")
		.to("http://localhost:8000/items/?bridgeEndpoint=true","direct:saveToDB");
	}
}
