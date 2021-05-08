package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.models.Employee;

/**
 * This class contains Business Logic for Employee
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	public Status addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	/**
	 * Searches Employee
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Employee> searchEmployees(String firstName, String lastName) {
		return employeeDAO.searchEmployee(firstName, lastName);
	}

	/**
	 * Returns Employee using Email
	 * 
	 * @param emailId
	 * @return
	 */
	public Employee getEmployeeByEmail(String emailId) {
		return employeeDAO.getEmployeeByEmail(emailId);
	}

	/**
	 * Returns all Employees
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	/**
	 * Return Employee using Code
	 * 
	 * @param code
	 * @return
	 */
	public Employee getEmployeeByCode(int code) {
		return employeeDAO.getEmployeeByCode(code);
	}

	/**
	 * Updates Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	public Status deleteEmployeeByCode(int code) {
		return employeeDAO.deleteEmployee(code);
	}
}
