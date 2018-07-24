package GET2018.PF.PFAssignment1.StackUsingArray;

import java.util.Scanner;

/**
 * It contains the main method which implements the StackArray class
 * 
 * @author Mohit Sharma
 *
 */
public class Implementation {
	/**
	 * It is the main method of the Program, it implements Stack using Array
	 * 
	 * @param args
	 *            command line argument
	 */
	public static void main(String[] args) {
		StackArray stackArray = new StackArray();
		boolean status;
		while (true) {
			System.out
					.println("Choose any Operation:\n1. Push Element\n2. Pop Element\n"
							+ "3. Check whether Stack is empty or not\n4. Topmost Element\n5. Exit");
			String operation = new Scanner(System.in).nextLine();
			switch (operation) {
			case "1":

				System.out.println("Enter the Element to be addded");
				String enteredElement = new Scanner(System.in).nextLine();
				status = stackArray.push(enteredElement);
				if (status) {
					System.out.println("Element Entered");
				}
				break;

			case "2":
				String deletedElement = stackArray.pop();
				System.out.println("Deleted Element:- " + deletedElement);
				break;

			case "3":
				status = stackArray.isEmpty();
				if (status) {
					System.out.println("Stack is Empty");
				} else {
					System.out.println("Stack is not Empty");
				}
				break;

			case "4":
				String topElement = stackArray.top();
				System.out.println("Topmost Element:- " + topElement);
				break;

			case "5":
				System.exit(1);

			default:
				System.out.println("Wrong Input");
			}
		}
	}
}
