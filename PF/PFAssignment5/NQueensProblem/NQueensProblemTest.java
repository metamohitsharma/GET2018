package GET2018.PF.PFAssignment5.NQueensProblem;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import GET2018.PF.PFAssignment5.NQueensProblem.NQueensProblem.NQueensException;

/**
 * This Class performs TestCases on operations in NQueensProblem class
 * 
 * @author Mohit Sharma
 *
 */
public class NQueensProblemTest {

	NQueensProblem nQueens;

	@Before
	public void init() {
		nQueens = new NQueensProblem();
	}

	@Test
	public void testWithValidInputs() throws NQueensException {
		assertTrue(
				nQueens.nQueen(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } }, 0, 4));
	}

	@Test
	public void testWithNull() throws NQueensException {
		try {
			nQueens.nQueen(null, 0, 4);
		} catch (NullPointerException ex) {
			assertEquals("Board Array is Null", ex.getMessage());
		}
	}

	@Test
	public void testWithLengthZeroArray() {
		try {
			nQueens.nQueen(new int[][] {}, 0, 4);
		} catch (NQueensException ex) {
			assertEquals("Board Array is Empty", ex.getMessageException());
		}
	}

	@Test
	public void testWithBothDimensionsUnEqual() {
		try {
			nQueens.nQueen(new int[][] { { 0, 0 }, { 0, 0, 0 } }, 0, 2);
		} catch (NQueensException ex) {
			assertEquals("Board Array not Valid", ex.getMessageException());
		}
	}
}
