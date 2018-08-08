package GET2018.DSA.DSSession1.Queue;

/**
 * This is a Custom Exception class for Queue
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
class QueueException extends Exception {
	String messageException;

	public QueueException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessage() {
		return messageException;
	}
}
