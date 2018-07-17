/**
 * StackException Class used for Overflow and Underflow Stack Exception
 * @author user37
 *
 */
@SuppressWarnings("serial")
public class StackException extends Exception {
    String 	Message;
    
    public StackException(String msg) {
        Message = msg;
    }

    @Override
    public String getMessage() {
        return Message; 
    }   
}