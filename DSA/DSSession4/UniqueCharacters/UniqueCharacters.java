package GET2018.DSA.DSSession4.UniqueCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class calculates Unique Characters in a given String
 * 
 * @author Mohit Sharma
 *
 */
public class UniqueCharacters {
	Map<String, Integer> wordsHavingUniqueCharacters = new HashMap<String, Integer>();

	/**
	 * Calculates Unique Characters in inputString
	 * 
	 * @param inputString
	 * @return
	 */
	public int calculateUniqueCharacters(String inputString) {
		if (inputString == null) {
			throw new NullPointerException("Input String Can't be Null");
		}
		if (wordsHavingUniqueCharacters.containsKey(inputString)) {
			return wordsHavingUniqueCharacters.get(inputString);
		}
		Set<Character> tokensInString = new HashSet<Character>();
		char arrayOfTokens[] = inputString.toCharArray();
		for (int i = 0; i < arrayOfTokens.length; i++) {
			tokensInString.add(arrayOfTokens[i]);
		}
		wordsHavingUniqueCharacters.put(inputString, tokensInString.size());
		return tokensInString.size();
	}
}
