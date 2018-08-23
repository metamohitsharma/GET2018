package GET2018.DBMS.DBMSSession5;

/**
 * This class stores Categories information used in Database
 * 
 * @author Mohit Sharma
 *
 */
public class Categories {
	private String categoryName;
	private int categoryId;
	private int parentId;

	public Categories(String categoryName, int categoryId, int parentId) {
		this.categoryName = categoryName;
		this.categoryId = categoryId;
		this.parentId = parentId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getParentId() {
		return parentId;
	}
}
