package com.movies.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
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
		
		JndiDataSourceLookup jndi = new JndiDataSourceLookup();
		DataSource dataSource = jndi.getDataSource("jdbc/movies");
		
		return dataSource;
	}
	
	@Bean 
	public DataSourceTransactionManager transactionManager(){
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
	
		dstm.setDataSource(dataSource());
		return dstm;
	}
	
}
