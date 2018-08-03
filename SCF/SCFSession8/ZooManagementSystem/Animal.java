package GET2018.SCF.SCFSession8.ZooManagementSystem;

/**
 * This class is SuperClass for all Animals in Zoo
 * 
 * @author Mohit Sharma
 *
 */
public class Animal {
	protected String animalName;
	protected int ageOfAnimal;
	protected double weightOfAnimal;
	protected String soundOfAnimal;
	protected AnimalCategory categoryOfAnimal;
	protected int cageNo;

	public int getAgeOfAnimal() {
		return ageOfAnimal;
	}

	public String getAnimalName() {
		return animalName;
	}

	public AnimalCategory getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	public String getSoundOfAnimal() {
		return soundOfAnimal;
	}

	public double getWeightOfAnimal() {
		return weightOfAnimal;
	}

	public int getCageNo() {
		return cageNo;
	}

	public void setCageNo(int cageNo) {
		this.cageNo = cageNo;
	}
}

enum AnimalCategory {
	Mammal, Reptile, Bird;
}

enum AnimalType {
	Peacook, Parrot, Raven, Lion, Deer, Zebra, Snake, Alligator;
}
