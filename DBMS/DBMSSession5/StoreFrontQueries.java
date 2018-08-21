package GET2018.DBMS.DBMSSession5;

/**
 * This class stores various Queries on database
 * 
 * @author Mohit Sharma
 *
 */
public class StoreFrontQueries {
	private static String query1;
	private static String query2;
	private static String query3;
	private static String query4;

	/**
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of
	 * that user which are in shipped state. Orders should be sorted by order
	 * date column in chronological order.
	 * 
	 * @param userID
	 */
	public static void setQuery1(String userID) {
		StoreFrontQueries.query1 = "SELECT order_details.order_id, date_of_order, SUM(price) "
				+ "FROM order_details INNER JOIN items_ordered INNER JOIN users ON "
				+ "order_details.order_id = items_ordered.order_id AND "
				+ "order_details.email = users.email "
				+ "WHERE users.email = '"
				+ userID
				+ "' AND  "
				+ "items_ordered.order_status = 'Shipped' "
				+ "GROUP BY order_details.order_id" + " ORDER BY date_of_order";
	}

	/**
	 * Insert five or more images of a product using batch insert technique.
	 */
	public static void setQuery2() {
		StoreFrontQueries.query2 = "INSERT INTO images(product_id, image_url) VALUES(?,?)";
	}

	/**
	 * Delete all those products which were not ordered by any Shopper in last 1
	 * year.
	 */
	public static void setQuery3() {
		StoreFrontQueries.query3 = "DELETE FROM products "
				+ "WHERE product_id NOT IN(" + "SELECT product_id "
				+ "FROM items_ordered INNER JOIN order_details ON "
				+ "items_ordered.order_id = order_details.order_id "
				+ "WHERE date_of_order >= DATE_SUB(NOW(), INTERVAL 1 YEAR))";
	}

	/**
	 * Select and display the category title of all top parent categories sorted
	 * alphabetically and the count of their child categories.
	 */
	public static void setQuery4() {
		StoreFrontQueries.query4 = "SELECT * FROM storefront.categories";
	}

	public static String getQuery1() {
		return query1;
	}

	public static String getQuery2() {
		return query2;
	}

	public static String getQuery3() {
		return query3;
	}

	public static String getQuery4() {
		return query4;
	}
}
