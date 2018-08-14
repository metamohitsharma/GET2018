package GET2018.DSA.DSSession5.Dictionary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class implements Methods in Dictionary Interface
 * 
 * @author Mohit Sharma
 *
 */
public class Implementation implements Dictionary {

	public Implementation(String fileName) throws IOException, ParseException {
		if (fileName == null) {
			throw new NullPointerException("fileName can't be Null");
		}
		try {
			JSONObject rootJSON = (JSONObject) new JSONParser()
					.parse(new FileReader(fileName));
			@SuppressWarnings("unchecked")
			Set<String> keys = rootJSON.keySet();
			for (String i : keys) {
				dictionary.put(i, rootJSON.get(i).toString());
			}
		} catch (FileNotFoundException ex) {
			throw new FileNotFoundException("fileName not Found");
		}
	}

	@Override
	public boolean addWord(String key, String value) {
		if (key == null || value == null) {
			throw new NullPointerException(
					"Key or Value to be Added can't be Null");
		}
		dictionary.put(key, value);
		return true;
	}

	@Override
	public boolean deleteWord(String key) {
		if (key == null) {
			throw new NullPointerException("Key to be Deleted can't be Null");
		}
		dictionary.remove(key);
		return true;
	}

	@Override
	public String getValue(String key) {
		if (key == null) {
			throw new NullPointerException("Key to get Value can't be Null");
		}
		return dictionary.get(key);
	}

	@Override
	public Map<String, String> sortDictionary() {
		Map<String, String> wordsSorted = new HashMap<String, String>();
		Set<String> set = dictionary.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			wordsSorted.put(key, dictionary.get(key));
		}
		return wordsSorted;
	}

	@Override
	public Map<String, String> sortDictionaryInRange(String key1, String key2) {
		if (key1 == null || key2 == null) {
			throw new NullPointerException("Key1 or Key2 can't be Null");
		}
		Map<String, String> wordsSorted = new HashMap<String, String>();
		Set<String> set = dictionary.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			if (key.compareTo(key1) >= 0 && key.compareTo(key2) <= 0) {
				wordsSorted.put(key, dictionary.get(key));
			}
		}
		return wordsSorted;
	}
}
