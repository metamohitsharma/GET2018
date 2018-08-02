package GET2018.DSA.DSSession1.Stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GET2018.DSA.DSSession1.Stack.StackArray.StackException;

/**
 * This class performs various tests on StackLinkedList class methods
 * 
 * @author Mohit Sharma
 *
 */
public class StackListTest {
	StackLinkedList stackList;

	@Before
	public void init() throws StackException {
		stackList = new StackLinkedList();
		// Initializing Stack using Linked List
		stackList.push("Wolf");
		stackList.push("of");
		stackList.push("the");
		stackList.push("Wall");
	}

	@Test
	public void testPopStackUsingList() throws StackException {
		// Deleting Element from Stack
		assertEquals("Wall", stackList.pop());
		assertEquals("the", stackList.pop());
	}

	@Test
	public void pushNullInStackUsingList() throws StackException {
		// Adding Null Element in Stack
		try {
			stackList.push(null);
		} catch (NullPointerException ex) {
			assertEquals("Element to be Added Can't be Null", ex.getMessage());
		}
	}

	@Test
	public void testPushStackUsingList() throws StackException {
		// Adding Element in Stack
		assertTrue(stackList.push("Street"));
	}

	@Test
	public void testTopElementStackUsingList() throws StackException {
		// Top Element in Stack
		assertEquals("Wall", stackList.top());
	}

	@Test
	public void testIsEmptyStackUsingList() {
		// Checking Whether the Stack is Empty or not
		assertFalse(stackList.isEmpty());
	}

	@Test
	public void testPushStackUsingListOverflow() {
		// Adding element when Stack is Full
		try {
			stackList.push("Street");
			stackList.push("Directed");
		} catch (StackException ex) {
			assertEquals("Element can't be Add, Stack is Full",
					ex.getMessageException());
		}
	}

	@Test
	public void testPopStackUsingListUnderflow() {
		// Deleting element from an Empty Stack
		try {
			stackList.pop();
			stackList.pop();
			stackList.pop();
			stackList.pop();
			stackList.pop();
		} catch (StackException ex) {
			assertEquals("Stack Underflow", ex.getMessageException());
		}
	}
}
