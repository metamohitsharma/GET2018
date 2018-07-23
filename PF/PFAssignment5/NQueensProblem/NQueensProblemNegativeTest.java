package GET2018.PF.PFAssignment5.NQueensProblem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This Class performs Negative TestCases on operations in NQueensProblem class
 * 
 * @author Mohit Sharma
 *
 */
public class NQueensProblemNegativeTest {

	NQueensProblem nQueens;

	@Before
	public void init() {
		nQueens = new NQueensProblem();
	}

	@Test
	public void test() {
		assertNotEquals(true, nQueens.nQueen(new int[][] { { 0, 0 }, { 0, 0 } }, 0, 2));
	}
}
