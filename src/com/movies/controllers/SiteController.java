package com.movies.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movies.dao.Movie;
import com.movies.dao.MovieDAO;

@Controller
public class SiteController {
	
	@Autowired
	MovieDAO movieDAO;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(HttpSession session){
		session.setMaxInactiveInterval(60);
		return "index";
	}
	
	@RequestMapping("/movies")
	public String goTOMovies(Model model){
		model.addAttribute("movies", movieDAO.getMovies());
		return "movies";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String showAddMovie(@ModelAttribute Movie movie){
		return "addMovie";
	}
	
	@RequestMapping("/search")
	public String goToSearch(){
		return "searchMovie"; /// dodaj filmove u model pa da mozes pretrazivati
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addMovie(Movie movie, Errors errors, Model model){  
		
		if(!errors.hasErrors()){
			System.out.println("uspjesno dodan");
			movieDAO.insertMovie(movie);
			model.addAttribute("success", "true");
		}
		
		return "addMovie";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String editMovie(@ModelAttribute Movie movie, @PathVariable int id, Model model){
		
		movie.setId(id);
		movieDAO.updateMovie(movie);
		model.addAttribute("movies", movieDAO.getMovies());
		
		return "movies";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteMovie(@PathVariable int id, Model model){
		
		movieDAO.deleteMovie(id);
		model.addAttribute("movies", movieDAO.getMovies());
		
		return "movies";
	}
	
}
