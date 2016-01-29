package com.movies.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movies.beans.Movie;
import com.movies.services.MovieService;

@Controller
public class AppController {

	@Autowired
	MovieService movieService;

	@RequestMapping(value = "/searchMovies", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Map<String, Object> searchMovies(@RequestBody Map<String, Object> desiredMovieProperties) throws Exception {

		List<Movie> movies = movieService.filterMovies(desiredMovieProperties);

		Map<String, Object> resultData = new HashMap<>();
		resultData.put("movies", movies);
		return resultData;

	}
}
