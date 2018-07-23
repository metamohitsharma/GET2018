package GET2018.PF.PFAssignment1.PalindromeUsingStack;

import java.util.Scanner;

/**
 * This Class checks whether a String is Palindrome or not using Stack
 * 
 * @author Mohit Sharma
 *
 */
public class StackPalindrome {
	public static void main(String[] args) {
		System.out.println("Enter any string:");
		String inputString = new Scanner(System.in).nextLine();
		String reverseString = StackPalindrome.palindrome(inputString);
		if (reverseString.equals(inputString)) {
			System.out.println("The Input String is a palindrome.");
		} else {
			System.out.println("The Input String is not a palindrome.");
		}
	}

	/**
	 * This method checks whether the String is palindrome or not param@
	 * inputString return reverseString, reversed string of the entered string
	 **/
	public static String palindrome(String inputString) {
		StackArray stackArray = new StackArray();
		for (int i = 0; i < inputString.length(); i++) {
			stackArray.push(inputString.charAt(i));
		}
		String reverseString = "";
		while (!stackArray.isEmpty()) {
			reverseString = reverseString + stackArray.pop();
		}
		return reverseString;
	}
}
