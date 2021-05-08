package GET2018.EAD.EADSession5.dao;

/**
 * This class contains different Queries to be implemented on Database
 * 
 * @author Mohit Sharma
 *
 */
public class Query {

	public static String getInsertNewCategory() {
		return "INSERT INTO category(name) VALUES(?)";
	}

	public static String getSelectAllCategories() {
		return "SELECT * FROM category";
	}

	public static String getInsertNewAdvertisement() {
		return "INSERT INTO advertisement (title, description , category_id) " + "VALUES (?,?,?)";
	}

	public static String getSelectAllAdvertisement() {
		return "SELECT * FROM advertisement";
	}

	public static String getSelectAllAdvertisementAyCategoryId() {
		return "SELECT * FROM advertisement WHERE category_id=?";
	}

	public static String getUpdateAdvertisementName() {
		return "UPDATE advertisement SET title = ? WHERE advertisement_id=?";
	}

	public static String getUpdateCategoryName() {
		return "UPDATE category SET name = ? WHERE category_id=?";
	}

	public static String getDeleteAdvertisementById() {
		return "DELETE FROM advertisement WHERE advertisement_id=?";
	}

}
