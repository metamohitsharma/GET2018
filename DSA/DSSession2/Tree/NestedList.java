package GET2018.DSA.DSSession2.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface provides Operations on Nested List
 * 
 * @author Mohit Sharma
 *
 */
public interface NestedList {
	ArrayList<Object> nestedList = new ArrayList<Object>();

	/**
	 * Adds List to NestedList
	 * 
	 * @param addList
	 * @return
	 */
	public boolean addList(Object obj);

	/**
	 * Adds all the Integers in List
	 * 
	 * @return
	 */
	public Object addAllIntegers(List<Object> list);

	/**
	 * Returns the Largest Integer in the NestedList
	 * 
	 * @return
	 */
	public Object largestInteger(List<Object> list);

	/**
	 * Returns true if elementToSearch is found in NestedList
	 * 
	 * @param elementToSearch
	 * @return
	 */
	public boolean searchList(List<Object> list, int elementToSearch);

	/**
	 * Returns the integer stored at position
	 * 
	 * @param postion
	 * @return
	 */
	public int getValue(List<Object> list, String position) throws NestedListException;
}
