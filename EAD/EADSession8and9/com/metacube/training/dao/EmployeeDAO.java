package com.metacube.training.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.metacube.training.Query.Queries;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.models.Employee;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
public class EmployeeDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Returns All Employees
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(Queries.GET_ALL_EMPLOYEES, new EmployeeMapper());
	}

	/**
	 * Searches Employee
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Employee> searchEmployee(String firstName, String lastName) {
		return jdbcTemplate.query(Queries.SEARCH_EMPLOYEES, new Object[] { firstName, lastName }, new EmployeeMapper());
	}

	/**
	 * Returns Employee using Email
	 * 
	 * @param emailId
	 * @return
	 */
	public Employee getEmployeeByEmail(String emailId) {
		return jdbcTemplate.queryForObject(Queries.GET_EMPLOYEE_BY_EMAIL, new Object[] { emailId },
				new EmployeeMapper());
	}
}
