package GET2018.DBMS.DBMSSession5;

/**
 * This class contains Top Category Detail
 * 
 * @author Mohit Sharma
 *
 */
public class CategoryDetail {
	private String categoryName;
	private int noOfChilds;

	public CategoryDetail(String categoryName, int noOfChilds) {
		this.categoryName = categoryName;
		this.noOfChilds = noOfChilds;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getNoOfChilds() {
		return noOfChilds;
	}
}
