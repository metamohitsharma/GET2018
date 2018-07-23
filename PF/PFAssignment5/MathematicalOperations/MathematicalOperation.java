package GET2018.PF.PFAssignment5.MathematicalOperations;

/**
 * This class computes GCD and LCM of input number
 * 
 * @author Mohit Sharma
 *
 */
public class MathematicalOperation {

	/**
	 * Computes Greatest Common Divisor of firstNumber and secondNumber
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	int calculateGCD(int firstNumber, int secondNumber) {
		if (secondNumber == 0) {
			return firstNumber;
		}
		return calculateGCD(secondNumber, firstNumber % secondNumber);
	}

	/**
	 * Computes Least Common Multiple of firstNumber and secondNumber
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	int calculateLCM(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber / calculateGCD(firstNumber, secondNumber);
	}
}
