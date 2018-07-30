package GET2018.SCF.SCFSession8.ZooManagementSystem;

import java.util.List;
import java.util.ArrayList;

/**
 * This class serves as Implementation class for this Package
 * 
 * @author Mohit Sharma
 *
 */
public class Zoo {
	public static List<Zone> zoneList = new ArrayList<>();
	public static List<Cage> cageList = new ArrayList<>();
	public static List<Animal> animalList = new ArrayList<>();

	public Zoo() {
		init();
	}

	/**
	 * Prints the all the Animal Names in Zoo
	 */
	void getInfo() {
		for (int i = 0; i < animalList.size(); i++) {
			System.out.println(animalList.get(i).getAnimalName() + "hi");
		}
	}

	/**
	 * Adds Zone in Zoo
	 * 
	 * @param maxNoOfCages
	 * @param categoryOfAnimal
	 * @param hasCanteen
	 * @param hasPark
	 * @return
	 */
	boolean addZone(int maxNoOfCages, String categoryOfAnimal,
			boolean hasCanteen, boolean hasPark) {
		if (categoryOfAnimal == null || categoryOfAnimal.length() == 0) {
			throw new NullPointerException(
					"Category Of Animal in Zone Can't be Null or Zero");
		}
		Zone newZone = new Zone(maxNoOfCages, categoryOfAnimal, hasCanteen,
				hasPark);
		zoneList.add(newZone);
		return true;
	}

	/**
	 * Adds Cage in the given Zone if Space is Available
	 * 
	 * @param typeOfAnimal
	 * @param zoneNo
	 * @param maxNoOfAnimals
	 * @return
	 * @throws ZooException
	 */
	boolean addCage(String typeOfAnimal, int zoneNo, int maxNoOfAnimals)
			throws ZooException {
		if (typeOfAnimal == null || typeOfAnimal.length() == 0) {
			throw new NullPointerException(
					"Category Of Animal in Cage Can't be Null or Zero");
		}

		/*
		 * Checking the TypeOfAnimal in Cage is in the Zone's Category of Animal
		 * i.e., Checking whether we're adding Lion in Mammal Zone only
		 */
		if (typeOfAnimal.equals("Lion") || typeOfAnimal.equals("Deer")
				|| typeOfAnimal.equals("Zebra")) {
			if (zoneList.get(zoneNo - 1).getCategoryOfAnimal() != "Mammal") {
				return false;
			}
		} else if (typeOfAnimal.equals("Parrot")
				|| typeOfAnimal.equals("Peacook")
				|| typeOfAnimal.equals("Raven")) {
			if (zoneList.get(zoneNo - 1).getCategoryOfAnimal() != "Bird") {
				return false;
			}
		} else if (typeOfAnimal.equals("Alligator")
				|| typeOfAnimal.equals("Snake")) {
			if (zoneList.get(zoneNo - 1).getCategoryOfAnimal() != "Reptile") {
				return false;
			}
		}

		int noOfCages = 0;
		for (int i = 0; i < cageList.size(); i++) {
			if (cageList.get(i).getZoneNo() == zoneNo) {
				noOfCages++;
			}
		}

		/*
		 * Checking the Space Availability of Cage in given Zone
		 */
		if (noOfCages == zoneList.get(zoneNo - 1).maxNoOfCages) {
			throw new ZooException("Zone is Full");
		}

		Cage newCage = new Cage(0, typeOfAnimal, zoneNo, maxNoOfAnimals);
		cageList.add(newCage);
		return true;
	}

	/**
	 * Adds Animal to given CageNo
	 * 
	 * @param animalName
	 * @param typeOfAnimal
	 * @param ageOfAnimal
	 * @param weightOfAnimal
	 * @param cageNo
	 * @return
	 * @throws ZooException
	 */
	boolean addAnimal(String animalName, String typeOfAnimal, int ageOfAnimal,
			double weightOfAnimal, int cageNo) throws ZooException {
		if (typeOfAnimal == null || animalName == null
				|| typeOfAnimal.length() == 0 || animalName.length() == 0) {
			throw new NullPointerException(
					"Category Of Animal or Name of Animal Can't be Null or Zero");
		}

		/*
		 * Checking whether Cage is full or not and the Specified Cage is of the
		 * same TypeOfAnimal given
		 */
		if (typeOfAnimal == cageList.get(cageNo - 1).typeOfAnimal) {
			if (cageList.get(cageNo - 1).getMaxNoOfAnimals() == cageList.get(
					cageNo - 1).getNoOfAnimals()) {
				throw new ZooException("Cage is Full, Can't add more animals");
			}
		} else {
			throw new ZooException(
					"This cage is not for the given type of Animal");
		}

		/*
		 * Adding Animal in List and increasing NoOfAnimals in Cage
		 */
		int noOfAnimalsInCage = cageList.get(cageNo - 1).getNoOfAnimals();
		switch (typeOfAnimal) {
		case "Lion":
			animalList.add(new Lion(animalName, ageOfAnimal, weightOfAnimal,
					cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;

		case "Zebra":
			animalList.add(new Zebra(animalName, ageOfAnimal, weightOfAnimal,
					cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;

		case "Deer":
			animalList.add(new Deer(animalName, ageOfAnimal, weightOfAnimal,
					cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;

		case "Parrot":
			animalList.add(new Parrot(animalName, ageOfAnimal, weightOfAnimal,
					cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;

		case "Peacook":
			animalList.add(new Peacook(animalName, ageOfAnimal, weightOfAnimal,
					cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;

		case "Raven":
			animalList.add(new Raven(animalName, ageOfAnimal, weightOfAnimal,
					cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;

		case "Alligator":
			animalList.add(new Alligator(animalName, ageOfAnimal,
					weightOfAnimal, cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;

		case "Snake":
			animalList.add(new Snake(animalName, ageOfAnimal, weightOfAnimal,
					cageNo));
			cageList.get(cageNo - 1).setNoOfAnimals(noOfAnimalsInCage++);
			break;
		}
		return true;

	}

	/**
	 * Removes Animal after its Death
	 * 
	 * @param animalName
	 */
	void deathOfAnimal(String animalName) {
		if (animalName == null || animalName.length() == 0) {
			throw new NullPointerException(
					"Name of Animal Can't be Null or Zero");
		}
		int cageNo = -1;
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i).getAnimalName().equals(animalName)) {
				cageNo = animalList.get(i).getCageNo();
				animalList.remove(i);
			}
		}
		cageList.get(cageNo).setNoOfAnimals(
				cageList.get(cageNo).getNoOfAnimals() - 1);
	}

	void init() {
		zoneList.clear();
		animalList.clear();
		cageList.clear();

		zoneList.add(new Zone(5, "Mammal", true, false));
		zoneList.add(new Zone(3, "Birds", true, true));
		zoneList.add(new Zone(2, "Reptile", false, false));

		cageList.add(new Cage(3, "Lion", 1, 5));
		cageList.add(new Cage(2, "Deer", 1, 5));
		cageList.add(new Cage(3, "Parrot", 2, 5));
		cageList.add(new Cage(2, "Raven", 2, 2));
		cageList.add(new Cage(2, "Alligator", 3, 5));
		cageList.add(new Cage(3, "Snake", 3, 10));

		animalList.add(new Lion("Lion-1", 5, 80, 1));
		animalList.add(new Lion("Lion-2", 15, 152, 1));
		animalList.add(new Lion("Lion-3", 10, 102, 1));
		animalList.add(new Deer("Deer-1", 2, 20, 2));
		animalList.add(new Deer("Deer-2", 7, 70, 2));
		animalList.add(new Parrot("Parrot-1", 8, 1, 3));
		animalList.add(new Parrot("Parrot-2", 10, 1.5, 3));
		animalList.add(new Parrot("Parrot-3", 12, 2, 3));
		animalList.add(new Raven("Raven-1", 8, 20, 4));
		animalList.add(new Raven("Raven-2", 9, 25, 4));
		animalList.add(new Alligator("Alligator-1", 15, 200, 5));
		animalList.add(new Alligator("Alligator-2", 20, 250, 5));
		animalList.add(new Snake("Snake-1", 2, 5, 6));
		animalList.add(new Snake("Snake-2", 3, 10.5, 6));
		animalList.add(new Snake("Snake-3", 5, 50, 6));
	}

	@SuppressWarnings("serial")
	static class ZooException extends Exception {
		String messageException;

		public ZooException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
