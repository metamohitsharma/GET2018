package GET2018.DSA.DSSession2.InfixToPostfix;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This class performs various Tests on InfixToPostfixClass
 * 
 * @author Mohit Sharma
 */
public class TestInfixToPostfix {

	StackArray stack;

	@Before
	public void init() {
		stack = new StackArray();
	}

	@Test
	public void testInfixToPostfix1() throws StackArrayException {
		// Converting Infix 2 + 3 * 4 to Postfix
		assertEquals("234*+", stack.infixToPostfix("2 + 3 * 4"));
	}

	@Test
	public void testInfixToPostfix2() throws StackArrayException {
		// Converting Infix a * b + 4 to Postfix
		assertEquals("ab*4+", stack.infixToPostfix("a * b + 4"));
	}

	@Test
	public void testInfixToPostfix3() throws StackArrayException {
		// Converting Infix a * ( b + c )to Postfix
		assertEquals("abc+*", stack.infixToPostfix("a * ( b + c )"));
	}

	@Test
	public void testWrongInfixExpression() {
		// Converting Invalid Infix to Postfix
		try {
			stack.infixToPostfix("a * b + c )");
		} catch (StackArrayException ex) {
			assertEquals("Wrong Infix Expression", ex.getMessageException());
		}
	}

	@Test
	public void testInfixNullException() throws StackArrayException {
		// Converting Null Infix to Postfix
		try {
			stack.infixToPostfix(null);
		} catch (NullPointerException ex) {
			assertEquals("Infix Can't be Null", ex.getMessage());
		}
	}
}
