package GET2018.DSA.DSSession1.Stack;

import java.util.LinkedList;
import GET2018.DSA.DSSession1.Stack.StackArray.StackException;

/**
 * It is used for implementation of Stack using Linked List
 * 
 * @author Mohit Sharma
 *
 */
public class StackLinkedList implements Stack {
	private int topElement = -1;
	LinkedList<String> stackLinkedList = new LinkedList<>();

	@Override
	public boolean push(String newElement) throws StackException {
		if (newElement == null) {
			throw new NullPointerException("Element to be Added Can't be Null");
		}
		if (topElement == STACK_SIZE) {
			throw new StackException("Element can't be Add, Stack is Full");
		}
		topElement++;
		stackLinkedList.add(newElement);
		return true;
	}

	@Override
	public String pop() throws StackException {
		if (topElement == -1) {
			throw new StackException("Stack Underflow");
		}
		String deletedItem;
		deletedItem = stackLinkedList.remove(topElement);
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
			throw new StackException("Stack is Empty");
		} else {
			return stackLinkedList.get(topElement);
		}
	}
}
