package GET2018.SCF.SCFSession8.ZooManagementSystem;

/**
 * This class creates a New Zone
 * 
 * @author Mohit Sharma
 *
 */
public class Zone {
	final int maxNoOfCages;
	final AnimalCategory categoryOfAnimal;
	boolean hasCanteen;
	boolean hasPark;

	public Zone(int maxNoOfCages, AnimalCategory categoryOfAnimal, boolean hasCanteen, boolean hasPark) {
		this.maxNoOfCages = maxNoOfCages;
		this.categoryOfAnimal = categoryOfAnimal;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}

	public AnimalCategory getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	public int getMaxNoOfCages() {
		return maxNoOfCages;
	}

	/**
	 * Returns the Total No of Animals in Zone
	 * 
	 * @param zoneNo
	 * @return
	 */
	int getInfo(int zoneNo) {
		int totalNoOfAnimals = 0;
		for (int i = 0; i < Zoo.cageList.size(); i++) {
			if (zoneNo == Zoo.cageList.get(i).getZoneNo()) {
				totalNoOfAnimals += Zoo.cageList.get(i).getNoOfAnimals();
			}
		}
		return totalNoOfAnimals;
	}

}
