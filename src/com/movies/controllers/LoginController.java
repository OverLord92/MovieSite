package com.movies.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movies.beans.User;
import com.movies.dao.UserDAO;

@Controller
public class LoginController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/login")
	public String showLoginForm(){
		return "login";
	}
	
	@RequestMapping("/denied")
	public String showDenied(Model model){
		return "denied";
	}
	
	@RequestMapping("/register")
	public String showRegistrationForm(@ModelAttribute User user){
		System.out.println("pozvan register");
		return "register";
	}
	
	@RequestMapping(value="/createAccount", method=RequestMethod.POST)
	public String showAccount(@Valid User user, Errors errors){
		
		// handle the rest of the user validation
		if(errors.hasErrors()){
			return "register";
		}
		
		user.setEnabled(true);
		user.setAuthority("USER");
		
		// handle duplicate usernames
		if(userDAO.userExists(user.getUsername())){
			errors.rejectValue("username", "DuplicateKey.user.username");
			return "register";
		}
		
		try {
			userDAO.insertUser(user);
		} catch(DuplicateKeyException ex) {
			errors.rejectValue("username", "DuplicateKey.user.username");
			return "register";
		}
		
		return "index";
	}
	
	@RequestMapping("checkIfUserExists")
	public @ResponseBody String doesUserExist(HttpServletRequest request){
		
		String username = request.getParameter("username");
		
		boolean userExists = userDAO.userExists(username);
		
		if(userExists)
			return "false";
		else
			return "true";
		
	}
}













