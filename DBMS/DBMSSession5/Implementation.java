package GET2018.DBMS.DBMSSession5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements different methods on StoreFront Database
 * 
 * @author Mohit Sharma
 *
 */
public class Implementation {
	private Connection connectionToDB;

	public Implementation() throws ClassNotFoundException, SQLException {
		connectionToDB = ConnectionToDB.getConnection();
	}

	/**
	 * Returns List of Orders which are shipped and placed by userId
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public List<OrderDetail> orderDetailsOfShippedOrder(String userId) throws SQLException {
		if (userId == null) {
			throw new NullPointerException("userId can't be Null");
		}
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		try {
			PreparedStatement statement = connectionToDB.prepareStatement(StoreFrontQueries.getQueryOne(userId));
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				orderDetailList.add(new OrderDetail(result.getInt(1), result.getDate(2), result.getDouble(3)));
			}
		} catch (SQLException ex) {
			throw new SQLException();
		}
		return orderDetailList;
	}

	/**
	 * Inserts Images for given Ids
	 * 
	 * @param id
	 * @param images
	 * @return
	 * @throws StoreFrontException
	 */
	public int insertImagesOfProducts(int[] ids, String[] images) throws StoreFrontException {
		if (ids == null || images == null) {
			throw new NullPointerException("Id or Images Can't be Null");
		}
		if (ids.length != images.length) {
			throw new StoreFrontException("Id and Images length are not Equal");
		}
		try {
			PreparedStatement statement = connectionToDB.prepareStatement(StoreFrontQueries.getQueryTwo());
			try {
				connectionToDB.setAutoCommit(false);
				for (int i = 0; i < ids.length; i++) {
					statement.setInt(1, ids[i]);
					statement.setString(2, images[i]);
					statement.addBatch();
				}
				int[] result = statement.executeBatch();
				connectionToDB.commit();
				return result.length;
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				connectionToDB.rollback();
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return -1;
	}

	/**
	 * Returns No Of Deleted Products that are not Ordered in Last One Year
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int deleteProductsNotOrdered() throws SQLException {
		int deletedProducts = 0;
		try {
			connectionToDB.setAutoCommit(false);
			PreparedStatement statement = connectionToDB.prepareStatement(StoreFrontQueries.getQueryThree());
			deletedProducts = statement.executeUpdate();
			connectionToDB.commit();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			connectionToDB.rollback();
		}
		return deletedProducts;
	}

	/**
	 * Returns List of Top categories along with their No Of Child Categories
	 * 
	 * @return
	 */
	public List<CategoryDetail> categoryDetail() {
		// List to Save the Result i.e., TopMost CAtegory and No Of Child
		List<CategoryDetail> categoryDetailList = new ArrayList<CategoryDetail>();

		// List to save the Result of Query i.e., All Categories
		List<Categories> categoriesList = new ArrayList<Categories>();
		try {
			PreparedStatement statement = connectionToDB.prepareStatement(StoreFrontQueries.getQueryFour());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				categoriesList.add(new Categories(result.getString(1), result.getInt(2), result.getInt(3)));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// Iterating Only Topmost Categories
		for (int i = 0; i < categoriesList.size(); i++) {
			Categories child = categoriesList.get(i);

			// For Topmost Categories ParentId is Zero
			if (child.getParentId() == 0) {
				List<Integer> childCategoryId = new ArrayList<Integer>();
				childCategoryId.add(child.getCategoryId());

				// Iterating Child Categories of Parent
				for (int j = i + 1, k = 0; k != childCategoryId.size();) {
					if (j == categoriesList.size() && k < childCategoryId.size()) {
						j = i + 1;
						k++;
					} else if (categoriesList.get(j).getParentId() == childCategoryId.get(k)) {
						childCategoryId.add(categoriesList.get(j).getCategoryId());
						j++;
					} else {
						j++;
					}
				}
				categoryDetailList.add(new CategoryDetail(child.getCategoryName(), childCategoryId.size() - 1));
			}
		}
		return categoryDetailList;
	}
}
