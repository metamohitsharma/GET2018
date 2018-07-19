package StackLinkedList;

import java.util.LinkedList;

/**
 * It is used for implementation of Stack using Linked List
 * 
 * @author Mohit Sharma
 *
 */
public class StackLinkedList {
	protected LinkedList<String> stackLinkedList = new LinkedList<>();
	private final int STACK_SIZE = 4;
	private int topElement = -1;

	/**
	 * It pushes the given element to Stack
	 * 
	 * @param new_element, the element to be entered
	 * @return true if the element is pushed to stack
	 * @throws StackException, when Stack Overflows
	 */
	public boolean push(String newElement) throws ArrayIndexOutOfBoundsException {
		try {
			if (topElement == STACK_SIZE) {
				throw new ArrayIndexOutOfBoundsException("Stack Overflow");
			}
			topElement++;
			stackLinkedList.add(newElement);
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * It pops topmost element of Stack
	 * 
	 * @return the popped element
	 * @throws StackException, if Stack Underflows
	 */
	public String pop() throws ArrayIndexOutOfBoundsException {
		try {
			if (topElement == -1) {
				throw new ArrayIndexOutOfBoundsException("Stack Underflow");
			}
			String deletedItem;
			deletedItem = stackLinkedList.remove(topElement);
			topElement--;
			return deletedItem;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			return "false";
		}
	}

	/**
	 * It checks whether Stack is Empty
	 * 
	 * @return true if Stack is empty
	 */
	public boolean isEmpty() {
		return (topElement == -1 ? true : false);
	}

	/**
	 * It returns the Topmost Element of Stack
	 * 
	 * @return top element of Stack
	 * @throws StackException, if Stack Underflows
	 */
	public String top() throws ArrayIndexOutOfBoundsException {
		try {
			if (topElement == -1) {
				throw new ArrayIndexOutOfBoundsException("Stack is Empty");
			} else {
				return stackLinkedList.get(topElement);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			return "false";
		}
	}
}
