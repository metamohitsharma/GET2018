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
	 * Computes largest mirror size in Array Mirror section in an array is a
	 * group of contiguous elements such that somewhere in the array, the same
	 * group appears in reverse order
	 * 
	 * @param mirrorArray
	 * @return largestMirror
	 */
	int largestMirror(int mirrorArray[]) {
		if (mirrorArray.length == 0) {
			throw new AssertionError("Input Array is Empty");
		}
		int startIndex = 0;
		int endIndex = 0;
		int mirrorSize = 0;
		int maxMirrorSize = 0;
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
	 * Computes number of Clumps in an Array, Clump in an array is a series of 2
	 * or more adjacent elements of the same value
	 * 
	 * @param clumpsArray
	 * @return numbersOfClumps
	 */
	public int numbersOfClumps(int[] clumpsArray) {
		if (clumpsArray.length == 0) {
			throw new AssertionError("Array is Empty");
		}
		int numbersOfClumps = 0;
		int clump = clumpsArray[0];
		int clumpCount = 1;
		for (int i = 1; i < clumpsArray.length; i++) {
			if (clump == clumpsArray[i]) {
				if (clumpCount == 1) {
					numbersOfClumps++;
				}
				clumpCount++;
			} else {
				clump = clumpsArray[i];
				clumpCount = 1;
			}
		}
		return numbersOfClumps;
	}

	/**
	 * Rearranges Array so that every X is immediately followed by a Y
	 * 
	 * @param x
	 * @param y
	 * @param arrayToFixXy
	 * @return
	 */
	public int[] fixXy(int x, int y, int[] arrayToFixXy) {
		if (arrayToFixXy.length == 0) {
			throw new AssertionError("Array is Empty");
		}
		int[] copyOfFixArray = arrayToFixXy;
		if (x == copyOfFixArray[copyOfFixArray.length - 1]) {
			throw new AssertionError(x + " is at Last Index");
		}
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
			throw new AssertionError(x + " and " + y + " are not Equal");
		}
		for (int i = 0; i < xIndex.size(); i++) {
			if (i != xIndex.size() - 1 && xIndex.get(i) == xIndex.get(i + 1)) {
				throw new AssertionError("Two " + x + " at adjacent Positions");
			}
			int swapY = copyOfFixArray[xIndex.get(i) + 1];
			copyOfFixArray[xIndex.get(i) + 1] = copyOfFixArray[yIndex.get(i)];
			copyOfFixArray[yIndex.get(i)] = swapY;
		}
		return copyOfFixArray;
	}

	/**
	 * Return the index if there is a place to split the input array so that the
	 * sum of the numbers on one side is equal to the sum of the numbers on the
	 * other side else return -1
	 * 
	 * @param enteredArray
	 * @return
	 */
	public int splitArray(int[] enteredArray) {
		if (enteredArray.length == 0) {
			throw new AssertionError("Array is Empty");
		}
		int leftHalf = 0;
		int rightHalf = 0;
		int splitIndex = -1;

		for (int i = 0; i < enteredArray.length; i++) {
			rightHalf += enteredArray[i];
		}

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
}
