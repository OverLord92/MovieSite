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
		params.addValue("authority", user.getAuthority());
		params.addValue("enabled", user.isEnabled());
		
		jdbc.update("INSERT INTO users (username, password, enabled)" +
				" VALUES (:username, :password, :enabled)", params);
		
		return (jdbc.update("INSERT INTO authorities (username, authority)" +
				" VALUES (:username, :authority)", params)) == 1;
	}
	
	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers(){
		                                                                                               ////////////////////
		return jdbc.query("SELECT * FROM users,  authorities WHERE users.username=authorities.username", new BeanPropertyRowMapper<User>());
	}
	
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
