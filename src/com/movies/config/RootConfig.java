package com.movies.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableTransactionManagement
@Import({SecurityConfig.class}) 
@ComponentScan(basePackages={"com"},
		excludeFilters={
				@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
		})
public class RootConfig {

	@Bean
	public DataSource dataSource(){
		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();
		
		try {
			dataSource = (DataSource) jndi.lookup("java:comp/env/jdbc/movies");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	@Bean 
	public DataSourceTransactionManager transactionManager(){
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
	
		dstm.setDataSource(dataSource());
		return dstm;
	}
	
}
