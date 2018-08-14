package GET2018.DSA.DSSession2.InfixToPostfix;

/**
 * This is custom Exception class for Stack
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
public class StackArrayException extends Exception {
	String messageException;

	public StackArrayException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessage() {
		return messageException;
	}
}
