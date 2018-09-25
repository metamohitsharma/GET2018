package com.metacube.training.services;

import java.util.List;
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

	private static AdminService adminService = new AdminService();
	private AdminDao adminDao;

	public static AdminService getInstance() {
		return adminService;
	}

	/**
	 * Adds Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status addEmployee(Employee employee) {
		AdminDao adminDao = AdminDao.getInstance();
		return adminDao.addEmployee(employee);
	}

	/**
	 * Returns All Employees
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		adminDao = AdminDao.getInstance();
		return adminDao.getAllEmployees();
	}

	/**
	 * Returns Employee by code
	 * 
	 * @param code
	 * @return
	 */
	public Employee getEmployeeByCode(int code) {
		adminDao = AdminDao.getInstance();
		return adminDao.getEmployeeByCode(code);
	}

	/**
	 * Returns Employee by Email
	 * 
	 * @param email
	 * @return
	 */
	/*
	 * public Employee getEmployeeByEmail(String email) { adminDao =
	 * AdminDao.getInstance(); return adminDao.getEmployeeByEmail(email); }
	 */

	/**
	 * Searches Employee using First Name and Last Name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Employee> searchEmployees(String firstName, String lastName) {
		adminDao = AdminDao.getInstance();
		return adminDao.searchEmployees(firstName, lastName);
	}

	/**
	 * Updates Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status updateEmployee(Employee employee) {
		adminDao = AdminDao.getInstance();
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
		adminDao = AdminDao.getInstance();
		List<Employee> listOfEmployee = adminDao.getAllEmployees();
		for (Employee existingEmployee : listOfEmployee) {
			if (code == existingEmployee.getCode()) {
				return adminDao.deleteEmployee(code);
			}
		}
		return Status.NOT_EXIST;
	}
}
