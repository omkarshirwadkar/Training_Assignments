package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {
	@RequestMapping("/")
	public String getFirstPage() {
		return "home.jsp";
	}
	
	@RequestMapping("register-user")
	public String registerUser() {
		return "";
	}

	@RequestMapping("login-user")
	public String loginUser() {
		return "";
	}

	@RequestMapping("login")
	public String getlogin() {
		return "login.jsp";
	}

	@RequestMapping("register")
	public String getRegister() {
		return "register.jsp";
	}
}
