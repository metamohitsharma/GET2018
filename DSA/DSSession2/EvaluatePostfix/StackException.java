package GET2018.DSA.DSSession2.EvaluatePostfix;

/**
 * This is custom Exception class for Stack
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
public class StackException extends Exception {
	String messageException;

	public StackException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessageException() {
		return messageException;
	}
}
