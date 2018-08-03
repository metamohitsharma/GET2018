package GET2018.SCF.SCFSession8.ZooManagementSystem;

import static org.junit.Assert.*;
import org.junit.Test;

import GET2018.SCF.SCFSession8.ZooManagementSystem.Zoo.ZooException;

/**
 * This class performs various TestCases for methods in ZooClass
 * 
 * @author Mohit Sharma
 *
 */
public class ZooTest {

	@Test
	public void addZoneTest() {
		// Adding a new Zone for Mammals which has Canteen and Park both
		assertTrue(new Zoo().addZone(10, AnimalCategory.Mammal, true, true));
	}

	@Test
	public void addCageTest() throws ZooException {
		// Adding a new Cage for Zebra in Zone1 which has a Capacity of 5 Zebras
		assertTrue(new Zoo().addCage(AnimalType.Zebra, 1, 5));
	}

	@Test
	public void addAnimalTest() throws ZooException {
		// Adding Parrot-4 in Cage3 whose age is 2years and weight is 8kgs
		assertTrue(new Zoo().addAnimal("Parrot-4", AnimalType.Parrot, 2, 8, 3));
	}

	@Test
	public void addZoneWithNullCategory() {
		// Providing CategoryOfAnimal as Null
		try {
			new Zoo().addZone(10, null, true, true);
		} catch (NullPointerException ex) {
			assertEquals("Category Of Animal in Zone Can't be Null",
					ex.getMessage());
		}
	}

	@Test
	public void addCageWithNullCategory() throws ZooException {
		// Providing CategoryOfAnimal as Null
		try {
			new Zoo().addCage(null, 4, 5);
		} catch (NullPointerException ex) {
			assertEquals("Category Of Animal in Cage Can't be Null",
					ex.getMessage());
		}
	}

	@Test
	public void addAnimalWithNullCategoryORName() throws ZooException {
		// Providing CategoryOfAnimal as Null and Name of Animal as Zero length
		// String
		try {
			new Zoo().addAnimal(null, AnimalType.Lion, 5, 34, 1);
		} catch (NullPointerException ex) {
			assertEquals(
					"Category Of Animal or Name of Animal Can't be Null or Zero",
					ex.getMessage());
		}
	}

	@Test
	public void addCageInFullZone() {
		// Adding Cage in a Full Zone i.e., No cage could be Added in this Zone
		try {
			new Zoo().addCage(AnimalType.Alligator, 3, 5);
		} catch (ZooException ex) {
			assertEquals("Zone is Full", ex.getMessageException());
		}
	}

	@Test
	public void addAnimalWithDifferentTypeOfAnimal() {
		// Adding Animal of Different Type to another Type of Cage i.e., Parrot
		// to Deer Cage
		try {
			new Zoo().addAnimal("Parrot-4", AnimalType.Parrot, 3, 20.5, 2);
		} catch (ZooException ex) {
			assertEquals("This cage is not for the given type of Animal",
					ex.getMessageException());
		}

	}

	@Test
	public void addAnimalWithCageFull() {
		// Adding Animal to a Full Cage i.e., Adding Snake to Cage 6 which is
		// already Full
		try {
			new Zoo().addAnimal("Snake-4", AnimalType.Snake, 3, 20.5, 6);
		} catch (ZooException ex) {
			assertEquals("Cage is Full, Can't add more animals",
					ex.getMessageException());
		}
	}

	@Test
	public void addAnimalWithSameName() {
		// Adding a new Animal whose Name is already in the System
		try {
			new Zoo().addAnimal("Lion-1", AnimalType.Lion, 20, 200, 1);
		} catch (ZooException ex) {
			assertEquals("Animal Name should be Unique",
					ex.getMessageException());
		}
	}
}
