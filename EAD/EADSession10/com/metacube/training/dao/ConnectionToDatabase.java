package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class makes Connection to Database
 * 
 * @author Mohit Sharma
 *
 */
public class ConnectionToDatabase {
	private static final String databaseName = "employeeportal";
	private static final String username = "root";
	private static final String password = "root";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String connectionClass = "com.mysql.jdbc.Driver";

	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName(connectionClass);
			connection = DriverManager.getConnection(url + databaseName,
					username, password);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			throw new SQLException("Database or Credentials are wrong");
		}
		return connection;
	}
}
