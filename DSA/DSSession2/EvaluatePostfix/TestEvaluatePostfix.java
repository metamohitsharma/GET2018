package GET2018.DSA.DSSession2.EvaluatePostfix;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class tests various methods described in StackArray class
 * 
 * @author Mohit Sharma
 *
 */
public class TestEvaluatePostfix {
	StackArray stackArray;

	@Rule
	public ExpectedException ex = ExpectedException.none();

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
		ex.expect(NullPointerException.class);
		ex.expectMessage("Postfix Expression can't be Null");
		stackArray.evaluatePostfix(null);
	}

	@Test
	public void evaluatePostfixWithWrongExpression() throws StackException {
		// Evaluating Postfix with AND operator
		ex.expect(NumberFormatException.class);
		ex.expectMessage("Postfix Expression Wrong");
		stackArray.evaluatePostfix("23 9 &&");
	}
}
