package GET2018.SCF.SCFSession8.ZooManagementSystem;

/**
 * This class creates a New Cage in provided ZoneNo
 * 
 * @author Mohit Sharma
 *
 */
public class Cage {
	int noOfAnimals;
	final AnimalType typeOfAnimal;
	final int zoneNo;
	final int maxNoOfAnimals;

	public Cage(int noOfAnimals, AnimalType typeOfAnimal, int zoneNo, int maxNoOfAnimals) {
		this.noOfAnimals = noOfAnimals;
		this.typeOfAnimal = typeOfAnimal;
		this.zoneNo = zoneNo;
		this.maxNoOfAnimals = maxNoOfAnimals;
	}

	/**
	 * Prints the Animal Names in the Cage
	 * 
	 * @param cageNo
	 */
	void getInfo(int cageNo) {
		for (int i = 0; i < Zoo.animalList.size(); i++) {
			if (Zoo.animalList.get(i).getCageNo() == cageNo) {
				System.out.println(Zoo.animalList.get(i).getAnimalName());
			}
		}
	}

	public void setNoOfAnimals(int noOfAnimals) {
		this.noOfAnimals = noOfAnimals;
	}

	public int getMaxNoOfAnimals() {
		return maxNoOfAnimals;
	}

	public int getNoOfAnimals() {
		return noOfAnimals;
	}

	public AnimalType getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public int getZoneNo() {
		return zoneNo;
	}
}
