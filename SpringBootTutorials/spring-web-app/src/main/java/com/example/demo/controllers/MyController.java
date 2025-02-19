package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Employee;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@RequestMapping("/")
	public String getFirstPage() {
		return "home.html";
	}
	
	@RequestMapping("/signin")
	public String getLogin() {
		return "login.html";
	}
	
	@RequestMapping("/verify")
	public String verifyUser(String user, String pwd, HttpSession session) {
		session.setAttribute("uname", user);
		if(user.equals(pwd)) {
			return "welcome.jsp";
		}
		else {
			return "failure.jsp";
		}
	}
	
	@RequestMapping("/verifymv")
	public ModelAndView verifyUserMv(String user, String pwd) {
		ModelAndView mv = new ModelAndView();
		if(user.equals(pwd)) {
			mv.addObject("uname", user);
			mv.setViewName("welcome.jsp");
		}
		else {
			mv.setViewName("failure.jsp");
		}
		return mv;
	}

	@RequestMapping("/register")
	public String register() {
		return "empRegister.html";
	}
	
	@RequestMapping("/register_emp")
	@ResponseBody
	public String empRegister(Employee e) {
		System.out.println(e);
		return "<h2>Successfully added Employee record</h2>";
	}
}
