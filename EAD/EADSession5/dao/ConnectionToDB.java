package GET2018.EAD.EADSession5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class Creates Connection with Database
 * 
 * @author Mohit Sharma
 *
 */
public class ConnectionToDB {

	/**
	 * Create Connection with Database
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(UtilityForConnection.getDrivername());
			try {
				connection = (Connection) DriverManager.getConnection(
						UtilityForConnection.getUrl() + UtilityForConnection.getDbname(),
						UtilityForConnection.getUsername(), UtilityForConnection.getPassword());
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return connection;
	}
}