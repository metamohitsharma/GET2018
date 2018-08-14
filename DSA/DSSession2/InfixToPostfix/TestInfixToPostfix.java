package GET2018.DSA.DSSession2.InfixToPostfix;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various Tests on InfixToPostfixClass
 * 
 * @author Mohit Sharma
 */
public class TestInfixToPostfix {

	StackArray stack;

	@Rule
	public ExpectedException ex = ExpectedException.none();

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
	public void testWrongInfixExpression() throws StackArrayException {
		// Converting Invalid Infix to Postfix
		ex.expect(StackArrayException.class);
		ex.expectMessage("Wrong Infix Expression");
		stack.infixToPostfix("a * b + c )");
	}

	@Test
	public void testInfixNullException() throws StackArrayException {
		// Converting Null Infix to Postfix
		ex.expect(NullPointerException.class);
		ex.expectMessage("Infix Can't be Null");
		stack.infixToPostfix(null);
	}
}
