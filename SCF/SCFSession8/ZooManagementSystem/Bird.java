package GET2018.SCF.SCFSession8.ZooManagementSystem;

/**
 * This is a SubClass of Animal, this class Specifies the Category of Animal
 * i.e., Bird
 * 
 * @author Mohit Sharma
 *
 */
public class Bird extends Animal {
	final AnimalCategory categoryOfAnimal = AnimalCategory.Bird;

	@Override
	public AnimalCategory getCategoryOfAnimal() {
		return categoryOfAnimal;
	}
}

/**
 * This is a SubClass of Bird, this Specifies the Type of Animal i.e., Parrot
 * 
 * @author Mohit Sharma
 *
 */
class Parrot extends Bird {
	final String animalName;
	final String soundOfAnimal = "Sqauwk";

	Parrot(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}

/**
 * This is a SubClass of Bird, this Specifies the Type of Animal i.e., Peacook
 * 
 * @author Mohit Sharma
 *
 */
class Peacook extends Bird {
	final String animalName;
	final String soundOfAnimal = "Scream";

	Peacook(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}

/**
 * This is a SubClass of Bird, this Specifies the Type of Animal i.e., Raven
 * 
 * @author Mohit Sharma
 *
 */
class Raven extends Bird {
	final String animalName;
	final String soundOfAnimal = "Caw";

	Raven(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}
