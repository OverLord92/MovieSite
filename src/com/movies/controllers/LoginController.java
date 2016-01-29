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
		return "register";
	}
	
	@RequestMapping(value="/createAccount", method=RequestMethod.POST)
	public String showAccount(@Valid User user, Errors errors){
		
		// handle the rest of the user validation
		if(errors.hasErrors()){
			return "register";
		}
		
		// handle duplicate usernames
		if(userDAO.userExists(user.getUsername())){
			errors.rejectValue("username", "DuplicateKey.user.username");
			return "register";
		}
		
		user.setEnabled(true);
		user.setAuthority("USER");
		
		try {
			userDAO.insertUser(user);
		} catch(DuplicateKeyException ex) {
			errors.rejectValue("username", "DuplicateKey.user.username");
			return "register";
		}
		
		return "index";
	}
	
	@RequestMapping("checkIfUserExists")
	public @ResponseBody String isUsernameAvailable(HttpServletRequest request){
		
		String username = request.getParameter("username");
		
		boolean userExists = userDAO.userExists(username);
		
		return !userExists + "";
		
	}
}













