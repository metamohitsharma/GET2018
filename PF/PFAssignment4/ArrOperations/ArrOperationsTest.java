package GET2018.PF.PFAssignment4.ArrOperations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This class contains TestCases for different methods in ArrOperation Class
 * 
 * @author Mohit Sharma
 *
 */
public class ArrOperationsTest {
	ArrOperation arrayOperations;

	@Before
	public void init() {
		arrayOperations = new ArrOperation();
	}

	@Test
	public void largestMirrorTest() {
		assertEquals(
				3,
				arrayOperations.largestMirror(new int[] { 1, 2, 3, 8, 9, 3, 2,
						1 }));
		assertEquals(2, arrayOperations.largestMirror(new int[] { 7, 1, 4, 9,
				7, 4, 1 }));
		assertEquals(3, arrayOperations.largestMirror(new int[] { 1, 2, 1, 4 }));
		assertEquals(7, arrayOperations.largestMirror(new int[] { 1, 4, 5, 3,
				5, 4, 1 }));
	}

	@Test
	public void numberOfClumpsTest() {
		assertEquals(2,
				arrayOperations.numbersOfClumps(new int[] { 1, 2, 2, 3, 4, 4 }));
		assertEquals(2,
				arrayOperations.numbersOfClumps(new int[] { 1, 1, 2, 1, 1 }));
		assertEquals(1,
				arrayOperations.numbersOfClumps(new int[] { 1, 1, 1, 1, 1 }));
	}

	@Test
	public void fixXYTest() {
		assertArrayEquals(new int[] { 9, 4, 5, 4, 5, 9 },
				arrayOperations.fixXy(4, 5, new int[] { 5, 4, 9, 4, 9, 5 }));
		assertArrayEquals(new int[] { 1, 4, 5, 1 },
				arrayOperations.fixXy(4, 5, new int[] { 1, 4, 1, 5 }));
		assertArrayEquals(new int[] { 1, 4, 5, 1, 1, 4, 5 },
				arrayOperations.fixXy(4, 5, new int[] { 1, 4, 1, 5, 5, 4, 1 }));
	}

	@Test
	public void splitArrayTest() {
		assertEquals(3, arrayOperations.splitArray(new int[] { 1, 1, 1, 2, 1 }));
		assertEquals(-1,
				arrayOperations.splitArray(new int[] { 2, 1, 1, 2, 1 }));
		assertEquals(1, arrayOperations.splitArray(new int[] { 10, 10 }));
	}
}
