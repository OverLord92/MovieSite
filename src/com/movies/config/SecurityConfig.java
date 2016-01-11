package com.movies.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void confugureGlobal(AuthenticationManagerBuilder auth) throws Exception {		

		auth.jdbcAuthentication().passwordEncoder(passwordEncoder())
			.dataSource(dataSource)
			.usersByUsernameQuery(
					"SELECT username, password, enabled FROM users WHERE BINARY username=?")
			.authoritiesByUsernameQuery(
					"SELECT username, authority from authorities WHERE BINARY username=?")
			.rolePrefix("ROLE_");
		
	}
		
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http
				.authorizeRequests()
				.antMatchers("/add/**").access("hasRole('ROLE_USER')")
				.antMatchers("/resources/**").permitAll()
			.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/home")
				.failureUrl("/login?loginerror=true")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/home")
			.and()
				.exceptionHandling().accessDeniedPage("/denied")
			.and()
				.rememberMe()
				.tokenValiditySeconds(600)
				.key("Movies");
		
	}
	
	@Bean
	public StandardPasswordEncoder passwordEncoder(){
		return new StandardPasswordEncoder();
	}
		
}
