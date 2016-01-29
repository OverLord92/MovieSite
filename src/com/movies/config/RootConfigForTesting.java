package com.movies.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Configuration
//@EnableTransactionManagement
//@Import({SecurityConfig.class}) 
//@ComponentScan(basePackages={"com"},
//		excludeFilters={
//				@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
//		})
public class RootConfigForTesting {

	
	@Bean
	public DataSource basicDataSource(){
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/movies");
		dataSource.setUsername("root");
		dataSource.setPassword("gEdOrA92");
		
		return dataSource;
	}
	
	@Bean 
	public DataSourceTransactionManager transactionManager(){
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
	
		dstm.setDataSource(basicDataSource());
		return dstm;
	}
	
}
