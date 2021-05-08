package GET2018.EAD.EADSession5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import GET2018.EAD.EADSession5.model.Advertisement;

/**
 * Data Access Object for Advertisement
 * 
 * @author Mohit Sharma
 *
 */
public class AdvertisementDao {
	private static AdvertisementDao mysqlAdvertisementDao = new AdvertisementDao();

	public static AdvertisementDao getInstance() {
		return mysqlAdvertisementDao;
	}

	/**
	 * Create New Advertisement in Database
	 * 
	 * @param advertisement
	 */
	public Status insert(Advertisement advertisement) {
		String query = Query.getInsertNewAdvertisement();
		try (Connection conn = ConnectionToDB.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, advertisement.getTitle());
			preparedStatement.setString(2, advertisement.getDescription());
			preparedStatement.setInt(3, advertisement.getCategoryId());
			if (preparedStatement.executeUpdate() == 0) {
				return Status.NOT_INSERTED;
			}
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}
		return Status.INSERTED;
	}

	/**
	 * Returns all the Advertisements
	 * 
	 * @return list of advertisement
	 */
	public List<Advertisement> getAll() {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();
		String query = Query.getSelectAllAdvertisement();
		ResultSet resultSet = null;
		try (Connection conn = ConnectionToDB.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Advertisement advertisement = new Advertisement();
				advertisement.setId(resultSet.getInt("advertisement_id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategoryId(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return advertisementList;
	}

	/**
	 * Returns Advertisement list by Id
	 * 
	 * @param id
	 * @return list of advertisement
	 */
	public List<Advertisement> getById(int id) {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();
		String query = Query.getSelectAllAdvertisementAyCategoryId();
		ResultSet resultSet = null;
		try (Connection conn = ConnectionToDB.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Advertisement advertisement = new Advertisement();
			while (resultSet.next()) {
				advertisement.setId(resultSet.getInt("advertisement_id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategoryId(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return advertisementList;
	}

	/**
	 * Updates the Name of the Advertisement
	 * 
	 * @param name
	 * @param id
	 */
	public Status updateName(String name, int id) {
		String query = Query.getUpdateAdvertisementName();
		try (Connection conn = ConnectionToDB.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			if (preparedStatement.executeUpdate() == 0) {
				return Status.NOT_UPDATED;
			}
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}
		return Status.UPDATED;
	}

	/**
	 * Deletes the Advertisement by Id
	 * 
	 * @param id
	 */
	public Status deleteAdvertisement(int id) {
		String query = Query.getDeleteAdvertisementById();
		try (Connection conn = ConnectionToDB.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			if (preparedStatement.executeUpdate() == 0) {
				return Status.NOT_DELETED;
			}
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}
		return Status.DELETED;
	}
}
