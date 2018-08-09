package GET2018.DSA.DSSession1.Stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on StackLinkedList class methods
 * 
 * @author Mohit Sharma
 *
 */
public class StackListTest {
	StackLinkedList stackList;

	@Rule
	public ExpectedException ex = ExpectedException.none();

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
		ex.expect(NullPointerException.class);
		ex.expectMessage("Element to be Added Can't be Null");
		stackList.push(null);
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
	public void testPushStackUsingListOverflow() throws StackException {
		// Adding element when Stack is Full
		stackList.push("Street");
		ex.expect(StackException.class);
		ex.expectMessage("Element can't be Add, Stack is Full");
		stackList.push("Directed");
	}

	@Test
	public void testPopStackUsingListUnderflow() throws StackException {
		// Deleting element from an Empty Stack
		stackList.pop();
		stackList.pop();
		stackList.pop();
		stackList.pop();
		ex.expect(StackException.class);
		ex.expectMessage("Stack Underflow");
		stackList.pop();
	}
}
