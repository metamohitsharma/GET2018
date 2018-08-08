package GET2018.SCF.SCFSession9.GraphicsLibrary;

/**
 * This is a custom Exception class
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
class ScreenException extends Exception {
	String messageException;

	public ScreenException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessage() {
		return messageException;
	}
}
