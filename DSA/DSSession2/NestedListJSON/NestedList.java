package GET2018.DSA.DSSession2.NestedListJSON;

import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * This interface provides Operations on Nested List
 * 
 * @author Mohit Sharma
 *
 */
public interface NestedList {
	LinkedList<LinkedList<Integer>> nestedList = new LinkedList<LinkedList<Integer>>();

	/**
	 * Adds List in file to NestedList
	 * 
	 * @param addList
	 * @return
	 */
	public boolean addList(String fileName) throws FileNotFoundException;

	/**
	 * Adds all the Integers in List
	 * 
	 * @return
	 */
	public int addAllIntegers();

	/**
	 * Returns the Largest Integer in the NestedList
	 * 
	 * @return
	 */
	public int largestInteger();

	/**
	 * Returns true if elementToSearch is found in NestedList
	 * 
	 * @param elementToSearch
	 * @return
	 */
	public boolean searchList(int elementToSearch);
}
