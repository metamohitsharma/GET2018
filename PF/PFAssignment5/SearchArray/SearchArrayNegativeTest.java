package GET2018.PF.PFAssignment5.SearchArray;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains the Negative TestCases for methods in SearchArray class
 * 
 * @author Mohit Sharma
 *
 */
public class SearchArrayNegativeTest {

	SearchArray searchArray;

	@Before
	public void beforeTests() {
		searchArray = new SearchArray();
	}

	@Test
	public void linearSearchTest() {
		assertNotEquals(4, searchArray.linearSearch(new int[] { 23, 12, 4, 7, 98, 3 }, 0, 4));
		assertNotEquals(-1, searchArray.linearSearch(new int[] { 23, 12, 4, 7, 98, 3 }, 0, 4));
	}

	@Test
	public void binarySearchTest() {
		assertNotEquals(1, searchArray.binarySearch(new int[] { 3, 4, 6, 12, 45, 67 }, 0, 5, 12));
	}
}
