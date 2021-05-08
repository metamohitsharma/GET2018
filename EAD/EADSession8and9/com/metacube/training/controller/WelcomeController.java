package com.metacube.training.controller;

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
}
