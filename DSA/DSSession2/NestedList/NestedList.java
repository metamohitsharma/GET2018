package GET2018.DSA.DSSession2.NestedList;

import java.util.ArrayList;

/**
 * This interface provides Operations on Nested List
 * 
 * @author Mohit Sharma
 *
 */
public interface NestedList {
	ArrayList<ArrayList<Integer>> nestedList = new ArrayList<ArrayList<Integer>>();

	/**
	 * Adds List to NestedList
	 * 
	 * @param addList
	 * @return
	 */
	public boolean addList(ArrayList<Integer> addList);

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
