package GET2018.DSA.DSSession1.Stack;

/**
 * This is a Custom Exception class for Stack
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
class StackException extends Exception {
	String messageException;

	public StackException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessage() {
		return messageException;
	}
}