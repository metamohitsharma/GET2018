package GET2018.EAD.EADSession5.dao;

import GET2018.EAD.EADSession5.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Category
 * 
 * @author Mohit Sharma
 *
 */
public class CategoryDao {

	private static CategoryDao categoryDao = new CategoryDao();

	public static CategoryDao getInstance() {
		return categoryDao;
	}

	/**
	 * Returns all the categories
	 * 
	 * @return list of categories
	 */
	public List<Category> getAll() {
		List<Category> categoryList = new ArrayList<Category>();
		String query = Query.getSelectAllCategories();
		ResultSet resultSet = null;
		try (Connection conn = ConnectionToDB.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt("category_id"));
				category.setName(resultSet.getString("name"));
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	/**
	 * Insert the Category in Database
	 * 
	 * @param name
	 */
	public Status insert(String name) {
		String query = Query.getInsertNewCategory();
		try (Connection conn = ConnectionToDB.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			if (preparedStatement.executeUpdate() == 0) {
				return Status.NOT_INSERTED;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Status.INSERTED;
	}

	/**
	 * Update the Name of the Category
	 * 
	 * @param name
	 * @param id
	 */
	public Status updateCategory(String category, int id) {
		String query = Query.getUpdateCategoryName();
		try (Connection conn = ConnectionToDB.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, id);
			if (preparedStatement.executeUpdate() == 0) {
				return Status.NOT_UPDATED;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Status.UPDATED;
	}
}
