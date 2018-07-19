package StackLinkedList;

import java.util.Scanner;

/**
 * It contains the main method that implements Stack using Linked List
 * 
 * @author Mohit Sharma
 *
 */
public class Implementation {
	public static void main(String[] args) {
		StackLinkedList stackLinkedList = new StackLinkedList();
		boolean status;
		while (true) {
			System.out.println("Choose any Operation:\n1. Push Element\n2. Pop Element\n"
					+ "3. Check whether Stack is empty or not\n4. Topmost Element\n5. Exit");
			String operation = new Scanner(System.in).nextLine();
			switch (operation) {
			case "1":
				System.out.println("Enter the Element to be addded");
				String enteredElement = new Scanner(System.in).nextLine();
				status = stackLinkedList.push(enteredElement);
				if (status) {
					System.out.println("Element Entered");
				}
				break;

			case "2":
				String deletedElement = stackLinkedList.pop();
				if (("false").equals(deletedElement)) {
					continue;
				}
				System.out.println("Deleted Element:- " + deletedElement);
				break;

			case "3":
				status = stackLinkedList.isEmpty();
				if (status) {
					System.out.println("Stack is Empty");
				} else {
					System.out.println("Stack is not Empty");
				}
				break;

			case "4":
				String topElement = stackLinkedList.top();
				if (("false").equals(topElement)) {
					continue;
				}
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
