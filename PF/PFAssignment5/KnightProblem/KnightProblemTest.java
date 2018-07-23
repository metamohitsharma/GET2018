package GET2018.PF.PFAssignment5.KnightProblem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KnightProblemTest {

	KnightProblem KnightProblemSolve;

	@Before
	public void init() {
		KnightProblemSolve = new KnightProblem();
	}

	@Test
	public void test() {
		assertTrue(KnightProblemSolve.init());
	}

}
