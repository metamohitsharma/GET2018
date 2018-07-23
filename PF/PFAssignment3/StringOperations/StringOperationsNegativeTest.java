package GET2018.PF.PFAssignment3.StringOperations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringOperationsNegativeTest {

	StringOperations operations;

	@Before
	public void init() {
		operations = new StringOperations("Graduate Engineer Trainee");
	}

	@Test
	public void testEquals() {
		assertNotEquals(1, operations.isEquals("Graduate Engineering"));
	}

	@Test
	public void testReverseString() {
		assertNotEquals("eeniarT reenignE", operations.reverseString());
	}

	@Test
	public void testViceVersa() {
		assertNotEquals("gRADUATE eNGINEER TRAINEE", operations.viceVersa());
	}

	@Test
	public void testLongestWord() {
		assertNotEquals("Graduate", operations.longestWord());
	}

}
