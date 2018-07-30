package GET2018.PF.PFAssignment3.StringOperations;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import GET2018.PF.PFAssignment3.StringOperations.StringOperations.StringException;

/**
 * This Class performs different test on StringOperations Class
 * 
 * @author Mohit Sharma
 *
 */
public class StringOperationsTest {
	static StringOperations operations;

	@BeforeClass
	public static void init() throws StringException {
		operations = new StringOperations("w24$#@# /'");
	}

	@Test
	public void testEquals() throws StringException {
		assertEquals(0, operations.isEquals("w24$#@#"));
	}

	@Test
	public void testReverseString() {
		assertEquals("'/ #@#$42w", operations.reverseString());
	}

	@Test
	public void testViceVersa() {
		assertEquals("W24$#@# /'", operations.viceVersa());
	}

	@Test
	public void testLongestWord() {
		assertEquals("w24$#@#", operations.longestWord());
	}

	@Test
	public void testStringWithNull() throws StringException {
		try {
			new StringOperations(null);
		} catch (NullPointerException ex) {
			assertEquals("String is null", ex.getMessage());
		}
	}

	@Test
	public void testStringWithLengthZero() {
		try {
			new StringOperations("");
		} catch (StringException ex) {
			assertEquals("String is Empty", ex.getMessageException());
		}
	}

	@Test
	public void testIsEqualWithNull() throws StringException {
		try {
			operations.isEquals(null);
		} catch (NullPointerException ex) {
			assertEquals("isEqual String is null", ex.getMessage());
		}
	}

	@Test
	public void testIsEqualWithLengthZeroString() {
		try {
			operations.isEquals("");
		} catch (StringException ex) {
			assertEquals("isEqual String is Empty", ex.getMessageException());
		}
	}
}
