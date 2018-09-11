package com.metacube.training.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.models.Employee;
import com.metacube.training.services.AdminService;
import com.metacube.training.services.EmployeeService;

/**
 * Admin Controller Maps URL to Views
 * 
 * @author Mohit Sharma
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	HttpSession session;
	@Autowired
	EmployeeService employeeService;

	private AdminService adminService;

	@GetMapping("")
	public String adminLogin() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView adminLoginDetails(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		if ("admin".equals(email) && "admin".equals(password)) {
			session.setAttribute("email", email);
			return new ModelAndView("admin/dashboard", "email", email);
		} else {
			String error = "Invalid user or password";
			return new ModelAndView("admin/login", "error", error);
		}
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		session.invalidate();
		return "admin/login";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String adminAddEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/addEmployee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	public String adminAddEmployee(@ModelAttribute("employee") Employee employee) {
		adminService = AdminService.getInstance();
		if (employee != null && employee.getCode() == 0) {
			adminService.addEmployee(employee);
		} else {
			adminService.updateEmployee(employee);
		}
		return "redirect:allEmployees";
	}

	@RequestMapping(path = "/allEmployees", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		adminService = AdminService.getInstance();
		model.addAttribute("employees", adminService.getAllEmployees());
		return "admin/allEmployees";
	}

	@RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("code") int code) {
		model.addAttribute("employee", adminService.getEmployeeByCode(code));
		return "admin/addEmployee";
	}

	@RequestMapping(path = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee(Model model, @RequestParam("code") int code) {
		adminService = AdminService.getInstance();
		model.addAttribute("employee", adminService.deleteEmployeeByCode(code));
		return "redirect:allEmployees";
	}

	@RequestMapping(value = "/searchEmployees", method = RequestMethod.GET)
	public String searchEmployee() {
		return "admin/searchEmployee";
	}

	@RequestMapping(path = "/searchEmployees", method = RequestMethod.POST)
	public String searchEmployee(Model model, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		adminService = AdminService.getInstance();
		model.addAttribute("employees", adminService.searchEmployees(firstName, lastName));
		return "admin/allEmployees";
	}
}
