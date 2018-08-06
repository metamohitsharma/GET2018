package GET2018.DSA.DSSession2.EvaluatePostfix;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests various methods described in StackArray class
 * 
 * @author Mohit Sharma
 *
 */
public class TestEvaluatePostfix {
	StackArray stackArray;

	@Before
	public void init() {
		stackArray = new StackArray();
	}

	@Test
	public void testEvaluatePostfix() throws StackException {
		// Evaluate Postfix 22 3 1 * + 9 -
		assertEquals(16, stackArray.evaluatePostfix("22 3 1 * + 9 -"));
	}

	@Test
	public void evaluatePostfixWithNull() throws StackException {
		// Evaluate Postfix with Null
		try {
			stackArray.evaluatePostfix(null);
		} catch (NullPointerException ex) {
			assertEquals("Postfix Expression can't be Null", ex.getMessage());
		}
	}

	@Test
	public void evaluatePostfixWithWrongExpression() throws StackException {
		// Evaluating Postfix with AND operator
		try {
			stackArray.evaluatePostfix("23 9 &&");
		} catch (NumberFormatException ex) {
			assertEquals("Postfix Expression Wrong", ex.getMessage());
		}
	}
}
