package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.metacube.training.Status.Status;
import com.metacube.training.services.EmployeeService;

/**
 * Employee Controller Maps URL to Views
 * 
 * @author Mohit Sharma
 *
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String employeeLogin() {
		return "employee/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView employeeLoginDetails(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		Status status = employeeService.login(email, password);
		if (status.equals(Status.EXIST)) {
			session.setAttribute("email", email);
			return new ModelAndView("employee/dashboard", "email", email);
		} else {
			String error = "Invalid user or password";
			return new ModelAndView("employee/login", "error", error);
		}
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		session.invalidate();
		return "employee/login";
	}

	@RequestMapping(value = "/searchEmployees", method = RequestMethod.GET)
	public String searchEmployee() {
		return "employee/searchEmployee";
	}

	@RequestMapping(path = "/searchEmployees", method = RequestMethod.POST)
	public String searchEmployee(Model model, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		model.addAttribute("employees", employeeService.searchEmployees(firstName, lastName));
		return "employee/allEmployees";
	}

	@RequestMapping(path = "/viewProfile", method = RequestMethod.POST)
	public String viewEmployee(Model model, HttpServletRequest request) {
		String emailId = (String) session.getAttribute("email");
		model.addAttribute("employee", employeeService.getEmployeeByEmail(emailId));
		return "employee/editEmployee";
	}
}
