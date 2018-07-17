
/**
 * This class describes the implementation of Stack using array.
 * @author user37
 *
 */
class StackArray {
	protected String	stack[] = new String[5];
	private final int 	STACK_SIZE = 4;
	private int 		topElement = -1;
	
	/**
	 * Push the given element to Stack
	 * @param new_element to be pushed to Stack
	 * @return true if new_element is pushed to Stack
	 * @throws StackException, if the Stack Overflows
	 */
	public boolean push(String new_element) throws StackException {
	        if (topElement == STACK_SIZE) {
	            throw new StackException("Stack Overflow");
	        }
	        topElement++;
	        stack[topElement]=new_element;
	        return true;
        }
	
	/**
	 * Pop the Top Element in Stack
	 * @return Popped Element from Stack 
	 * @throws StackException, if the Stack Underflows
	 */
	public String pop() throws StackException {
		String	deletedItem;
	        if (topElement == -1) {
	            throw new StackException("Stack Underflow");
	        }
	        deletedItem = stack[topElement];
	        topElement--;
	        return deletedItem;
        }
	
	/**
	 * It checks whether the Stack is Empty or not
	 * @return true if the Stack is Empty
	 * @throws StackException
	 */
	public boolean isEmpty() {
	        if (topElement == -1) {
	            return true;
	        } else {
	            return false;
	        }
	}
	
	/**
	 * It returns the Top Element of Stack
	 * @return Top Element Stored at Stack
	 * @throws StackException, if Stack Underflows
	 */
	public String top() throws StackException {
	        if (topElement == -1) {
	            throw new StackException("Stack Underflow");
	        } else {
	            return stack[topElement];
	        } 
	}
}