package com.metacube.training.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;
import com.metacube.training.repository.EmployeeRepository;

/**
 * This class contains Business Logic for Employee
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepository<Employee> employeeRepository;

	public Status addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return Status.INSERTED;
	}

	/**
	 * Searches Employee
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Employee> searchEmployees(String firstName, String lastName) {
		return employeeRepository.findEmployeesByFirstNameOrLastName(firstName,
				lastName);
	}

	/**
	 * Returns Employee using Email
	 * 
	 * @param emailId
	 * @return
	 */
	public Employee getEmployeeByEmail(String emailId) {
		return employeeRepository.findByEmail(emailId);
	}

	/**
	 * Returns all Employees
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * Return Employee using Code
	 * 
	 * @param code
	 * @return
	 */
	public Employee getEmployeeByCode(int code) {
		return employeeRepository.findOne(code);
	}

	/**
	 * Updates Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status updateEmployee(Employee employee) {
		employeeRepository.saveAndFlush(employee);
		return Status.UPDATED;
	}

	public Status deleteEmployeeByCode(int code) {
		employeeRepository.delete(code);
		return Status.DELETED;
	}
}
