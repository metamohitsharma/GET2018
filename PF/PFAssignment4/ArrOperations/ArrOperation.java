package GET2018.PF.PFAssignment4.ArrOperations;

import java.util.ArrayList;

/**
 * This class contains different operations performed on Array
 * 
 * @author Mohit Sharma
 *
 */
public class ArrOperation {

	/**
	 * Computes largest mirror size in Array Mirror section in an array is a group
	 * of contiguous elements such that somewhere in the array, the same group
	 * appears in reverse order
	 * 
	 * @param mirrorArray
	 * @return largestMirror
	 * @throws ArrOperationException
	 */
	int largestMirror(char mirrorArray[]) throws ArrOperationException {
		if (mirrorArray == null) {
			throw new NullPointerException("Input Array is Null in largestMirror");
		} else if (mirrorArray.length == 0) {
			throw new ArrOperationException("Input Array is Empty in largestMirror");
		}
		int startIndex = 0;
		int endIndex = 0;
		int mirrorSize = 0;
		int maxMirrorSize = 0;

		/*
		 * Checking character equivalence, if found then increasing StartIndex and
		 * decreasing EndIndex and if the countSize of new Mirror is greater than
		 * maxSizeMirror then swap them
		 */
		for (int i = 0; i < mirrorArray.length; i++) {
			startIndex = i;
			mirrorSize = 0;
			endIndex = mirrorArray.length - 1;
			while ((endIndex >= 0) && (startIndex < mirrorArray.length)) {
				if (mirrorArray[startIndex] == mirrorArray[endIndex]) {
					mirrorSize++;
					startIndex++;
					endIndex--;
				} else {
					endIndex--;
					if (maxMirrorSize < mirrorSize) {
						maxMirrorSize = mirrorSize;
					}
					mirrorSize = 0;
				}
			}
			if (maxMirrorSize < mirrorSize) {
				maxMirrorSize = mirrorSize;
			}
			if (maxMirrorSize == mirrorArray.length) {
				return maxMirrorSize;
			}
		}
		return maxMirrorSize;
	}

	/**
	 * Computes number of Clumps in an Array, Clump in an array is a series of 2 or
	 * more adjacent elements of the same value
	 * 
	 * @param clumpsArray
	 * @return numbersOfClumps
	 * @throws ArrOperationException
	 */
	public int numbersOfClumps(char[] clumpsArray) throws ArrOperationException {
		if (clumpsArray == null) {
			throw new NullPointerException("Clump Array is Null");
		} else if (clumpsArray.length == 0) {
			throw new ArrOperationException("Clump Array is Empty");
		} else if (clumpsArray.length == 1) {
			return 0;
		}
		int noOfClumps = 0;
		int startClump = 0; // This Variable is used to store Clump's starting Index

		/*
		 * Iterating over clumpsArray, Checking Element at i Index is equal to Element
		 * at i+1 Index then if i is Equal to the Starting Index of Clump then
		 * increasing noOfClumps
		 */
		for (int i = 0; i < clumpsArray.length - 1; i++) {
			if (clumpsArray[i] == clumpsArray[i + 1]) {
				if (startClump == i) {
					noOfClumps++;
				}
			} else {
				startClump = i + 1;
			}
		}
		return noOfClumps;
	}

	/**
	 * Rearranges Array so that every X is immediately followed by a Y
	 * 
	 * @param x
	 * @param y
	 * @param arrayToFixXy
	 * @return
	 * @throws ArrOperationException
	 */
	public char[] fixXy(char x, char y, char[] arrayToFixXY) throws ArrOperationException {
		if (arrayToFixXY == null) {
			throw new NullPointerException("ArrayToFixXY is Null");
		} else if (x == '\0') {
			throw new NullPointerException("Given X is Null");
		} else if (y == '\0') {
			throw new NullPointerException("Given Y is Null");
		} else if (arrayToFixXY.length == 0) {
			throw new ArrOperationException("ArrayToFixXY is Empty");
		} else if (arrayToFixXY.length == 1) {
			throw new ArrOperationException("ArrayToFixXY should atleast have two Elements");
		}
		char[] copyOfFixArray = arrayToFixXY;
		if (x == copyOfFixArray[copyOfFixArray.length - 1]) {
			throw new ArrOperationException(x + " is at Last Index");
		}

		/*
		 * Taking Two ArrayList to save the Indexes of X and Y Element so that Y could
		 * be placed right after X
		 */
		ArrayList<Integer> xIndex = new ArrayList<Integer>();
		ArrayList<Integer> yIndex = new ArrayList<Integer>();
		for (int i = 0; i < copyOfFixArray.length; i++) {
			if (copyOfFixArray[i] == x) {
				xIndex.add(i);
			}
			if (copyOfFixArray[i] == y) {
				yIndex.add(i);
			}
		}
		if (xIndex.size() != yIndex.size()) {
			throw new ArrOperationException("No of " + x + " and " + y + " are not Equal");
		}

		/*
		 * Iterating over xIndex ArrayList, swapping the Next Element after X to Y
		 * Element
		 */
		for (int i = 0; i < xIndex.size(); i++) {
			if (i != xIndex.size() - 1 && xIndex.get(i) == xIndex.get(i + 1)) {
				throw new ArrOperationException("Two " + x + " at adjacent Positions");
			}
			char swapY = copyOfFixArray[xIndex.get(i) + 1];
			copyOfFixArray[xIndex.get(i) + 1] = copyOfFixArray[yIndex.get(i)];
			copyOfFixArray[yIndex.get(i)] = swapY;
		}
		return copyOfFixArray;
	}

	/**
	 * Return the index if there is a place to split the input array so that the sum
	 * of the numbers on one side is equal to the sum of the numbers on the other
	 * side else return -1
	 * 
	 * @param enteredArray
	 * @return
	 * @throws ArrOperationException
	 */
	public int splitArray(int[] enteredArray) throws ArrOperationException {
		if (enteredArray == null) {
			throw new NullPointerException("Array is Null in SplitArray");
		} else if (enteredArray.length == 0) {
			throw new ArrOperationException("Array is Empty in SplitArray");
		} else if (enteredArray.length == 1) {
			throw new ArrOperationException("Array Length should be atleast 2 in SplitArray");
		}
		int leftHalf = 0;
		int rightHalf = 0;
		int splitIndex = -1;

		/*
		 * Adding all the Elements of Array from Right Side
		 */
		for (int i = 0; i < enteredArray.length; i++) {
			rightHalf += enteredArray[i];
		}

		/*
		 * Iterating over Array from Left and checking the Equality of Left and Right
		 * side sum
		 */
		for (int i = 0; i < enteredArray.length; i++) {
			if (leftHalf == rightHalf) {
				splitIndex = i;
				break;
			} else {
				leftHalf += enteredArray[i];
				rightHalf -= enteredArray[i];
			}
		}
		return splitIndex;
	}

	@SuppressWarnings("serial")
	static class ArrOperationException extends Exception {
		String messageException;

		public ArrOperationException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
