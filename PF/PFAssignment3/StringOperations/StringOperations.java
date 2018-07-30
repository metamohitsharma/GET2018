package GET2018.PF.PFAssignment3.StringOperations;

/**
 * This class contains different operations applied on String
 * 
 * @author Mohit Sharma
 *
 */
public class StringOperations {
	private String operatedString;

	public StringOperations(String operatedString) throws StringException {
		if (operatedString == null) {
			throw new NullPointerException("String is null");
		} else if (operatedString.length() == 0) {
			throw new StringException("String is Empty");
		}
		this.operatedString = operatedString;
	}

	/**
	 * Checks whether Entered String is equal to given String
	 * 
	 * @param checkEqualityString
	 * @return 1 if both strings are equal otherwise 0
	 * @throws StringException
	 */
	public int isEquals(String checkEqualityString) throws StringException {
		if (checkEqualityString == null) {
			throw new NullPointerException("isEqual String is null");
		} else if (checkEqualityString.length() == 0) {
			throw new StringException("isEqual String is Empty");
		}
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
		String longestWord = "";
		int maxCharacterCount = 0;
		int characterCount = 0;
		String wordTaker = "";

		/*
		 * Increasing characterCount until BlankSpace occur then comparing the
		 * characterCount with maxCharaterCount
		 */
		for (int i = 0; i < operatedString.length(); i++) {
			if ((char) operatedString.charAt(i) == ' ' || i == operatedString.length() - 1) {
				if (i == operatedString.length() - 1) {
					characterCount++;
					wordTaker = wordTaker + operatedString.charAt(i);
					if (characterCount >= maxCharacterCount) {
						longestWord = new String(wordTaker);
						maxCharacterCount = characterCount;
					}
				} else {
					if (characterCount >= maxCharacterCount) {
						longestWord = new String(wordTaker);
						maxCharacterCount = characterCount;
					}
				}
				characterCount = 0;
				wordTaker = "";
			} else {
				characterCount++;
				wordTaker = wordTaker + operatedString.charAt(i);
			}
		}
		return longestWord;
	}

	@SuppressWarnings("serial")
	static class StringException extends Exception {
		String messageException;

		public StringException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
