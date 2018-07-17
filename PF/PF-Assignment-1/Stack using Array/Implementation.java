import java.util.Scanner;

/**
 * It contains the main method which implements the StackArray class
 * @author user37
 *
 */
public class Implementation {
	
	/**
	 * It is the main method of the Program, it implements Stack using Array
	 * @param args command line argument
	 */
	public static void main(String[] args) {
	        StackArray stackArray = new StackArray();
	        while(true) {
	        	System.out.println("Choose any Operation:\n1. Push Element\n2. Pop Element\n"
				+ "3. Check whether Stack is empty or not\n4. Topmost Element\n5. Exit");
	        	Scanner inputChoice = new Scanner(System.in);
        		String operation = inputChoice.nextLine();
        		switch (operation) {
        		case "1":
        			try {
        				System.out.println("Enter the Element to be addded");
        				String enteredElement = inputChoice.nextLine();
        				boolean status = stackArray.push(enteredElement);
        				if (status) {
        					System.out.println("Element Entered");
        				}
        			} catch (StackException e) {
        				System.out.println(e.getMessage());
        			}
        			break;
			            
        		case "2":
        			try {
        				String deletedElement = stackArray.pop();
        				System.out.println("Deleted Element:- " + deletedElement);
        			} catch (StackException e) {
        				System.out.println(e.getMessage());
        			}
        			break;
			            
        		case "3":
        			boolean status = stackArray.isEmpty();
        			if(status) {
        				System.out.println("Stack is Empty");
        			} else {
        				System.out.println("Stack is not Empty");
        			}
        			break;  
			            
        		case "4":
        			try {
        				String topElement = stackArray.top();
        				System.out.println("Topmost Element:- " + topElement);
        			} catch(StackException e) {
        				System.out.println(e.getMessage());
        			}
        			break;
			            
        		case "5": 
        			System.exit(1);
			        
        		default:
        			System.out.println("Wrong Input");
        		}
	        }
	}
}
