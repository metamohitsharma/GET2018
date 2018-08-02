package GET2018.DSA.DSSession1.Stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GET2018.DSA.DSSession1.Stack.StackArray.StackException;

/**
 * This class performs various tests on StackArray class methods
 * 
 * @author Mohit Sharma
 *
 */
public class StackArrayTest {

	StackArray stackArray;

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
	public void testPushStackUsingArrayOverflow() {
		// Adding element when Stack is Full
		try {
			stackArray.push("Stars");
			stackArray.push("Written");
		} catch (StackException ex) {
			assertEquals("Element can't be Add, Stack is Full",
					ex.getMessageException());
		}
	}

	@Test
	public void pushNullInStackUsingArray() throws StackException {
		// Adding Null Element in Stack
		try {
			stackArray.push(null);
		} catch (NullPointerException ex) {
			assertEquals("Element to be Added Can't be Null", ex.getMessage());
		}
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
	public void testPopStackUsingArrayUnderflow() {
		// Deleting from an Empty Stack
		try {
			stackArray.pop();
			stackArray.pop();
			stackArray.pop();
			stackArray.pop();
			stackArray.pop();
		} catch (StackException ex) {
			assertEquals("Stack Underflow", ex.getMessageException());
		}
	}
}
