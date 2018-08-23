package GET2018.DBMS.DBMSSession5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used for Connecting Database
 * 
 * @author Mohit Sharma
 *
 */
public class ConnectionToDB {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName(UtilityForConnection.getConnectionclass());
			connection = DriverManager.getConnection(
					UtilityForConnection.getUrl() + UtilityForConnection.getDatabasename(),
					UtilityForConnection.getUsername(), UtilityForConnection.getPassword());
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (SQLException e) {
			throw new SQLException("Database or Credentials are wrong");
		}
		return connection;
	}
}
