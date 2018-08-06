package GET2018.DSA.DSSession2.InfixToPostfix;

/**
 * It implements various operations on Stack
 * 
 * @author Mohit Sharma
 *
 */
public interface Stack {
	int STACK_SIZE = 4;

	/**
	 * Push the given element to Stack
	 * 
	 * @param newElement
	 * @return true if newElement is pushed to Stack
	 * @throws GET2018.DSA.DSSession2.InfixToPostfix.StackArray.NestedListException
	 */
	public boolean push(String newElement) throws StackArrayException;

	/**
	 * Pop the Top Element in Stack
	 * 
	 * @return Popped Element from Stack
	 */
	public String pop() throws StackArrayException;

	/**
	 * It checks whether the Stack is Empty or not
	 * 
	 * @return true if the Stack is Empty
	 */
	public boolean isEmpty();

	/**
	 * It returns the Top Element of Stack
	 * 
	 * @return Top Element Stored at Stack
	 */
	public String top() throws StackArrayException;
}
