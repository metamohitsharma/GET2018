package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.models.Employee;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
@Repository
public class EmployeeDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Returns Employee using Email
	 * 
	 * @param emailId
	 * @return
	 */
	public Employee getEmployeeByEmail(String emailId) {
		return jdbcTemplate.queryForObject(Queries.GET_EMPLOYEE,
				new Object[] { emailId }, new EmployeeMapper());
	}

	/**
	 * Returns All Employees
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(Queries.GET_ALL_EMPLOYEES,
				new EmployeeMapper());
	}

	/**
	 * Searches Employee
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Employee> searchEmployee(String firstName, String lastName) {
		return jdbcTemplate.query(Queries.SEARCH_EMPLOYEES, new Object[] {
				firstName, lastName }, new EmployeeMapper());
	}

	/**
	 * Returns Employee using Code
	 * 
	 * @param code
	 * @return
	 */
	public Employee getEmployeeByCode(int code) {
		return jdbcTemplate.queryForObject(Queries.GET_EMPLOYEE_BY_CODE,
				new Object[] { code }, new EmployeeMapper());
	}

	/**
	 * Updates Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status updateEmployee(Employee employee) {
		boolean result = jdbcTemplate.update(Queries.UPDATE_EMPLOYEE_BY_CODE,
				employee.getFirstName(), employee.getMiddleName(),
				employee.getLastName(), employee.getDob(),
				employee.getGender(), employee.getEmailId(),
				employee.getSkills(), employee.getCode()) > 0;
		if (result == true) {
			return Status.UPDATED;
		} else {

			return Status.NOT_UPDATED;
		}
	}
}
