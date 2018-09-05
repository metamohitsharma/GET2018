package com.metacube.training;

/**
 * This class checks spelling of Words for TextEditor
 * 
 * @author Mohit Sharma
 *
 */
public class SpellChecker {
	private String word;

	public SpellChecker(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	/**
	 * Checks Spelling
	 * 
	 * @param word
	 */
	public void checkSpelling(String word) {
		System.out.println("Checking Spelling " + getWord());
	}
}