package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This Welcome controller display welcome page
 * 
 * @author Mohit Sharma
 *
 */
@Controller
public class WelcomeController {
	@RequestMapping(value = "/")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/default")
	public String afterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ADMIN")) {
			return "/admin/dashboard";
		} else if (request.isUserInRole("EMPLOYEE")) {
			return "/employee/dashboard";
		}
		return "redirect:/login";
	}
}
