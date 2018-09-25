package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) String error,
			Model model) {
		if (error == null) {
			model.addAttribute("error", null);
		} else {
			model.addAttribute("error", "error");
		}
		return "login";
	}

	@RequestMapping(value = "/default")
	public String afterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "/admin/dashboard";
		} else if (request.isUserInRole("ROLE_EMPLOYEE")) {
			return "/employee/dashboard";
		}
		return "redirect:/login";
	}
}
