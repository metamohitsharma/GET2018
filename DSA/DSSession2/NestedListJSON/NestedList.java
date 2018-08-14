package GET2018.DSA.DSSession2.NestedListJSON;

import org.json.simple.parser.ParseException;
import java.io.IOException;
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
	 * @throws org.json.simple.parser.ParseException
	 */
	public boolean addList(String fileName) throws ParseException, IOException;

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
