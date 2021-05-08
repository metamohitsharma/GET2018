package GET2018.EAD.EADSession4.DAO;

/**
 * This class stores various Queries on database
 * 
 * @author Mohit Sharma
 *
 */
public class EmployeeQueries {

	public static String getQueryOne() {
		return "SELECT id, password FROM user WHERE email=?";
	}

	public static String getQueryTwo() {
		return "INSERT INTO user(first_name, last_name, date_of_birth, contact_no, email, password, organization) VALUES(?,?,?,?,?,?,?)";
	}

	public static String getQueryThree() {
		return "SELECT * FROM user WHERE id = ?";
	}

	public static String getQueryFour() {
		return "UPDATE user SET first_name=?, last_name=?, date_of_birth=?, contact_no=? WHERE id=?";
	}

	public static String getQueryFive() {
		return "SELECT id, first_name, last_name FROM user WHERE organization IN (SELECT organization "
				+ "FROM user WHERE id=?)";
	}
}
