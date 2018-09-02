package GET2018.EAD.EADSession4.Facade;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import GET2018.EAD.EADSession4.DAO.DAOMethods;
import GET2018.EAD.EADSession4.Model.AuthenticatePojo;
import GET2018.EAD.EADSession4.Model.FriendInfoPojo;
import GET2018.EAD.EADSession4.Model.UserInfoPojo;

/**
 * This class is an interface between Servlets and DAO
 * 
 * @author Mohit Sharma
 *
 */
public class Facade {
	private static Facade singletonFacade = new Facade();
	private DAOMethods dao = DAOMethods.getInstance();

	public static Facade getInstance() {
		return singletonFacade;
	}

	/**
	 * Authenticates User
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int authenticateUser(String email, String password) throws ClassNotFoundException, SQLException {
		AuthenticatePojo authenticateUser = dao.getPassword(email);
		try {
			if (authenticateUser.getPassword().equals(password)) {
				return authenticateUser.getId();
			}
		} catch (NullPointerException ex) {
			return 0;
		}
		return 0;
	}

	/**
	 * Registers a new User
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
	public boolean registerUser(String firstName, String lastName, Date dateOfBirth, String contactNo, String email,
			String password, String organization) throws ClassNotFoundException, SQLException {
		if (dao.addUser(firstName, lastName, dateOfBirth, contactNo, email, password, organization)) {
			return true;
		}
		return false;
	}

	/**
	 * Gets Information of a given User
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UserInfoPojo getUserInfo(int id) throws ClassNotFoundException, SQLException {
		return dao.getUser(id);
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
	public boolean updateUserInfo(String firstName, String lastName, Date dateOfBirth, String contactNo, int id)
			throws ClassNotFoundException, SQLException {
		dao.updateUser(firstName, lastName, dateOfBirth, contactNo, id);
		return true;
	}

	/**
	 * Returns a list of Friends of a Given User
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<FriendInfoPojo> getFriends(int id) throws ClassNotFoundException, SQLException {
		return dao.getFriends(id);
	}
}
