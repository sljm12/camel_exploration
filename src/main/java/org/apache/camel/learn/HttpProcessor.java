package org.apache.camel.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.http.common.HttpMessage;

public class HttpProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		HttpMessage message = exchange.getIn().getBody(HttpMessage.class);		
		String a = message.getHeader("a", String.class);
		String b = message.getHeader("b",String.class);
		System.out.println(a +" "+ b);
		String insert_query ="INSERT INTO public.\"TestInsertCamel\" (id,text) values ("+a+","+b+")";
		System.out.println(insert_query);
		exchange.getIn().setBody(insert_query);
	}

}
