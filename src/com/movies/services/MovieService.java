package com.movies.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.beans.Movie;
import com.movies.dao.MovieDAO;

@Service
public class MovieService {

	@Autowired
	MovieDAO movieDAO;
	
	/**
	 * Takes desiredMovie as an argument.
	 * Returns all movies from the database which share the same properties as
	 * desiredMovie.
	 * Ignores properties which are null or empty strings.
	 * */
	public List<Movie> filterMovies(Map<String, Object> desiredMovieProperties) {
		List<Movie> allMovies = movieDAO.getMovies();
		List<Movie> searchResults = new ArrayList<>();
		
		for(Movie movie: allMovies) {
			if(checkIfMovieFitsDescription(movie, desiredMovieProperties)) {
				searchResults.add(movie);
			}
		}
		
		return searchResults;
	}
	
	/**  
	 * Returns true if the movie argument fits the user request. Otherwise returns false
	 * */
	public boolean checkIfMovieFitsDescription(Movie movie, Map<String, Object> desiredMovieProperties) {
		
		String name = (String) desiredMovieProperties.get("name");
		String genre = (String) desiredMovieProperties.get("genre");
		
		int fromYear, toYear;
		
		try {
			String fromYearString = (String)desiredMovieProperties.get("fromYear");
			fromYear = Integer.parseInt(fromYearString);
		} catch(NumberFormatException ex) {
			fromYear = Movie.YEAR_OF_FIRST_RECORDED_MOVIE;
		}
		
		try {
			String toYearString = (String)desiredMovieProperties.get("toYear");
			toYear = Integer.parseInt(toYearString);
		} catch(NumberFormatException ex) {
			
			toYear = getNextYear();
		}
		
		if(!movie.getName().contains(name))
			return false;
		
		// check if the movie is within the requested period
		if((movie.getYear() < fromYear) || (movie.getYear() > toYear))
			return false;
		
		// check if movie is of requested genre
		String movieGenre = movie.getGenre().toLowerCase();
		if(!movieGenre.contains(genre))
			return false;
		
		return true;
	}
	
	/**
	 * If The toYear variable is not castable to Integer we assign the value 
	 * next year to it to ensure that there is no upper limit for the search. 
	 * */
	public int getNextYear() {
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	
	}
	
}
