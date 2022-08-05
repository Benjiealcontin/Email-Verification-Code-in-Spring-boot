package com.operation.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.operation.Model.User;
import com.operation.Service.Services;


@Controller
public class Controllers {

	@Autowired
	private Services service;
	
	@RequestMapping("/")	
	public ModelAndView homepage() {
		return new ModelAndView("index");		
	}
	
	@PostMapping("/verify")
	public String verify(@RequestParam("username")String username,@RequestParam("useremail")String email,HttpSession session) {
		
		
		// get the 6-digit code
		String code = service.getRandom();

		// craete new user using all information
		User user = new User(username, email, code);

		// call the send email method
		boolean test = service.SendEmail(user);

		// check if the email send successfully
		if (test) {
			session.setAttribute("authcode", user);
			return "verify";
		} else {
			return "Failed to send verification email";
		}

	}
	
	@PostMapping("/verifycode")
	public String verifycode(@RequestParam("authcode")String code,HttpSession session) {
		User user = (User) session.getAttribute("authcode");


		if (code.equals(user.getCode())) {
			return"success";
		} else {
			return"error";
		}

	}
	
	}



