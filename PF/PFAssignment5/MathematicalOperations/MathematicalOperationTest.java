package GET2018.PF.PFAssignment5.MathematicalOperations;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains the TestCases for methods in MathematicalOperation class
 * 
 * @author Mohit Sharma
 *
 */
public class MathematicalOperationTest {
	MathematicalOperation operations;

	@Before
	public void init() {
		operations = new MathematicalOperation();
	}

	@Test
	public void testLCM() {
		assertEquals(48, operations.calculateLCM(16, 12));
	}

	@Test
	public void testGCD() {
		assertEquals(4, operations.calculateGCD(16, 12));
	}
}
