package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
public class AdminDao {

	private Connection connection;

	/**
	 * Adds Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status addEmployee(Employee employee) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.ADD_EMPLOYEE;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getMiddleName());
			statement.setString(3, employee.getLastName());
			statement.setDate(4, employee.getDob());
			statement.setString(5, employee.getGender());
			statement.setString(6, employee.getEmailId());
			statement.setString(7, employee.getContact());
			statement.setString(8, employee.getSkypeId());
			statement.setString(9, employee.getProfilePicture());
			statement.setString(10, employee.getSkills());
			int result = statement.executeUpdate();
			if (result > 0) {
				return Status.INSERTED;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Status.NOT_INSERTED;
	}

	/**
	 * Returns All the Employees
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		List<Employee> listOfEmployee = new ArrayList<Employee>();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.GET_ALL_EMPLOYEES;
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setCode(resultSet.getInt("code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setGender(resultSet.getString("gender"));
				employee.setEmailId(resultSet.getString("email"));
				employee.setContact(resultSet.getString("contact"));
				employee.setSkypeId(resultSet.getString("skype_id"));
				employee.setProfilePicture(resultSet.getString("profile_picture"));
				employee.setPassword(resultSet.getString("password"));
				employee.setSkills(resultSet.getString("skills"));
				listOfEmployee.add(employee);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listOfEmployee;
	}

	/**
	 * Search Employee using First Name and Last Name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Employee> searchEmployees(String firstName, String lastName) {
		List<Employee> listOfEmployee = new ArrayList<Employee>();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.SEARCH_EMPLOYEES;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			ResultSet resultSet = statement.executeQuery();
			Employee employee;
			while (resultSet.next()) {
				employee = new Employee();
				employee.setCode(resultSet.getInt("code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setGender(resultSet.getString("gender"));
				employee.setEmailId(resultSet.getString("email"));
				employee.setContact(resultSet.getString("contact"));
				employee.setSkypeId(resultSet.getString("skype_id"));
				employee.setProfilePicture(resultSet.getString("profile_picture"));
				employee.setPassword(resultSet.getString("password"));
				employee.setSkills(resultSet.getString("skills"));
				listOfEmployee.add(employee);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listOfEmployee;
	}

	/**
	 * Returns Employee by Code
	 * 
	 * @param code
	 * @return
	 */
	public Employee getEmployeeByCode(int code) {
		Employee employee = new Employee();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.GET_EMPLOYEE_BY_CODE;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, code);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				employee = new Employee();
				employee.setCode(resultSet.getInt("code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setGender(resultSet.getString("gender"));
				employee.setEmailId(resultSet.getString("email"));
				employee.setContact(resultSet.getString("contact"));
				employee.setSkypeId(resultSet.getString("skype_id"));
				employee.setProfilePicture(resultSet.getString("profile_picture"));
				employee.setPassword(resultSet.getString("password"));
				employee.setSkills(resultSet.getString("skills"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return employee;
	}

	/**
	 * Returns Employee by Email
	 * 
	 * @param email
	 * @return
	 */
	public Employee getEmployeeByEmail(String email) {
		Employee employee = new Employee();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.GET_EMPLOYEE_BY_EMAIL;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				employee.setCode(resultSet.getInt("code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setGender(resultSet.getString("gender"));
				employee.setEmailId(resultSet.getString("email"));
				employee.setContact(resultSet.getString("contact"));
				employee.setSkypeId(resultSet.getString("skype_id"));
				employee.setProfilePicture(resultSet.getString("profile_picture"));
				employee.setPassword(resultSet.getString("password"));
				employee.setSkills(resultSet.getString("skills"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return employee;
	}

	/**
	 * Updates Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status updateEmployee(Employee employee) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.UPDATE_EMPLOYEE;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getMiddleName());
			statement.setString(3, employee.getLastName());
			statement.setDate(4, employee.getDob());
			statement.setString(5, employee.getGender());
			statement.setString(6, employee.getEmailId());
			statement.setString(7, employee.getContact());
			statement.setString(8, employee.getSkypeId());
			statement.setString(9, employee.getProfilePicture());
			statement.setString(10, employee.getSkills());
			statement.setInt(11, employee.getCode());
			int result = statement.executeUpdate();
			if (result > 0) {
				return Status.UPDATED;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Status.NOT_UPDATED;
	}

	/**
	 * Deletes Employee
	 * 
	 * @param code
	 * @return
	 */
	public Status deleteEmployee(int code) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.DELETE_EMPLOYEE;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, code);
			int result = statement.executeUpdate();
			if (result > 0) {
				return Status.DELETED;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Status.NOT_DELETED;
	}
}
