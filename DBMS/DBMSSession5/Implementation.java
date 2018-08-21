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
	 * Returns List of Orders which are shipped and placed by userID
	 * 
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public List<OrderDetail> orderDetailsOfShippedOrder(String userID)
			throws SQLException {
		if (userID == null) {
			throw new NullPointerException("userID can't be Null");
		}
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		try {
			StoreFrontQueries.setQuery1(userID);
			PreparedStatement statement = connectionToDB
					.prepareStatement(StoreFrontQueries.getQuery1());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				orderDetailList.add(new OrderDetail(result.getInt(1), result
						.getDate(2), result.getDouble(3)));
			}
		} catch (SQLException ex) {
			throw new SQLException("Hello");
		}
		return orderDetailList;
	}

	/**
	 * Inserts Images for given IDs
	 * 
	 * @param id
	 * @param images
	 * @return
	 * @throws StoreFrontException
	 */
	public int insertImagesOfProducts(int[] id, String[] images)
			throws StoreFrontException {
		if (id == null || images == null) {
			throw new NullPointerException("ID or Images Can't be Null");
		}
		if (id.length != images.length) {
			throw new StoreFrontException("ID and Images length are not Equal");
		}
		try {
			StoreFrontQueries.setQuery2();
			PreparedStatement statement = connectionToDB
					.prepareStatement(StoreFrontQueries.getQuery2());
			try {
				connectionToDB.setAutoCommit(false);
				for (int i = 0; i < id.length; i++) {
					statement.setInt(1, id[i]);
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
			StoreFrontQueries.setQuery3();
			PreparedStatement statement = connectionToDB
					.prepareStatement(StoreFrontQueries.getQuery3());
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
			StoreFrontQueries.setQuery4();
			PreparedStatement statement = connectionToDB
					.prepareStatement(StoreFrontQueries.getQuery4());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				categoriesList.add(new Categories(result.getString(1), result
						.getInt(2), result.getInt(3)));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// Iterating Only Topmost Categories
		for (int i = 0; i < categoriesList.size(); i++) {
			Categories child = categoriesList.get(i);

			// For Topmost Categories ParentID is Zero
			if (child.getParentID() == 0) {
				List<Integer> childCategoryID = new ArrayList<Integer>();
				childCategoryID.add(child.getCategoryID());

				// Iterating Child Categories of Parent
				for (int j = i + 1, k = 0; k != childCategoryID.size();) {
					if (j == categoriesList.size()
							&& k < childCategoryID.size()) {
						j = i + 1;
						k++;
					} else if (categoriesList.get(j).getParentID() == childCategoryID
							.get(k)) {
						childCategoryID.add(categoriesList.get(j)
								.getCategoryID());
						j++;
					} else {
						j++;
					}
				}
				categoryDetailList.add(new CategoryDetail(child
						.getCategoryName(), childCategoryID.size() - 1));
			}
		}
		return categoryDetailList;
	}
}
