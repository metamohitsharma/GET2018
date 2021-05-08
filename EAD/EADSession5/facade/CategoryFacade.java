package GET2018.EAD.EADSession5.facade;

import java.util.List;
import GET2018.EAD.EADSession5.dao.*;
import GET2018.EAD.EADSession5.model.Category;

/**
 * This class contains the Business Logic for Category
 * 
 * @author Mohit Sharma
 *
 */
public class CategoryFacade {

	private static CategoryFacade categoryFacade = new CategoryFacade();

	private CategoryDao categoryDao = CategoryDao.getInstance();

	public static CategoryFacade getInstance() {
		return categoryFacade;
	}

	/**
	 * Insert Category to Database
	 * 
	 * @param name
	 * @return status
	 */
	public Status insertCategory(String name) {
		List<Category> categoryList = categoryDao.getAll();

		for (Category category : categoryList) {
			if (category.getName().equals(name)) {
				return Status.DUPLICATE;
			}
		}
		Status status = categoryDao.insert(name);
		if (Status.INSERTED.equals(status)) {
			return Status.INSERTED;
		}
		return Status.NOT_INSERTED;
	}

	/**
	 * Return the List of Categories
	 * 
	 * @return
	 */
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	/**
	 * Return the Status for updated Category
	 * 
	 * @param category
	 * @param id
	 * @return status
	 */
	public Status updateCategory(String category, int id) {
		Status status = categoryDao.updateCategory(category, id);
		if (Status.UPDATED.equals(status)) {
			return Status.UPDATED;
		}
		return Status.NOT_UPDATED;
	}
}