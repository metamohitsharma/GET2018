package GET2018.SCF.SCFSession8.ZooManagementSystem;

/**
 * This is a SubClass of Animal, this class Specifies the Category of Animal
 * i.e., Mammal
 * 
 * @author Mohit Sharma
 *
 */
public class Mammal extends Animal {
	final AnimalCategory categoryOfAnimal = AnimalCategory.Mammal;

	@Override
	public AnimalCategory getCategoryOfAnimal() {
		return categoryOfAnimal;
	}
}

/**
 * This is a SubClass of Mammal, this Specifies the Type of Animal i.e., Lion
 * 
 * @author Mohit Sharma
 *
 */
class Lion extends Mammal {
	final String animalName;;
	final String soundOfAnimal = "Roars";

	Lion(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}

/**
 * This is a SubClass of Mammal, this Specifies the Type of Animal i.e., Zebra
 * 
 * @author Mohit Sharma
 *
 */
class Zebra extends Mammal {
	final String animalName;
	final String soundOfAnimal = "Whinny";

	Zebra(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}

/**
 * This is a SubClass of Mammal, this Specifies the Type of Animal i.e., Deer
 * 
 * @author Mohit Sharma
 *
 */
class Deer extends Mammal {
	final String animalName;
	final String soundOfAnimal = "Bell";

	public Deer(String animalName, int ageOfAnimal, double weightOfAnimal, int cageNo) {
		this.animalName = animalName;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.cageNo = cageNo;
	}
}