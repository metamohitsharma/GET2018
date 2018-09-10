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

	/**
	 * Authenticates Employee
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public Status login(String email, String password) {
		List<Employee> listOfEmployee = employeeDAO.getAllEmployees();
		for (Employee existingEmployee : listOfEmployee) {
			if (email.equals(existingEmployee.getEmailId()) && password.equals(existingEmployee.getPassword())) {
				return Status.EXIST;
			}
		}
		return Status.NOT_EXIST;
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
}
