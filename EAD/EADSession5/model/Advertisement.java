package GET2018.EAD.EADSession5.model;

/**
 * This class contains Advertisement Properties
 * 
 * @author Mohit Sharma
 *
 */
public class Advertisement extends BaseEntity {

	private String title;
	private String description;
	private int categoryId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int category_id) {
		this.categoryId = category_id;
	}
}
