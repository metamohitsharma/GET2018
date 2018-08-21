package GET2018.DBMS.DBMSSession5;

/**
 * This is custom Exception class for StoreFront
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
public class StoreFrontException extends Exception {
	String messageException;

	public StoreFrontException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessage() {
		return messageException;
	}
}
