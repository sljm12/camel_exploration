package org.apache.camel.learn;

import java.util.HashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.http.common.HttpMessage;

public class SQLProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		HttpMessage message = exchange.getIn().getBody(HttpMessage.class);		
		//String a = message.getHeader("a", String.class);
		//String b = message.getHeader("b",String.class);
		//System.out.println(a +" "+ b);
		System.out.println(message.getBody());
		HashMap map=message.getBody(HashMap.class);
		
		message.setHeader("name",map.get("name"));
		message.setHeader("description",map.get("description"));
		message.setHeader("price",map.get("price"));
		message.setHeader("tax",map.get("tax"));
		
		String insert_query="INSERT INTO public.\"JSON_TABLE\" (name,description, price,tax) values (:?name,:?description,:?price,:?tax)";
		//String insert_query ="INSERT INTO public.\"TestInsertCamel\" (id,text) values ("+a+","+b+")";
		//System.out.println(insert_query);
		exchange.getIn().setBody(insert_query);
	}

}
