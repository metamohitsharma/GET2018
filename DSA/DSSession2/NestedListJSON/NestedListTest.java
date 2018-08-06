package GET2018.DSA.DSSession2.NestedListJSON;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

/**
 * This class performs different test on ListOfIntegers class
 * 
 * @author Mohit Sharma
 *
 */
public class NestedListTest {

	ListOfIntegers integersList;

	@Before
	public void init() throws FileNotFoundException {
		integersList = new ListOfIntegers();
		integersList.addList("Integers1.JSON");
		integersList.addList("Integers2.JSON");
		integersList.addList("Integers3.JSON");
	}

	@Test
	public void addListTest() throws FileNotFoundException {
		// Add List using File Integers4.JSON
		assertTrue(integersList.addList("Integers4.JSON"));
	}

	@Test
	public void addAllIntegersTest() {
		// Add all integers in Nested List
		assertEquals(206, integersList.addAllIntegers());
	}

	@Test
	public void largestIntegerTest() {
		// Largest Integer in NestedList
		assertEquals(576, integersList.largestInteger());
	}

	@Test
	public void searchElementTest() {
		// Search 22 in Nested List
		assertTrue(integersList.searchList(22));
	}

	@Test
	public void addListWithNull() throws FileNotFoundException {
		// Add Null in List
		try {
			integersList.addList(null);
		} catch (NullPointerException ex) {
			assertEquals("FileName Can't be Empty", ex.getMessage());
		}
	}

	@Test
	public void addListFileNotFound() {
		// Add a file which not exist
		try {
			integersList.addList("AddInteger.json");
		} catch (FileNotFoundException ex) {
			assertEquals("File not Found in addList", ex.getMessage());
		}
	}
}
