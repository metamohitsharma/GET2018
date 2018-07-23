package GET2018.PF.PFAssignment5.MathematicalOperations;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains the Negative TestCases for methods in
 * MathematicalOperation class
 * 
 * @author Mohit Sharma
 *
 */
public class MathematicalOperationNegativeTest {
	MathematicalOperation operations;

	@Before
	public void init() {
		operations = new MathematicalOperation();
	}

	@Test
	public void testLCM() {
		assertNotEquals(4, operations.calculateLCM(16, 12));
	}

	@Test
	public void testGCD() {
		assertNotEquals(10, operations.calculateGCD(16, 12));
	}
}
