package GET2018.DSA.DSSession2.NestedList;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs different test on ListOfIntegers class
 * 
 * @author Mohit Sharma
 *
 */
public class NestedListTest {

	ListOfIntegers integersList;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() throws FileNotFoundException {
		integersList = new ListOfIntegers();
		integersList.addList(new ArrayList<>(Arrays.asList(2, 345, 12, 56, -12)));
		integersList.addList(new ArrayList<>(Arrays.asList(12, 51, -12, 5, -122, -57)));
		integersList.addList(new ArrayList<>(Arrays.asList(1, 571, 24, 68, -11, 0)));
	}

	@Test
	public void addListTest() throws FileNotFoundException {
		// Add List in NestedList
		assertTrue(integersList.addList(new ArrayList<>(Arrays.asList(24, 66, 258, 11))));
	}

	@Test
	public void addAllIntegersTest() {
		// Add all integers in Nested List
		assertEquals(933, integersList.addAllIntegers());
	}

	@Test
	public void largestIntegerTest() {
		// Largest Integer in NestedList
		assertEquals(571, integersList.largestInteger());
	}

	@Test
	public void searchElementTest() {
		// Search -11 in Nested List
		assertTrue(integersList.searchList(-11));
	}

	@Test
	public void addListWithNull() throws FileNotFoundException {
		// Add Null in List
		ex.expect(NullPointerException.class);
		ex.expectMessage("List to be Add Can't be Empty");
		integersList.addList(null);
	}
}
