package com.movies.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	@NotBlank()
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^\\w{8,}$")
	private String username;
	
	@NotBlank()
	@Size(min = 8, max = 15)
	@Pattern(regexp = "^\\S+$")
	private String password;
	
	private boolean enabled = false;
	private String authority;
	
	
	public User(){
	}
	
	public User(String username, String password, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
}
