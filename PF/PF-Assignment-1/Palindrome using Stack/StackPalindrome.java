import java.util.Stack;
import java.util.Scanner;

/**
 * This Class checks whether a String is Palindrome or not using Stack
 * @author Mohit
 *
 */
class StackPalindrome {
	public static void main(String[] args) {
	    	System.out.println("Enter any string:");
	        Scanner input = new Scanner(System.in);
	        String inputString = input.nextLine();
	        String reverseString = StackPalindrome.palindrome(inputString);
	        if (reverseString.equals(inputString)) {
	        	System.out.println("The Input String is a palindrome.");
	        } else {
	        	System.out.println("The Input String is not a palindrome.");
	        }     
	}
	
	/**
	*This method checks whether the String is palindrome or not
	*param@ inputString
	*return reverseString, reversed string of the entered string
	**/
	public static String palindrome(String inputString) {
		Stack<Character> stack = new Stack<Character>();
	        for (int i = 0; i < inputString.length(); i++) {
	        	stack.push(inputString.charAt(i));
	        }
	        String reverseString = "";
	        while (!stack.isEmpty()) {
	        	reverseString = reverseString + stack.pop();
	        }
	        return reverseString;
	}
}
