package GET2018.EAD.EADSession4.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import GET2018.EAD.EADSession4.Model.AuthenticatePojo;
import GET2018.EAD.EADSession4.Model.FriendInfoPojo;
import GET2018.EAD.EADSession4.Model.UserInfoPojo;

/**
 * This class is Data Access Object i.e., it retrieves data from Database
 * 
 * @author Mohit Sharma
 *
 */
public class DAOMethods {
	private static DAOMethods singleDAO = new DAOMethods();

	public static DAOMethods getInstance() {
		return singleDAO;
	}

	/**
	 * Returns Password and id of given user
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public AuthenticatePojo getPassword(String email) throws SQLException, ClassNotFoundException {
		Connection connectionToDB = ConnectionToDB.getConnection();
		PreparedStatement statement = connectionToDB.prepareStatement(EmployeeQueries.getQueryOne());
		statement.setString(1, email);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			return new AuthenticatePojo(result.getInt(1), result.getString(2));
		}
		return null;
	}

	/**
	 * Adds user in Database
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param contactNo
	 * @param email
	 * @param password
	 * @param organization
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean addUser(String firstName, String lastName, Date dateOfBirth, String contactNo, String email,
			String password, String organization) throws ClassNotFoundException, SQLException {
		Connection connectionToDB = ConnectionToDB.getConnection();
		PreparedStatement statement = connectionToDB.prepareStatement(EmployeeQueries.getQueryTwo());
		statement.setString(1, firstName);
		statement.setString(2, lastName);
		statement.setDate(3, dateOfBirth);
		statement.setString(4, contactNo);
		statement.setString(5, email);
		statement.setString(6, password);
		statement.setString(7, organization);
		int i = statement.executeUpdate();
		if (i > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Retrieves Information of a given User
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UserInfoPojo getUser(int id) throws ClassNotFoundException, SQLException {
		Connection connectionToDB = ConnectionToDB.getConnection();
		PreparedStatement statement = connectionToDB.prepareStatement(EmployeeQueries.getQueryThree());
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			return new UserInfoPojo(result.getString(2), result.getString(3), result.getDate(4), result.getString(5),
					result.getString(6), result.getString(8));
		}
		return null;
	}

	/**
	 * Updates Information of a given user
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param contactNo
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean updateUser(String firstName, String lastName, Date dateOfBirth, String contactNo, int id)
			throws ClassNotFoundException, SQLException {
		Connection connectionToDB = ConnectionToDB.getConnection();
		PreparedStatement statement = connectionToDB.prepareStatement(EmployeeQueries.getQueryFour());
		statement.setString(1, firstName);
		statement.setString(2, lastName);
		statement.setDate(3, dateOfBirth);
		statement.setString(4, contactNo);
		statement.setInt(5, id);
		int i = statement.executeUpdate();
		if (i > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the List of Friends of a Given User
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<FriendInfoPojo> getFriends(int id) throws SQLException, ClassNotFoundException {
		Connection connectionToDB = ConnectionToDB.getConnection();
		List<FriendInfoPojo> friendsList = new ArrayList<FriendInfoPojo>();
		PreparedStatement statement = connectionToDB.prepareStatement(EmployeeQueries.getQueryFive());
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			if (result.getInt(1) != id) {
				friendsList.add(new FriendInfoPojo(result.getInt(1), result.getString(2), result.getString(3)));
			}
		}
		return friendsList;
	}
}
