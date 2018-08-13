package GET2018.DSA.DSSession3.BowlerStrategy;

/**
 * This is custom Exception class for BowlerStrategy
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
public class StrategyException extends Exception {
	String exception;

	public StrategyException(String exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return exception;
	}
}
