package GET2018.PF.PFAssignment5.SearchArray;

/**
 * This class contains two methods that are used to search an Array
 * 
 * @author Mohit Sharma
 *
 */
public class SearchArray {

	/**
	 * Search using Linear Search Returns the index of Element if found otherwise
	 * returns -1
	 * 
	 * @param sortedArray
	 * @param startIndex
	 * @param endIndex
	 * @param elementToSearch
	 * @return
	 */
	int binarySearch(int[] sortedArray, int startIndex, int endIndex, int elementToSearch) {
		if (sortedArray.length == 0) {
			throw new AssertionError("Input Array is Empty");
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
	 * Search using Binary Search Returns the index of Element if found otherwise
	 * returns -1
	 * 
	 * @param arrayToSearch
	 * @param index
	 * @param elementToSearch
	 * @return
	 */
	int linearSearch(int arrayToSearch[], int index, int elementToSearch) {
		if (arrayToSearch.length == 0) {
			throw new AssertionError("Input Array is Empty");
		}
		if (arrayToSearch.length - 1 < index) {
			return -1;
		}
		if (arrayToSearch[index] == elementToSearch) {
			return index;
		}
		return linearSearch(arrayToSearch, index + 1, elementToSearch);
	}
}
