package GET2018.DSA.DSSession4.Employee;

/**
 * This is custom Exception class for Employee
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
public class EmployeeException extends Exception {
	String message;

	public EmployeeException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
