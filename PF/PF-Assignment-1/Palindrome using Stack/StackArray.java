package StackPalindrome;

/**
 * This class describes the implementation of Stack using array.
 * 
 * @author Mohit Sharma
 *
 */
public class StackArray {
	protected char stackArray[] = new char[50];
	private final int STACK_SIZE = 49;
	private int topElement = -1;

	/**
	 * Push the given element to Stack
	 * 
	 * @param new_element to be pushed to Stack
	 * @return true if new_element is pushed to Stack
	 * @throws StackException, if the Stack Overflows
	 */
	public boolean push(char newElement) throws ArrayIndexOutOfBoundsException {
		if (topElement == STACK_SIZE) {
			throw new ArrayIndexOutOfBoundsException("Stack Overflow");
		}
		topElement++;
		stackArray[topElement] = newElement;
		return true;

	}

	/**
	 * Pop the Top Element in Stack
	 * 
	 * @return Popped Element from Stack
	 * @throws StackException, if the Stack Underflows
	 */
	public char pop() throws ArrayIndexOutOfBoundsException {
		char deletedItem;
		if (topElement == -1) {
			throw new ArrayIndexOutOfBoundsException("Stack Underflow");
		}
		deletedItem = stackArray[topElement];
		topElement--;
		return deletedItem;
	}

	/**
	 * It checks whether the Stack is Empty or not
	 * 
	 * @return true if the Stack is Empty
	 * @throws StackException
	 */
	public boolean isEmpty() {
		return (topElement == -1 ? true : false);
	}

	/**
	 * It returns the Top Element of Stack
	 * 
	 * @return Top Element Stored at Stack
	 * @throws StackException, if Stack Underflows
	 */
	public char top() throws ArrayIndexOutOfBoundsException {
		if (topElement == -1) {
			throw new ArrayIndexOutOfBoundsException("Stack Underflow");
		} else {
			return stackArray[topElement];
		}
	}
}
