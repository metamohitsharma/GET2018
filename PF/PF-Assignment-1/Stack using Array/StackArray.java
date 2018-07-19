package StackArray;

/**
 * This class describes the implementation of Stack using array.
 * 
 * @author Mohit Sharma
 *
 */
public class StackArray {
	protected String stackArray[] = new String[5];
	private final int STACK_SIZE = 4;
	private int topElement = -1;

	/**
	 * Push the given element to Stack
	 * 
	 * @param new_element to be pushed to Stack
	 * @return true if new_element is pushed to Stack
	 * @throws StackException, if the Stack Overflows
	 */
	public boolean push(String newElement) throws ArrayIndexOutOfBoundsException {
		try {
			if (topElement == STACK_SIZE) {
				throw new ArrayIndexOutOfBoundsException("Stack Overflow");
			}
			topElement++;
			stackArray[topElement] = newElement;
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * Pop the Top Element in Stack
	 * 
	 * @return Popped Element from Stack
	 * @throws StackException, if the Stack Underflows
	 */
	public String pop() throws ArrayIndexOutOfBoundsException {
		try {
			String deletedItem;
			if (topElement == -1) {
				throw new ArrayIndexOutOfBoundsException("Stack Underflow");
			}
			deletedItem = stackArray[topElement];
			topElement--;
			return deletedItem;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			return "false";
		}
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
	public String top() throws ArrayIndexOutOfBoundsException {
		try {
			if (topElement == -1) {
				throw new ArrayIndexOutOfBoundsException("Stack Underflow");
			} else {
				return stackArray[topElement];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			return "false";
		}
	}
}
