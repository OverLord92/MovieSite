package com.movies.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MovieDAO {
	
	NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public Movie getMovie(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.queryForObject("SELECT * FROM movies WHERE id=:id", params, new MovieRowMapper());
	}
	
	public List<Movie> getMovies(){
		return jdbc.query("SELECT * FROM movies", new MovieRowMapper());
	}
	
	public boolean insertMovie(Movie movie){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(movie);
		return (jdbc.update("INSERT INTO movies (name, year, genre, director, runtime)" +
				" VALUES (:name, :year, :genre, :director, :runtime)", params)) == 1;
	}
	
	public boolean updateMovie(Movie movie) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(movie);
		return (jdbc.update("UPDATE movies SET name=:name, year=:year, genre=:genre, director=:director, runtime=:runtime WHERE id=:id", params)) == 1;
	}
	
	public boolean deleteMovie(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return (jdbc.update("DELETE FROM movies WHERE id=:id", params)) == 1;
	}
	
	public static final class MovieRowMapper implements RowMapper<Movie> {

		@Override
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			Movie movie = new Movie();
			
			movie.setId(rs.getInt("id"));
			movie.setName(rs.getString("name"));
			movie.setYear(rs.getInt("year"));
			movie.setGenre(rs.getString("genre"));  ///// kasnije dodaj da moze viti vise zanrova
			movie.setDirector(rs.getString("director"));
			movie.setRuntime(rs.getInt("runtime"));
			
			return movie;
		}
		
	}
	
	
}
