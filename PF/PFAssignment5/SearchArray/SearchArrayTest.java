package GET2018.PF.PFAssignment5.SearchArray;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
	public void linearSearchtest() {
		assertEquals(3, searchArray.linearSearch(new int[] { 12, 3, 6, 8, 34, 78, 1 }, 0, 8));
		assertEquals(-1, searchArray.linearSearch(new int[] { 12, 3, 6, 8, 34, 78, 1 }, 0, 13));
	}

	@Test
	public void binarySearchTest() {
		assertEquals(3, searchArray.binarySearch(new int[] { 12, 21, 67, 80, 99, 108 }, 0, 5, 80));
	}
}
