package com.pccoer.jobfair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String startPage() {
		return "Home.jsp";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "Login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage() {
		return "Logout.jsp";
	}
	
	@RequestMapping("/hello")
	public String helloPage() {
		return "Hello.jsp";
	}

}
