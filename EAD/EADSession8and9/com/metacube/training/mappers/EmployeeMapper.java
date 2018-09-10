package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.models.Employee;

/**
 * This class maps Employee to RowMapper
 * 
 * @author Mohit Sharma
 *
 */
public class EmployeeMapper implements RowMapper<Employee> {
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
		Employee employee = new Employee();
		employee.setCode(resultSet.getInt("emp_code"));
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setMiddleName(resultSet.getString("middle_name"));
		employee.setLastName(resultSet.getString("last_name"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setGender(resultSet.getString("gender"));
		employee.setEmailId(resultSet.getString("email_id"));
		employee.setPassword(resultSet.getString("password"));
		return employee;
	}
}