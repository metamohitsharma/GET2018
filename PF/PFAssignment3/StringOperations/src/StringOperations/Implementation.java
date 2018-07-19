package StringOperations;

import java.util.Scanner;

/**
 * It contains the main method which implements the methods of StringOperations
 * class
 * 
 * @author Mohit Sharma
 *
 */
public class Implementation {
	public static void main(String args[]) {
		System.out.println("Enter any String");
		String enteredString = new Scanner(System.in).nextLine();
		StringOperations stringMethods = new StringOperations(enteredString);
		while (true) {
			System.out.println("Enter the operation you want to execute:\n1.Check whether the Entered String is "
							+ "equal to other String\n2.Reverse String\n3.Replace Lowercase with Uppercase "
							+ "and vice-versa\n4.Longest word in String\n5.Exit");
			int operation = new Scanner(System.in).nextInt();
			switch (operation) {
			case 1:
				System.out.println("Enter String whose equality you want to check");
				String checkEqualString = new Scanner(System.in).nextLine();
				System.out.println(stringMethods.isEquals(checkEqualString));
				break;

			case 2:
				System.out.println("Reverse of String:- "
						+ stringMethods.reverseString());
				break;

			case 3:
				System.out.println("Replaced String:- "
						+ stringMethods.viceVersa());
				break;

			case 4:
				System.out.println("Longest Word in String:- "
						+ stringMethods.longestWord());
				break;

			case 5:
				System.exit(1);

			default:
				System.out.println("Wrong Input");
			}
		}
	}
}
