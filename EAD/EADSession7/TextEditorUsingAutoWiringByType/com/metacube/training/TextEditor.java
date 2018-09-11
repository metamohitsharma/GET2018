package com.metacube.training;

/**
 * This class performs operations in Text Editor
 * 
 * @author Mohit Sharma
 *
 */
public class TextEditor {
	private SpellChecker spellChecker;

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	/**
	 * Checks Spelling of a Word
	 * 
	 * @param word
	 */
	public void spellCheck(String word) {
		spellChecker.checkSpelling(word);
	}
}