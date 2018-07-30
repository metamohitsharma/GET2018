package GET2018.PF.PFAssignment4.ArrOperations;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import GET2018.PF.PFAssignment4.ArrOperations.ArrOperation.ArrOperationException;

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
	public void largestMirrorTest() throws ArrOperationException {
		assertEquals(9, arrayOperations.largestMirror(new char[] { 'a', '@', 'b', ' ', '$', ' ', 'b', '@', 'a' }));
		assertEquals(3, arrayOperations.largestMirror(new char[] { 'f', '3', 'f', 'x' }));
	}

	@Test
	public void numberOfClumpsTest() throws ArrOperationException {
		assertEquals(2, arrayOperations.numbersOfClumps(new char[] { 'a', 'a', 'b', '/', '/' }));
		assertEquals(1, arrayOperations.numbersOfClumps(new char[] { ' ', ' ', ' ' }));
	}

	@Test
	public void fixXYTest() throws ArrOperationException {
		assertArrayEquals(new char[] { ' ', '@', 'b', 'a', '$', '@', 'b', 'a' },
				arrayOperations.fixXy('b', 'a', new char[] { 'a', '@', 'b', ' ', '$', 'a', 'b', '@' }));
	}

	@Test
	public void splitArrayTest() throws ArrOperationException {
		assertEquals(3, arrayOperations.splitArray(new int[] { 1, 1, 1, 2, 1 }));
		assertEquals(-1, arrayOperations.splitArray(new int[] { 2, 1, 1, 2, 1 }));
		assertEquals(1, arrayOperations.splitArray(new int[] { 10, 10 }));
	}

	@Test
	public void largestMirrorWithNull() throws ArrOperationException {
		try {
			arrayOperations.largestMirror(null);
		} catch (NullPointerException ex) {
			assertEquals("Input Array is Null in largestMirror", ex.getMessage());
		}
	}

	@Test
	public void largestMirrorLengthZero() throws ArrOperationException {
		try {
			arrayOperations.largestMirror(new char[] {});
		} catch (ArrOperationException ex) {
			assertEquals("Input Array is Empty in largestMirror", ex.getMessageException());
		}
	}

	@Test
	public void noOfClumpsWithNull() throws ArrOperationException {
		try {
			arrayOperations.numbersOfClumps(null);
		} catch (NullPointerException ex) {
			assertEquals("Clump Array is Null", ex.getMessage());
		}
	}

	@Test
	public void noOfClumpsLengthZeroArray() throws ArrOperationException {
		try {
			arrayOperations.numbersOfClumps(new char[] {});
		} catch (ArrOperationException ex) {
			assertEquals("Clump Array is Empty", ex.getMessageException());
		}
	}

	@Test
	public void arrayToFixWithNull() throws ArrOperationException {
		try {
			arrayOperations.fixXy(' ', ' ', null);
		} catch (NullPointerException ex) {
			assertEquals("ArrayToFixXY is Null", ex.getMessage());
		}
	}

	@Test
	public void arrayToFixWithNullX() throws ArrOperationException {
		try {
			arrayOperations.fixXy('\0', ' ', new char[] { 'a', ' ' });
		} catch (NullPointerException ex) {
			assertEquals("Given X is Null", ex.getMessage());
		}
	}

	@Test
	public void arrayToFixWithNullY() throws ArrOperationException {
		try {
			arrayOperations.fixXy(' ', '\0', new char[] { 'a', ' ' });
		} catch (NullPointerException ex) {
			assertEquals("Given Y is Null", ex.getMessage());
		}
	}

	@Test
	public void arrayToFixWithZeroLength() throws ArrOperationException {
		try {
			arrayOperations.fixXy('b', 'a', new char[] {});
		} catch (ArrOperationException ex) {
			assertEquals("ArrayToFixXY is Empty", ex.getMessageException());
		}
	}

	@Test
	public void arrayToFixWithUnitLength() throws ArrOperationException {
		try {
			arrayOperations.fixXy('b', 'a', new char[] { 'a' });
		} catch (ArrOperationException ex) {
			assertEquals("ArrayToFixXY should atleast have two Elements", ex.getMessageException());
		}
	}

	@Test
	public void arrayToFixWithXAtLastIndex() throws ArrOperationException {
		try {
			arrayOperations.fixXy('b', 'a', new char[] { 'a', 'b' });
		} catch (ArrOperationException ex) {
			assertEquals("b is at Last Index", ex.getMessageException());
		}
	}

	@Test
	public void arrayToFixWithXAndYUnEqual() throws ArrOperationException {
		try {
			arrayOperations.fixXy('b', 'a', new char[] { 'a', 'b', 'a' });
		} catch (ArrOperationException ex) {
			assertEquals("No of b and a are not Equal", ex.getMessageException());
		}
	}

	@Test
	public void arrayToFixWithTwoAdjacentX() throws ArrOperationException {
		try {
			arrayOperations.fixXy('b', 'a', new char[] { 'b', 'b', 'a', 'a' });
		} catch (ArrOperationException ex) {
			assertEquals("Two b at adjacent Positions", ex.getMessageException());
		}
	}

	@Test
	public void splitArrayWithNull() throws ArrOperationException {
		try {
			arrayOperations.splitArray(null);
		} catch (NullPointerException ex) {
			assertEquals("Array is Null in SplitArray", ex.getMessage());
		}
	}

	@Test
	public void splitArrayWithZeroLength() throws ArrOperationException {
		try {
			arrayOperations.splitArray(new int[] {});
		} catch (ArrOperationException ex) {
			assertEquals("Array is Empty in SplitArray", ex.getMessageException());
		}
	}

	@Test
	public void splitArrayWithUnitLength() throws ArrOperationException {
		try {
			arrayOperations.splitArray(new int[] { 1 });
		} catch (ArrOperationException ex) {
			assertEquals("Array Length should be atleast 2 in SplitArray", ex.getMessageException());
		}
	}
}