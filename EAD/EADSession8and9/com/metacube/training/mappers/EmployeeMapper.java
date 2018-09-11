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
		employee.setCode(resultSet.getInt(1));
		employee.setFirstName(resultSet.getString(2));
		employee.setMiddleName(resultSet.getString(3));
		employee.setLastName(resultSet.getString(4));
		employee.setDob(resultSet.getDate(5));
		employee.setGender(resultSet.getString(6));
		employee.setEmailId(resultSet.getString(7));
		employee.setContact(resultSet.getString(8));
		employee.setSkypeId(resultSet.getString(9));
		employee.setProfilePicture(resultSet.getString(10));
		employee.setPassword(resultSet.getString(11));
		employee.setSkills(resultSet.getString(13));
		return employee;
	}
}