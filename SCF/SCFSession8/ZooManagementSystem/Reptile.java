package GET2018.SCF.SCFSession8.ZooManagementSystem;

/**
 * This is a SubClass of Animal, this class Specifies the Category of Animal
 * i.e., Reptile
 * 
 * @author Mohit Sharma
 *
 */
public class Reptile extends Animal {
	final String categoryOfAnimal = "Reptile";

	@Override
	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}
}

/**
 * This is a SubClass of Reptile, this Specifies the Type of Animal i.e.,
 * Alligator
 * 
 * @author Mohit Sharma
 *
 */
class Alligator extends Reptile {
	final String animalName;
	final String soundOfAnimal = "Growls";

	Alligator(String animalName, int ageOfAnimal, double weightOfAnimal,
			int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}

/**
 * This is a SubClass of Reptile, this Specifies the Type of Animal i.e., Snake
 * 
 * @author Mohit Sharma
 *
 */
class Snake extends Reptile {
	final String animalName;
	final String soundOfAnimal = "Hiss";

	Snake(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}