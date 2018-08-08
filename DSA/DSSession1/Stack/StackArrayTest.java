package GET2018.DSA.DSSession1.Stack;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on StackArray class methods
 * 
 * @author Mohit Sharma
 *
 */
public class StackArrayTest {

	StackArray stackArray;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() throws StackException {
		stackArray = new StackArray();

		// Initializing Stack using Array
		stackArray.push("The");
		stackArray.push("Fault");
		stackArray.push("In");
		stackArray.push("Our");

	}

	@Test
	public void testPushStackUsingArrayOverflow() throws StackException {
		// Adding element when Stack is Full
		stackArray.push("Stars");
		ex.expect(StackException.class);
		ex.expectMessage("Element can't be Add, Stack is Full");
		stackArray.push("Written");
	}

	@Test
	public void pushNullInStackUsingArray() throws StackException {
		// Adding Null Element in Stack
		ex.expect(NullPointerException.class);
		ex.expectMessage("Element to be Added Can't be Null");
		stackArray.push(null);
	}

	@Test
	public void testPopStackUsingArray() throws StackException {
		// Deleting Element from Stack
		assertEquals("Our", stackArray.pop());
		assertEquals("In", stackArray.pop());
	}

	@Test
	public void testPushStackUsingArray() throws StackException {
		// Adding Element in Stack
		assertTrue(stackArray.push("Stars"));
	}

	@Test
	public void testTopElementStackUsingArray() throws StackException {
		// Top Element in Stack
		assertEquals("Our", stackArray.top());
	}

	@Test
	public void testIsEmptyStackUsingArray() {
		// Checking Whether the Stack is Empty or not
		assertFalse(stackArray.isEmpty());
	}

	@Test
	public void testPopStackUsingArrayUnderflow() throws StackException {
		// Deleting from an Empty Stack
		stackArray.pop();
		stackArray.pop();
		stackArray.pop();
		stackArray.pop();
		ex.expect(StackException.class);
		ex.expectMessage("Stack Underflow");
		stackArray.pop();
	}
}
