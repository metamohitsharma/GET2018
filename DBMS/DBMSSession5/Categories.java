package GET2018.DBMS.DBMSSession5;

/**
 * This class stores Categories information used in Database
 * 
 * @author Mohit Sharma
 *
 */
public class Categories {
	private String categoryName;
	private int categoryID;
	private int parentID;

	public Categories(String categoryName, int categoryID, int parentID) {
		this.categoryName = categoryName;
		this.categoryID = categoryID;
		this.parentID = parentID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getParentID() {
		return parentID;
	}
}
