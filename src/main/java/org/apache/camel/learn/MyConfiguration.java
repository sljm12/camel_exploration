package org.apache.camel.learn;

import javax.sql.DataSource;

import org.apache.camel.BindToRegistry;
import org.apache.camel.CamelConfiguration;
import org.apache.camel.Configuration;
import org.apache.commons.dbcp.BasicDataSource;

@Configuration
public class MyConfiguration implements CamelConfiguration{
	
	private static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("mysecretpassword");
        ds.setUrl(connectURI);
        return ds;
    }
	
	@BindToRegistry
	public DataSource postgresSql() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
	    DataSource dataSource = setupDataSource(url);
	    return dataSource;
	}
}
