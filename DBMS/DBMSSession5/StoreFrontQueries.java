package GET2018.DBMS.DBMSSession5;

/**
 * This class stores various Queries on database
 * 
 * @author Mohit Sharma
 *
 */
public class StoreFrontQueries {

	/**
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of
	 * that user which are in shipped state. Orders should be sorted by order date
	 * column in chronological order.
	 * 
	 * @param userID
	 */
	public static String getQueryOne(String userID) {
		return "SELECT order_details.order_id, date_of_order, SUM(price) "
				+ "FROM order_details INNER JOIN items_ordered INNER JOIN users ON "
				+ "order_details.order_id = items_ordered.order_id AND " + "order_details.email = users.email "
				+ "WHERE users.email = '" + userID + "' AND  " + "items_ordered.order_status = 'Shipped' "
				+ "GROUP BY order_details.order_id" + " ORDER BY date_of_order";
	}

	/**
	 * Insert five or more images of a product using batch insert technique.
	 */
	public static String getQueryTwo() {
		return "INSERT INTO images(product_id, image_url) VALUES(?,?)";
	}

	/**
	 * Delete all those products which were not ordered by any Shopper in last 1
	 * year.
	 */
	public static String getQueryThree() {
		return "DELETE FROM products " + "WHERE product_id NOT IN(" + "SELECT product_id "
				+ "FROM items_ordered INNER JOIN order_details ON " + "items_ordered.order_id = order_details.order_id "
				+ "WHERE date_of_order >= DATE_SUB(NOW(), INTERVAL 1 YEAR))";
	}

	/**
	 * Select and display the category title of all top parent categories sorted
	 * alphabetically and the count of their child categories.
	 */
	public static String getQueryFour() {
		return "SELECT * FROM storefront.categories";
	}
}
