package com.movies.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.movies.beans.User;

@Repository
public class UserDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean insertUser(User user){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		
		return (jdbc.update("INSERT INTO users (username, password, enabled, authority)" +
				" VALUES (:username, :password, :enabled, :authority)", params)) == 1;
		
	}
	
	/** Returns all users from database */
	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers(){                                    
		return jdbc.query("SELECT * FROM users", new BeanPropertyRowMapper<User>());
	}
	
	/** Check if user exists in the database */
	public boolean userExists(String username){
		return (jdbc.queryForObject("SELECT COUNT(*) from users WHERE username=:username", 
				new MapSqlParameterSource("username", username), Integer.class)) > 0;
	}
	
	public static final class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEnabled(rs.getBoolean(""));
			
			return user;
		}
		
	}
	
	
}
