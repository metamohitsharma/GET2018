package Marksheet;

import java.util.Scanner;

/**
 * It contains the main method which implements the Operations in Marksheet
 * class
 * 
 * @author Mohit Sharma
 *
 */
public class Implementation {
	public static void main(String args[]) {
		int noOfstudents;
		int choiceOfOperation;
		System.out.println("Enter the no of Students whose grades you want to upload");
		Scanner inputNumber = new Scanner(System.in);
		noOfstudents = inputNumber.nextInt();
		if (noOfstudents <= 0) {
			System.out.println("No of Students can't be Zero or negative");
			System.exit(1);
		}
		Marksheet marksheetOfStudents = new Marksheet(noOfstudents);
		marksheetOfStudents.initializeGrades();
		if (marksheetOfStudents.checkEnteredGrades()) {
			System.out.println("Entered grades should only be from 0 to 100");
			System.exit(1);
		}
		while (true) {
			System.out.println("Enter the operation you want to perform\n1. Average of Grades\n2.Maximum of Grades\n"
							+ "3.Minimum of Grades\n4.Percent of Students Passed\n5.Exit");
			choiceOfOperation = inputNumber.nextInt();
			switch (choiceOfOperation) {
			case 1:
				double averageGrade = marksheetOfStudents.averageOfGrades();
				System.out.println("Average of Grades:- " + averageGrade);
				break;

			case 2:
				double maxgrade = marksheetOfStudents.maximumGrade();
				System.out.println("Maximum of Grades:- " + maxgrade);
				break;

			case 3:
				double minGrade = marksheetOfStudents.minimumGrade();
				System.out.println("Minimum of Grades:- " + minGrade);
				break;

			case 4:
				double percentPassedStudents = marksheetOfStudents
						.percentOfPassedStudents();
				System.out.println("Percentage of Passed Students:- "
						+ percentPassedStudents);
				break;

			case 5:
				System.exit(1);

			default:
				System.out.println("Wrong Input");
			}
		}

	}
}
