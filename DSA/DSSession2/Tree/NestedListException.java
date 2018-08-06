package GET2018.DSA.DSSession2.Tree;

/**
 * This is custom Exception class for NestedList
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
public class NestedListException extends Exception {
	String messageException;

	public NestedListException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessageException() {
		return messageException;
	}
}
