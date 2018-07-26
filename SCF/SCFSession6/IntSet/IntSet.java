package GET2018.SCF.SCFSession6.IntSet;

/**
 * This Immutable class Performs various Operations on Set
 * 
 * @author Mohit Sharma
 *
 */
public final class IntSet {
	static final int intSetRange[] = new int[1000];
	final int intSet[];

	IntSet(int intSetInput[]) throws SetException {
		if (intSetInput == null) {
			throw new NullPointerException("Input Array is Null");
		}
		if (intSetInput.length == 0) {
			throw new SetException("Input Array Length can't be Zero");
		}
		int checkMembership;
		for (int i = 0; i < intSetRange.length; i++) {
			intSetRange[i] = i + 1;
		}

		/*
		 * Checks Whether the values of Array are in Range 1-1000 or not
		 */
		for (int i = 0; i < intSetInput.length; i++) {
			for (checkMembership = 0; checkMembership < intSetRange.length; checkMembership++) {
				if (intSetInput[i] == intSetRange[checkMembership]) {
					break;
				}
			}
			if (checkMembership == intSetRange.length) {
				throw new SetException("Input Invalid Not in Range 1-1000");
			}
		}
		IntSet.sortArray(intSetInput);
		intSet = intSetInput;
	}

	/**
	 * Check whether x is a member of the Set
	 * 
	 * @param x
	 * @return
	 */
	public boolean isMember(int x) {
		for (int i = 0; i < intSetRange.length; i++) {
			if (x == intSetRange[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the size of the Set
	 * 
	 * @return
	 */
	public int size() {
		return intSet.length;
	}

	/**
	 * Check whether subsetSet is a Subset of the Set
	 * 
	 * @param set
	 * @return
	 */
	public boolean isSubSet(IntSet subsetSet) {
		int checkMembership;
		for (int i = 0; i < subsetSet.intSet.length; i++) {
			for (checkMembership = 0; checkMembership < this.intSet.length; checkMembership++) {
				if (this.intSet[checkMembership] == subsetSet.intSet[i]) {
					break;
				}
			}
			if (checkMembership == this.intSet.length) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return the complement set
	 */
	public void getComplement() {
		int checkMembership;
		int complementSet[] = new int[1000];
		int indexOfComplementSet = 0;
		for (int i = 0; i < intSetRange.length; i++) {
			for (checkMembership = 0; checkMembership < intSet.length; checkMembership++) {
				if (intSetRange[i] == intSet[checkMembership]) {
					break;
				}
			}
			if (checkMembership == intSet.length) {
				complementSet[indexOfComplementSet] = intSetRange[i];
				indexOfComplementSet++;
			}
		}
		for (int x = 0; x < indexOfComplementSet; x++) {
			System.out.println(complementSet[x]);
		}
	}

	/**
	 * Return the Union of set1 and set2
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static int[] union(IntSet set1, IntSet set2) {
		int unionSet[] = new int[1000];
		int unionSetInput[];
		int indexOfUnionSet = 0;
		int checkMembership;

		/*
		 * Adding all the Elements of Set1 in unionSet
		 */
		for (int i = 0; i < set1.intSet.length; i++) {
			unionSet[indexOfUnionSet] = set1.intSet[i];
			indexOfUnionSet++;
		}

		/*
		 * Adding Remaining Elements of Set2 that are not in Set1 to unionSet
		 */
		for (int i = 0; i < set2.intSet.length; i++) {
			for (checkMembership = 0; checkMembership < indexOfUnionSet; checkMembership++) {
				if (unionSet[checkMembership] == set2.intSet[i]) {
					break;
				}
			}
			if (checkMembership == indexOfUnionSet) {
				unionSet[indexOfUnionSet] = set2.intSet[i];
				indexOfUnionSet++;
			}
		}
		unionSetInput = new int[indexOfUnionSet];
		for (int i = 0; i < indexOfUnionSet; i++) {
			unionSetInput[i] = unionSet[i];
		}
		IntSet.sortArray(unionSetInput);
		return unionSetInput;
	}

	/**
	 * Sort Array using Bubble Sort
	 * 
	 * @param sortArray
	 * @param lengthOfArray
	 */
	private static void sortArray(int sortArray[]) {
		for (int i = 0; i < sortArray.length - 1; i++) {
			for (int j = 0; j < sortArray.length - i - 1; j++) {
				if (sortArray[j] > sortArray[j + 1]) {
					int temp = sortArray[j];
					sortArray[j] = sortArray[j + 1];
					sortArray[j + 1] = temp;
				}
			}
		}
	}

	@SuppressWarnings("serial")
	class SetException extends Exception {
		String messageException;

		public SetException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
