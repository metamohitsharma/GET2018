package GET2018.PF.PFAssignment6.Polynomial;

import java.text.DecimalFormat;

/**
 * This Immutable class performs various operations on Single Variable
 * Polynomial equation
 * 
 * @author Mohit Sharma
 *
 */
public final class Poly {
	final int polyInput[][];

	public Poly(int inputPolyArray[][]) throws PolynomialException {
		if (inputPolyArray == null) {
			throw new NullPointerException("Input Array is Null");
		}
		if (inputPolyArray.length == 0) {
			throw new PolynomialException("Array Length can't be Zero");
		}
		if (inputPolyArray[0].length != 2) {
			throw new PolynomialException("Array Width can't be more or less than 2");
		}
		int finalPolyArray[][] = new int[inputPolyArray.length][2];
		int finalLengthOfArray = 0;
		int lengthOfInputArray;
		Poly.sortArray(inputPolyArray, inputPolyArray.length);
		lengthOfInputArray = Poly.mergeArrayValues(inputPolyArray, inputPolyArray.length);
		/*
		 * Adding Coefficients and Degree to finalPolyArray and avoiding Zero
		 * Coefficients
		 */
		for (int i = 0; i < lengthOfInputArray; i++) {
			if (inputPolyArray[i][0] != 0) {
				finalPolyArray[finalLengthOfArray][0] = inputPolyArray[i][0];
				finalPolyArray[finalLengthOfArray][1] = inputPolyArray[i][1];
				finalLengthOfArray++;
			}
		}
		polyInput = new int[finalLengthOfArray][2];
		for (int i = 0; i < finalLengthOfArray; i++) {
			polyInput[i][0] = finalPolyArray[i][0];
			polyInput[i][1] = finalPolyArray[i][1];
		}
	}

	/**
	 * Return the value of the polynomial for the given value of the variable
	 * 
	 * @param valueOfVariable
	 * @return
	 */
	public double evaluate(double valueOfVariable) {
		double evaluation = 0;
		DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");
		for (int i = 0; i < polyInput.length; i++) {
			evaluation += polyInput[i][0] * Math.pow(valueOfVariable, polyInput[i][1]);
		}
		return Double.parseDouble(decimalFormatSpecifier.format(evaluation));
	}

	/**
	 * Return the degree of the polynomial
	 * 
	 * @return
	 */
	public int degree() {
		int maxDegree = 0;
		for (int i = 0; i < polyInput.length; i++) {
			if (i == 0) {
				maxDegree = polyInput[i][1];
			} else if (maxDegree < polyInput[i][1]) {
				maxDegree = polyInput[i][1];
			}
		}
		return maxDegree;
	}

	/**
	 * Return the Addition of Two Polynomials
	 * 
	 * @param polynomial1
	 * @param polynomial2
	 * @return
	 */
	public static int[][] addPoly(Poly polynomial1, Poly polynomial2) {
		int addPoly[][] = new int[polynomial1.polyInput.length + polynomial2.polyInput.length][2];
		int lengthOfAddPoly = 0;
		int finalAddPoly[][];

		/*
		 * Addition of the Coefficients of Same powers and for different powers just
		 * Inserting them in addPoly[][]
		 */
		int indexOfPoly1 = 0;
		int indexOfPoly2 = 0;
		for (indexOfPoly1 = 0; indexOfPoly1 < polynomial1.polyInput.length
				&& indexOfPoly2 < polynomial2.polyInput.length;) {
			if (polynomial1.polyInput[indexOfPoly1][1] == polynomial2.polyInput[indexOfPoly2][1]) {
				addPoly[lengthOfAddPoly][0] = polynomial1.polyInput[indexOfPoly1][0]
						+ polynomial2.polyInput[indexOfPoly1][0];
				addPoly[lengthOfAddPoly][1] = polynomial1.polyInput[indexOfPoly1][1];
				lengthOfAddPoly++;
				indexOfPoly1++;
				indexOfPoly2++;
			} else if (polynomial1.polyInput[indexOfPoly1][1] < polynomial2.polyInput[indexOfPoly2][1]) {
				addPoly[lengthOfAddPoly][0] = polynomial1.polyInput[indexOfPoly1][0];
				addPoly[lengthOfAddPoly][1] = polynomial1.polyInput[indexOfPoly1][1];
				lengthOfAddPoly++;
				indexOfPoly1++;
			} else {
				addPoly[lengthOfAddPoly][0] = polynomial2.polyInput[indexOfPoly2][0];
				addPoly[lengthOfAddPoly][1] = polynomial2.polyInput[indexOfPoly2][1];
				lengthOfAddPoly++;
				indexOfPoly2++;
			}
		}

		/*
		 * Inserting Remaining Coefficients of Polynomial1 in addPoly[][]
		 */
		while (indexOfPoly1 < polynomial1.polyInput.length) {
			addPoly[lengthOfAddPoly][0] = polynomial1.polyInput[indexOfPoly1][0];
			addPoly[lengthOfAddPoly][1] = polynomial1.polyInput[indexOfPoly1][1];
			lengthOfAddPoly++;
			indexOfPoly1++;
		}

		/*
		 * Inserting Remaining Coefficients of Polynomial2 in addPoly[][]
		 */
		while (indexOfPoly2 < polynomial2.polyInput.length) {
			addPoly[lengthOfAddPoly][0] = polynomial2.polyInput[indexOfPoly2][0];
			addPoly[lengthOfAddPoly][1] = polynomial2.polyInput[indexOfPoly2][1];
			lengthOfAddPoly++;
			indexOfPoly2++;
		}
		Poly.sortArray(addPoly, lengthOfAddPoly);
		finalAddPoly = new int[lengthOfAddPoly][2];
		for (int i = 0; i < lengthOfAddPoly; i++) {
			finalAddPoly[i][0] = addPoly[i][0];
			finalAddPoly[i][1] = addPoly[i][1];
		}
		return finalAddPoly;
	}

	/**
	 * Return the Multiplication of Two Polynomials
	 * 
	 * @param polynomial1
	 * @param polynomial2
	 * @return
	 */
	public static int[][] multiplyPoly(Poly polynomial1, Poly polynomial2) {
		int multiplyPoly[][] = new int[polynomial1.polyInput.length * polynomial2.polyInput.length][2];
		int lengthOfMultiplyPoly = 0;
		int finalMultiplyPoly[][];
		int finalLengthOfMultiplyPoly;

		/*
		 * Multiplying Every Coefficient and Powers of Polynomials with each other
		 */
		for (int i = 0; i < polynomial1.polyInput.length; i++) {
			for (int j = 0; j < polynomial2.polyInput.length; j++) {
				multiplyPoly[lengthOfMultiplyPoly][0] = polynomial1.polyInput[i][0] * polynomial2.polyInput[j][0];
				multiplyPoly[lengthOfMultiplyPoly][1] = polynomial1.polyInput[i][1] + polynomial2.polyInput[j][1];
				lengthOfMultiplyPoly++;
			}
		}
		Poly.sortArray(multiplyPoly, lengthOfMultiplyPoly);
		finalLengthOfMultiplyPoly = Poly.mergeArrayValues(multiplyPoly, lengthOfMultiplyPoly);
		finalMultiplyPoly = new int[finalLengthOfMultiplyPoly][2];
		for (int i = 0; i < finalLengthOfMultiplyPoly; i++) {
			finalMultiplyPoly[i][0] = multiplyPoly[i][0];
			finalMultiplyPoly[i][1] = multiplyPoly[i][1];
		}
		return finalMultiplyPoly;
	}

	/**
	 * Sort Array using Bubble Sort
	 * 
	 * @param sortArray
	 * @param lengthOfArray
	 */
	private static void sortArray(int sortArray[][], int lengthOfArray) {
		for (int i = 0; i < lengthOfArray - 1; i++) {
			for (int j = 0; j < lengthOfArray - i - 1; j++) {
				if (sortArray[j][1] > sortArray[j + 1][1]) {
					int temp = sortArray[j][1];
					sortArray[j][1] = sortArray[j + 1][1];
					sortArray[j + 1][1] = temp;
					temp = sortArray[j][0];
					sortArray[j][0] = sortArray[j + 1][0];
					sortArray[j + 1][0] = temp;
				}
			}
		}
	}

	/**
	 * Adds Coefficients of Same Power in mergeArray[][]
	 * 
	 * @param mergeArray
	 * @param lengthOfArray
	 * @return
	 */
	private static int mergeArrayValues(int mergeArray[][], int lengthOfArray) {
		int finalLengthOfArray = 1;
		for (int i = 0, j = 0; j + 1 < lengthOfArray;) {
			if (mergeArray[j][1] == mergeArray[j + 1][1]) {
				mergeArray[i][0] += mergeArray[j + 1][0];
				j++;
			} else if (mergeArray[j][1] != mergeArray[j + 1][1]) {
				i++;
				mergeArray[i][0] = mergeArray[j + 1][0];
				mergeArray[i][1] = mergeArray[j + 1][1];
				finalLengthOfArray++;
				j++;
			}
		}
		return finalLengthOfArray;
	}

	@SuppressWarnings("serial")
	class PolynomialException extends Exception {
		String messageException;

		public PolynomialException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
