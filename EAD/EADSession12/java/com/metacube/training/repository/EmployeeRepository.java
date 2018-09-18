package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.models.Employee;

/**
 * Interface for Employee
 * 
 * @author Mohit Sharma
 *
 * @param <E>
 */
public interface EmployeeRepository<E> extends JpaRepository<Employee, Integer> {
	/**
	 * Returns employee by email
	 * 
	 * @param email
	 * @return
	 */
	public Employee findByEmail(String email);

	/**
	 * Returns Employees by Firstname and lastname
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Employee> findEmployeesByFirstNameOrLastName(String firstName,
			String lastName);
}
