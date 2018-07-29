package GET2018.PF.PFAssignment3.Marksheet;

import java.text.DecimalFormat;

/**
 * Computes different operations on grades of Students
 * 
 * @author Mohit Sharma
 *
 */
public class Marksheet {
	double gradesOfStudents[];
	int noOfStudents;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	public Marksheet(int noOfStudents, double[] gradesInput) throws MarksheetException {
		if (noOfStudents <= 0) {
			throw new MarksheetException("No Of Students can't be Zero or Negative");
		}
		this.noOfStudents = noOfStudents;
		gradesOfStudents = new double[noOfStudents];
		for (int i = 0; i < noOfStudents; i++) {
			if (gradesInput[i] >= 0 && gradesInput[i] <= 100) {
				continue;
			} else {
				throw new MarksheetException("Enter Grades in 0 to 100 range only");
			}
		}
		gradesOfStudents = gradesInput;
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
		return Double.parseDouble(decimalFormatSpecifier.format((double) averageGrades / noOfStudents));
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
		return Double.parseDouble(decimalFormatSpecifier.format(maxGrade));
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
		return Double.parseDouble(decimalFormatSpecifier.format(minGrade));
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
		return Double.parseDouble(decimalFormatSpecifier.format((double) noOfPassedStudents / noOfStudents * 100));
	}

	@SuppressWarnings("serial")
	static class MarksheetException extends Exception {
		String messageException;

		public MarksheetException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
