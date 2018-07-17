
import java.util.LinkedList;

/**
 * It is used for implementation of Stack using Linked List
 * @author user37
 *
 */
class StackLinkedList {
	protected LinkedList<String> 	stack = new LinkedList<>();
	private final int 		STACK_SIZE = 4;
	private int 			topElement = -1;
    
	/**
     	* It pushes the given element to Stack
     	* @param new_element, the element to be entered
     	* @return true if the element is pushed to stack
     	* @throws StackException, when Stack Overflows
     	*/
	public boolean push(String newElement) throws StackException {
		if (topElement == STACK_SIZE) {
	            throw new StackException("Stack Overflow");
	        }
		topElement++;
	        stack.add(newElement);
	        return true;
	}
	
	/**
	 * It pops topmost element of Stack
	 * @return the popped element
	 * @throws StackException, if Stack Underflows
	 */
	public String pop() throws StackException {
		if (topElement == -1) {
			throw new StackException("Stack Underflow");
		}
		String deletedItem;
		deletedItem = stack.remove(topElement);
		topElement--;
		return deletedItem;
	}
	
	/**
	 * It checks whether Stack is Empty
	 * @return true if Stack is empty
	 */
	public boolean isEmpty() {
		if (topElement == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * It returns the Topmost Element of Stack
	 * @return top element of Stack
	 * @throws StackException, if Stack Underflows
	 */
	public String top() throws StackException {
		if (topElement == -1) {
			throw new StackException("Stack is Empty");
		} else {
			return stack.get(topElement);
		} 
	}
}

