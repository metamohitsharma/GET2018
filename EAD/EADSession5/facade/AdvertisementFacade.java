package GET2018.EAD.EADSession5.facade;

import java.util.List;

import GET2018.EAD.EADSession5.dao.AdvertisementDao;
import GET2018.EAD.EADSession5.dao.CategoryDao;
import GET2018.EAD.EADSession5.dao.Status;
import GET2018.EAD.EADSession5.model.Advertisement;
import GET2018.EAD.EADSession5.model.Category;

/**
 * This class contains Businees Logic for Advertisement
 * 
 * @author Mohit Sharma
 *
 */
public class AdvertisementFacade {
	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();
	private AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
	private CategoryDao categoryDao = CategoryDao.getInstance();

	public static AdvertisementFacade getInstance() {
		return advertisementFacade;
	}

	/**
	 * Insert Advertisement
	 * 
	 * @param category_id
	 * @param title
	 * @param description
	 * @return
	 */
	public Status insertAdvertisement(int category_id, String title, String description) {
		Advertisement advertisement = new Advertisement();
		advertisement.setCategoryId(category_id);
		advertisement.setTitle(title);
		advertisement.setDescription(description);
		List<Advertisement> advertisementList = advertisementDao.getAll();
		List<Category> categoryList = categoryDao.getAll();
		for (Advertisement advert : advertisementList) {
			if (advert.getTitle().equals(advertisement.getTitle())) {
				return Status.DUPLICATE;
			}
		}
		for (Category category : categoryList) {
			if (category.getId() == advertisement.getCategoryId()) {
				advertisementDao.insert(advertisement);
				return Status.INSERTED;
			}
		}
		return Status.INVALID;
	}

	/**
	 * Gets the list of Advertisements
	 * 
	 * @return list
	 */
	public List<Advertisement> getAll() {
		return advertisementDao.getAll();
	}

	/**
	 * Get the list of Advertisements by Id
	 * 
	 * @param id
	 * @return list of advertisement
	 */
	public List<Advertisement> getById(int id) {
		return advertisementDao.getById(id);
	}

	/**
	 * Return the status of Updated Advertisement
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public Status updateName(String name, int id) {
		Status status = advertisementDao.updateName(name, id);
		if (Status.UPDATED.equals(status)) {
			return Status.UPDATED;
		}
		return Status.NOT_UPDATED;
	}

	/**
	 * Returns the status of Deleted Advertisement
	 * 
	 * @param id
	 * @return
	 */
	public Status deleteAdvertisement(int id) {
		List<Advertisement> advertisementList = advertisementDao.getAll();
		for (Advertisement advert : advertisementList) {
			if (advert.getId() == id) {
				advertisementDao.deleteAdvertisement(id);
				return Status.DELETED;
			}
		}
		return Status.NOT_DELETED;
	}
}
