package com.movies.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movies.dao.Movie;
import com.movies.dao.MovieDAO;

@Controller
public class AppController {

	@Autowired
	MovieDAO movieDAO;

	@RequestMapping(value = "/searchMoviez", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Map<String, Object> listMovies(@RequestBody Map<String, Object> data) throws Exception {

		String name = (String) data.get("name");

		String fromYearString = (String) data.get("fromYear");
		String toYearString = (String) data.get("toYear");
		
		String genre = (String) data.get("genre");
		
		System.out.println(genre);

		System.out.println(":" + fromYearString + ":" + toYearString + ":");

		int fromYear, toYear;

		if (fromYearString.equals("")) {
			fromYear = 1896;
		} else {
			fromYear = Integer.parseInt(fromYearString);
		}

		if (toYearString.equals("")) {
			toYear = 2016;
		} else {
			toYear = Integer.parseInt(toYearString);
		}

		System.out.println(":" + fromYear + ":" + toYear + ":");

		List<Movie> movies = filterMovies(name, fromYear, toYear, genre);

		// List<Movie> movies = new ArrayList<>();

		Map<String, Object> resultData = new HashMap<>();
		resultData.put("movies", movies);
		resultData.put("size", movies.size());
		return resultData;

	}

	public List<Movie> filterMovies(String name, int fromYear, int toYear, String genre) {

		List<Movie> allMovies = movieDAO.getMovies();
		List<Movie> searchResult = new ArrayList<>();
		Movie currentMovie;
		String currentGenre;


		for (int i = 0; i < allMovies.size(); i++) {
			currentMovie = allMovies.get(i);

			if (!currentMovie.getName().contains(name))
				continue;

			if((currentMovie.getYear() < fromYear) || (currentMovie.getYear() > toYear))
				continue;
			
			currentGenre = currentMovie.getGenre().toLowerCase();
			
			if(!currentGenre.contains(genre))
				continue;

			searchResult.add(currentMovie);

		}

		return searchResult;
	}
}
