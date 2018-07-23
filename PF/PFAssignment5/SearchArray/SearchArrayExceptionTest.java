package GET2018.PF.PFAssignment5.SearchArray;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains the Exception TestCases for methods in SearchArray class
 * 
 * @author Mohit Sharma
 *
 */
public class SearchArrayExceptionTest {

	SearchArray searchArray;

	@Before
	public void beforeTests() {
		searchArray = new SearchArray();
	}

	@Test(expected = AssertionError.class)
	public void testLinearSearch() {
		assertEquals(3, searchArray.linearSearch(new int[] {}, 0, 8));
	}

	@Test(expected = AssertionError.class)
	public void testBinarySearch() {
		assertEquals(3, searchArray.binarySearch(new int[] {}, 0, 5, 8));
	}
}
