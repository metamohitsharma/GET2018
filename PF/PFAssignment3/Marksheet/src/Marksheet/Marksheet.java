package Marksheet;

import java.util.Scanner;

/**
 * Computes different operations on grades of Students
 * 
 * @author Mohit Sharma
 *
 */
public class Marksheet {
	double gradesOfStudents[];
	int noOfStudents;

	public Marksheet(int noOfStudents) {
		this.noOfStudents = noOfStudents;
		gradesOfStudents = new double[noOfStudents];
	}

	/**
	 * It initializes the Grades of Students
	 */
	void initializeGrades() {
		Scanner inputGrades = new Scanner(System.in);
		for (int i = 0; i < noOfStudents; i++) {
			System.out.println("Enter the grade for Student " + (i + 1)
					+ " between 0 to 100");
			gradesOfStudents[i] = inputGrades.nextDouble();
		}
	}

	/**
	 * Computes Average of all Grades
	 * 
	 * @return
	 */
	double averageOfGrades() {
		double averageGrades = 0;
		for (int i = 0; i < noOfStudents; i++) {
			averageGrades = averageGrades + gradesOfStudents[i];
		}
		return (double) averageGrades / noOfStudents;
	}

	/**
	 * Computes Maximum of all Grades
	 * 
	 * @return
	 */
	double maximumGrade() {
		double maxGrade = gradesOfStudents[0];
		for (int i = 1; i < noOfStudents; i++) {
			if (maxGrade < gradesOfStudents[i]) {
				maxGrade = gradesOfStudents[i];
			}
		}
		return maxGrade;
	}

	/**
	 * Computes Minimum of all Grades
	 * 
	 * @return
	 */
	double minimumGrade() {
		double minGrade = gradesOfStudents[0];
		for (int i = 1; i < noOfStudents; i++) {
			if (minGrade > gradesOfStudents[i]) {
				minGrade = gradesOfStudents[i];
			}
		}
		return minGrade;
	}

	/**
	 * Computes Percentage of Passed Students
	 * 
	 * @return
	 */
	double percentOfPassedStudents() {
		int noOfPassedStudents = 0;
		for (int i = 0; i < noOfStudents; i++) {
			if (gradesOfStudents[i] >= 40) {
				noOfPassedStudents++;
			}
		}
		return (double) noOfPassedStudents / noOfStudents * 100;
	}

	/**
	 * Checks whether the grades are in range of 0 to 100
	 * 
	 * @return
	 */
	boolean checkEnteredGrades() {
		for (int i = 0; i < noOfStudents; i++) {
			if (gradesOfStudents[i] > 100 || gradesOfStudents[i] < 0) {
				return true;
			}
		}
		return false;
	}
}
