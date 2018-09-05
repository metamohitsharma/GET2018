package GET2018.EAD.EADSession5.dao;

/**
 * Utility class for Connection to Database
 * 
 * @author Mohit Sharma
 *
 */
public class UtilityForConnection {
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String dbName = "category_advertisement";
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String userName = "root";
	private static final String password = "rootms123";

	public static String getDbname() {
		return dbName;
	}

	public static String getDrivername() {
		return driverName;
	}

	public static String getPassword() {
		return password;
	}

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return userName;
	}
}
