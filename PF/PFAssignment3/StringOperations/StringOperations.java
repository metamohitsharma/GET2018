package GET2018.PF.PFAssignment3.StringOperations;

import java.util.ArrayList;

/**
 * This class contains different operations applied on String
 * 
 * @author Mohit Sharma
 *
 */
public class StringOperations {
	private String operatedString;

	public StringOperations(String operatedString) {
		this.operatedString = operatedString;
	}

	/**
	 * Checks whether Entered String is equal to given String
	 * 
	 * @param checkEqualityString
	 * @return 1 if both strings are equal otherwise 0
	 */
	public int isEquals(String checkEqualityString) {
		if (operatedString.length() == checkEqualityString.length()) {
			for (int i = 0; i < operatedString.length(); i++) {
				if (operatedString.charAt(i) != checkEqualityString.charAt(i)) {
					return 0;
				}
			}
		} else {
			return 0;
		}
		return 1;
	}

	/**
	 * Computes Reverse of Entered String
	 * 
	 * @return
	 */
	public String reverseString() {
		String reverseString = "";
		for (int i = operatedString.length() - 1; i >= 0; i--) {
			reverseString = reverseString + operatedString.charAt(i);
		}
		return reverseString;
	}

	/**
	 * Changes Lowercase Characters to Uppercase and Vice-versa
	 * 
	 * @return
	 */
	public String viceVersa() {
		String viceVersa = "";
		int lowerToUpper = 'a' - 'A';
		for (int i = 0; i < operatedString.length(); i++) {
			if (operatedString.charAt(i) >= 'a' && operatedString.charAt(i) <= 'z') {
				viceVersa = viceVersa + (char) (operatedString.charAt(i) - lowerToUpper);
			} else if (operatedString.charAt(i) >= 'A' && operatedString.charAt(i) <= 'Z') {
				viceVersa = viceVersa + (char) (operatedString.charAt(i) + lowerToUpper);
			} else if (operatedString.charAt(i) == ' ') {
				viceVersa = viceVersa + " ";
			} else {
				viceVersa = viceVersa + operatedString.charAt(i);
			}
		}
		return viceVersa;
	}

	/**
	 * Computes the Longest word in String if two words are of same length then
	 * return last word
	 * 
	 * @return
	 */
	public String longestWord() {
		ArrayList<Integer> wordCount = new ArrayList<Integer>();
		ArrayList<String> wordInString = new ArrayList<String>();
		int characterCount = 0;
		String wordTaker = "";
		for (int i = 0; i < operatedString.length(); i++) {
			if ((char) operatedString.charAt(i) == ' ' || i == operatedString.length() - 1) {
				if (i == operatedString.length() - 1) {
					wordCount.add(characterCount + 1);
					wordTaker = wordTaker + operatedString.charAt(operatedString.length() - 1);
					wordInString.add(wordTaker);
				} else {
					wordCount.add(characterCount);
					wordInString.add(wordTaker);
				}
				characterCount = 0;
				wordTaker = "";
			} else {
				characterCount++;
				wordTaker = wordTaker + operatedString.charAt(i);
			}
		}
		int max = 0;
		int index = -1;
		for (int i = wordCount.size() - 1; i >= 0; i--) {
			if (max < wordCount.get(i)) {
				max = wordCount.get(i);
				index = i;
			}
		}
		return wordInString.get(index);
	}
}
