package GET2018.PF.PFAssignment3.StringOperations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringOperationsTest {

	@Test
	void test() {
		StringOperations operations = new StringOperations("Graduate Engineer Trainee");
		assertEquals(0, operations.isEquals("Graduate Engineering"));
		assertEquals("eeniarT reenignE etaudarG", operations.reverseString());
		assertEquals("gRADUATE eNGINEER tRAINEE", operations.viceVersa());
		assertEquals("Engineer", operations.longestWord());
	}
}
