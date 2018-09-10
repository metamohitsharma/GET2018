package com.metacube.training.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.metacube.training.Status.Status;
import com.metacube.training.dao.AdminDao;
import com.metacube.training.models.Employee;

/**
 * This class contains Business Logic for Admin
 * 
 * @author Mohit Sharma
 *
 */
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	/**
	 * Authenticates Admin
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public Status login(String email, String password) {
		List<Employee> listOfEmployee = adminDao.getAllEmployees();
		for (Employee existingEmployee : listOfEmployee) {
			if (email.equals(existingEmployee.getEmailId()) && password.equals(existingEmployee.getPassword())) {
				return Status.EXIST;
			}
		}
		return Status.NOT_EXIST;
	}

	/**
	 * Adds Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status addEmployee(Employee employee) {
		return adminDao.addEmployee(employee);
	}

	/**
	 * Returns All Employees
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		return adminDao.getAllEmployees();
	}

	/**
	 * Returns Employee by code
	 * 
	 * @param code
	 * @return
	 */
	public Employee getEmployeeByCode(int code) {
		return adminDao.getEmployeeByCode(code);
	}

	/**
	 * Returns Employee by Email
	 * 
	 * @param email
	 * @return
	 */
	public Employee getEmployeeByEmail(String email) {
		return adminDao.getEmployeeByEmail(email);
	}

	/**
	 * Searches Employee using First Name and Last Name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Employee> searchEmployees(String firstName, String lastName) {
		return adminDao.searchEmployees(firstName, lastName);
	}

	/**
	 * Updates Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status updateEmployee(Employee employee) {
		List<Employee> listOfEmployee = adminDao.getAllEmployees();
		for (Employee existingEmployee : listOfEmployee) {
			if (employee.getCode() == existingEmployee.getCode()) {
				return adminDao.updateEmployee(employee);
			}
		}
		return Status.NOT_EXIST;
	}

	/**
	 * Deletes Employee
	 * 
	 * @param code
	 * @return
	 */
	public Status deleteEmployeeByCode(int code) {
		List<Employee> listOfEmployee = new ArrayList<Employee>();
		listOfEmployee = adminDao.getAllEmployees();
		for (Employee existingEmployee : listOfEmployee) {
			if (code == existingEmployee.getCode()) {
				return adminDao.deleteEmployee(code);
			}
		}
		return Status.NOT_EXIST;
	}
}
