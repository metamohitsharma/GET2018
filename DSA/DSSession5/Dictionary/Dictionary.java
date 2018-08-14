package GET2018.DSA.DSSession5.Dictionary;

import java.util.Map;
import java.util.TreeMap;

/**
 * Interface to implement Dictionary
 * 
 * @author Mohit Sharma
 *
 */
public interface Dictionary {

	Map<String, String> dictionary = new TreeMap<String, String>();

	/**
	 * Adds Word to Dictionary
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean addWord(String key, String value);

	/**
	 * Deletes Word from Dictionary
	 * 
	 * @param key
	 * @return
	 */
	public boolean deleteWord(String key);

	/**
	 * Returns value of Given Key
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key);

	/**
	 * Sorts Dictionary in Ascending Order
	 * 
	 * @return
	 */
	public Map<String, String> sortDictionary();

	/**
	 * Return the sorted list of key value pairs for all the keys >=K1 and <=K2
	 * 
	 * @param key1
	 * @param key2
	 * @return
	 */
	public Map<String, String> sortDictionaryInRange(String key1, String key2);
}
