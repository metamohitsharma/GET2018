package GET2018.EAD.EADSession3.DAO;

/**
 * This class stores various Queries on database
 * 
 * @author Mohit Sharma
 *
 */
public class EmployeeQueries {

	public static String getQueryOne() {
		return "INSERT INTO employee VALUES(?,?,?,?)";
	}

	public static String getQueryTwo() {
		return "SELECT * FROM employee";
	}

	public static String getQueryThree(String firstName, String lastName) {
		return "SELECT * FROM employee WHERE first_name ='" + firstName
				+ "' AND last_name = '" + lastName + "';";
	}

	public static String getQueryFour(String email) {
		return "SELECT * FROM employee WHERE email='" + email + "';";
	}

	public static String getQueryFive() {
		return "UPDATE employee SET first_name=?, last_name=?, age=? WHERE email=?;";
	}
}
