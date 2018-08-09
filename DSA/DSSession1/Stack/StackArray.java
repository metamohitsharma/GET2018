package GET2018.DSA.DSSession1.Stack;

/**
 * This class describes the implementation of Stack using array.
 * 
 * @author Mohit Sharma
 *
 */
public class StackArray implements Stack {
	int topElement = -1;
	String stackArray[] = new String[5];

	@Override
	public boolean push(String newElement) throws StackException {
		if (newElement == null) {
			throw new NullPointerException("Element to be Added Can't be Null");
		}
		if (topElement == STACK_SIZE) {
			throw new StackException("Element can't be Add, Stack is Full");
		}
		topElement++;
		stackArray[topElement] = newElement;
		return true;
	}

	@Override
	public String pop() throws StackException {
		String deletedItem;
		if (topElement == -1) {
			throw new StackException("Stack Underflow");
		}
		deletedItem = stackArray[topElement];
		topElement--;
		return deletedItem;
	}

	@Override
	public boolean isEmpty() {
		return (topElement == -1 ? true : false);
	}

	@Override
	public String top() throws StackException {
		if (topElement == -1) {
			throw new StackException("Stack Underflow");
		} else {
			return stackArray[topElement];
		}
	}
}
