package GET2018.DSA.DSSession3.VirtualCommandPrompt;

/**
 * This is custom Exception class for Command Prompt
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
public class CommandPromptException extends Exception {
	String messageException;

	public CommandPromptException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessage() {
		return messageException;
	}
}
