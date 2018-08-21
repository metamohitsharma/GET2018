package GET2018.DBMS.DBMSSession5;

/**
 * This is a Utility Class that is used to store CONSTANT Variables
 * 
 * @author Mohit Sharma
 *
 */
public class UtilityClass {
	private static final String databaseName = "storefront";
	private static final String username = "root";
	private static final String password = "rootms123";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String connectionClass = "com.mysql.jdbc.Driver";

	public static String getConnectionclass() {
		return connectionClass;
	}

	public static String getDatabasename() {
		return databaseName;
	}

	public static String getPassword() {
		return password;
	}

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}
}
