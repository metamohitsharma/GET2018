package GET2018.DSA.DSSession2.Tree;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
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
	public void init() {
		integersList = new ListOfIntegers();
		integersList.addList(12);
		integersList.addList(new ArrayList<>(Arrays.asList(21, 51, -12, 5, -122, -57)));
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(new ArrayList<Integer>(Arrays.asList(2, 435, 78, 12)));
		list.add(new ArrayList<Integer>(Arrays.asList(5, -27, 0, 127, 6, -173)));
		integersList.addList(list);
	}

	@Test
	public void addListTest() {
		// Add List in NestedList
		assertTrue(integersList.addList(new ArrayList<>(Arrays.asList(24, 66, 258, 11))));
	}

	@Test
	public void addAllIntegersTest() {
		// Add all integers in Nested List
		assertEquals(363, integersList.addAllIntegers(NestedList.nestedList));
	}

	@Test
	public void largestIntegerTest() {
		// Largest Integer in NestedList
		assertEquals(435, integersList.largestInteger(NestedList.nestedList));
	}

	@Test
	public void searchElementTest() {
		// Search -12 in Nested List
		assertTrue(integersList.searchList(NestedList.nestedList, 5));
	}

	@Test
	public void getValueTest() throws NestedListException {
		// Search -12 in Nested List
		assertEquals(21, integersList.getValue(NestedList.nestedList, "THH"));
	}

	@Test
	public void addListWithNull() {
		// Add Null in List
		try {
			integersList.addList(null);
		} catch (NullPointerException ex) {
			assertEquals("List to be Add Can't be Empty", ex.getMessage());
		}
	}

	@Test
	public void getValueAtHeadList() {
		// Search TH value in list
		try {
			integersList.getValue(NestedList.nestedList, "TH");
		} catch (NestedListException ex) {
			assertEquals("List found at Head", ex.getMessageException());
		}
	}

	@Test
	public void getValueAtTailList() {
		// Search TT value in List
		try {
			integersList.getValue(NestedList.nestedList, "TT");
		} catch (NestedListException ex) {
			assertEquals("List found at Tail", ex.getMessageException());
		}
	}
}
