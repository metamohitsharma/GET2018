package GET2018.DSA.DSSession2.CircularQueue;

/**
 * This is custom Exception class for Circular Queue
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
public class QueueException extends Exception {
	String messageException;

	public QueueException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessage() {
		return messageException;
	}
}
