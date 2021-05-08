package com.metacube.training.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.models.Employee;
import com.metacube.training.services.EmployeeService;

/**
 * Employee Controller Maps URL to Views
 * 
 * @author Mohit Sharma
 *
 */
@Controller
@Repository
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	/*
	 * @GetMapping("") public String adminLogin() { return "employee/login"; }
	 * 
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public
	 * ModelAndView adminLoginDetails(@RequestParam("email") String email,
	 * 
	 * @RequestParam("password") String password) { Employee employee =
	 * employeeService.getEmployeeByEmail(email); if (employee != null &&
	 * employee.getPassword().equals(password)) { session.setAttribute("email",
	 * email); return new ModelAndView("employee/dashboard", "email", email); }
	 * else { String error = "Invalid user or password"; return new
	 * ModelAndView("employee/login", "error", error); } }
	 */
	@RequestMapping(value = "/logout")
	public String logout() {
		return "redirect:/";
	}

	@RequestMapping(value = "/searchEmployees", method = RequestMethod.GET)
	public String searchEmployee() {
		return "employee/searchEmployee";
	}

	@RequestMapping(path = "/searchEmployees", method = RequestMethod.POST)
	public String searchEmployee(Model model,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		model.addAttribute("employees",
				employeeService.searchEmployees(firstName, lastName));
		return "employee/searchedEmployee";
	}

	@RequestMapping(path = "/viewProfile", method = RequestMethod.GET)
	public String getAllEmployees(Model model, Principal principal) {
		String emailId = principal.getName();
		model.addAttribute("employees",
				employeeService.getEmployeeByEmail(emailId));
		return "employee/allEmployees";
	}

	@RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("code") int code) {
		model.addAttribute("employee", employeeService.getEmployeeByCode(code));
		return "employee/editEmployee";
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	public String adminAddEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:viewProfile";
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard() {
		return "employee/dashboard";
	}
}
