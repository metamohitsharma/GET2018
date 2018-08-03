package GET2018.PF.PFAssignment5.SearchArray;

/**
 * This class contains two methods that are used to search an Array
 * 
 * @author Mohit Sharma
 *
 */
public class SearchArray {

	/**
	 * Search using Binary Search Returns the index of Element if found otherwise
	 * returns -1
	 * 
	 * @param arrayToSearch
	 * @param index
	 * @param elementToSearch
	 * @return
	 * @throws SearchException
	 */
	int binarySearch(int[] sortedArray, int startIndex, int endIndex, int elementToSearch) throws SearchException {
		if (sortedArray == null) {
			throw new NullPointerException("Entered Array is Null in BinarySearch");
		} else if (sortedArray.length == 0) {
			throw new SearchException("Input Array is Empty in BinarySearch");
		}
		if (startIndex < endIndex) {
			int midIndex = startIndex + (endIndex - startIndex) / 2;
			if (elementToSearch < sortedArray[midIndex]) {
				return binarySearch(sortedArray, startIndex, midIndex, elementToSearch);
			} else if (elementToSearch > sortedArray[midIndex]) {
				return binarySearch(sortedArray, midIndex + 1, endIndex, elementToSearch);
			} else {
				return midIndex;
			}
		}
		return -1;
	}

	/**
	 * Search using Linear Search Returns the index of Element if found otherwise
	 * returns -1
	 * 
	 * @param sortedArray
	 * @param startIndex
	 * @param endIndex
	 * @param elementToSearch
	 * @return
	 * @throws SearchException
	 */
	int linearSearch(int arrayToSearch[], int index, int elementToSearch) throws SearchException {
		if (arrayToSearch == null) {
			throw new NullPointerException("Entered Array is Null in LinearSearch");
		} else if (arrayToSearch.length == 0) {
			throw new SearchException("Input Array is Empty in LinearSearch");
		}
		if (arrayToSearch.length - 1 < index) {
			return -1;
		}
		if (arrayToSearch[index] == elementToSearch) {
			return index;
		}
		return linearSearch(arrayToSearch, index + 1, elementToSearch);
	}

	@SuppressWarnings("serial")
	static class SearchException extends Exception {
		String messageException;

		public SearchException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
