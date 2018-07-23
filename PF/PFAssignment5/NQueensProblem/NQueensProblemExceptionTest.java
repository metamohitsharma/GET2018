package GET2018.PF.PFAssignment5.NQueensProblem;

import org.junit.Before;
import org.junit.Test;

/**
 * This Class performs Exception TestCases on operations in NQueensProblem class
 * 
 * @author Mohit Sharma
 *
 */
public class NQueensProblemExceptionTest {
	NQueensProblem nQueens;

	@Before
	public void init() {
		nQueens = new NQueensProblem();
	}

	@Test(expected = AssertionError.class)
	public void test() {
		nQueens.nQueen(new int[][] {}, 0, 2);
		nQueens.nQueen(new int[][] { { 0, 0 }, { 0, 0 }, { 0, 0 } }, 0, 2);
	}

}
