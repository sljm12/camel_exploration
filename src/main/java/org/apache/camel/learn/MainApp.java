package org.apache.camel.learn;

import javax.sql.DataSource;

import org.apache.camel.CamelConfiguration;
import org.apache.camel.main.Main;
import org.apache.camel.spi.Registry;
import org.apache.camel.support.SimpleRegistry;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * A Camel Application
 */
public class MainApp {
	
    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
    	
        Main main = new Main(MainApp.class);
        //Using Auto Discovery for the routes and also Auto Binding. Look at MyConfiguration
        //main.configure().addRoutesBuilder(new MyRouteBuilder());
        //main.configure().addRoutesBuilder(new HttpRouteBuilder());
        
        main.run(args);
    }

}

