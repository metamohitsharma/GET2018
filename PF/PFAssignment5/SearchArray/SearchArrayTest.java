package GET2018.PF.PFAssignment5.SearchArray;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import GET2018.PF.PFAssignment5.SearchArray.SearchArray.SearchException;

/**
 * This class contains the TestCases for methods in SearchArray class
 * 
 * @author Mohit Sharma
 *
 */
public class SearchArrayTest {

	SearchArray searchArray;

	@Before
	public void beforeTests() {
		searchArray = new SearchArray();
	}

	@Test
	public void linearSearchtest() throws SearchException {
		assertEquals(3, searchArray.linearSearch(new int[] { 12, 3, 6, 8, 34, 78, 1 }, 0, 8));
		assertEquals(-1, searchArray.linearSearch(new int[] { 12, 3, 6, 8, 34, 78, 1 }, 0, 13));
	}

	@Test
	public void binarySearchTest() throws SearchException {
		assertEquals(3, searchArray.binarySearch(new int[] { 12, 21, 67, 80, 99, 108 }, 0, 5, 80));
	}

	@Test
	public void linearSearchWithNull() throws SearchException {
		try {
			searchArray.linearSearch(null, 0, 8);
		} catch (NullPointerException ex) {
			assertEquals("Entered Array is Null in LinearSearch", ex.getMessage());
		}
	}

	@Test
	public void linearSearchWithZeroLength() {
		try {
			searchArray.linearSearch(new int[] {}, 0, 8);
		} catch (SearchException ex) {
			assertEquals("Input Array is Empty in LinearSearch", ex.getMessageException());
		}
	}

	@Test
	public void binarySearchWithNull() throws SearchException {
		try {
			searchArray.binarySearch(null, 0, 8, 80);
		} catch (NullPointerException ex) {
			assertEquals("Entered Array is Null in BinarySearch", ex.getMessage());
		}
	}

	@Test
	public void bianrySearchWithZeroLength() {
		try {
			searchArray.binarySearch(new int[] {}, 0, 8, 80);
		} catch (SearchException ex) {
			assertEquals("Input Array is Empty in BinarySearch", ex.getMessageException());
		}
	}
}
