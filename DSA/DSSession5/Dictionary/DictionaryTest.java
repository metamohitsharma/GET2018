package GET2018.DSA.DSSession5.Dictionary;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class tests various methods in Dictionary interface
 * 
 * @author Mohit Sharma
 *
 */
public class DictionaryTest {

	Implementation implementation;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() throws FileNotFoundException {
		implementation = new Implementation("Words.JSON");
	}

	@Test
	public void addWordTest() {
		// Adding Word and its Meaning to Dictionary
		assertTrue(implementation.addWord("Dog", "Type of Animal"));
	}

	@Test
	public void deleteWordTest() {
		// Deleting Word Attitude from Dictionary
		assertTrue(implementation.deleteWord("Attitude"));
	}

	@Test
	public void getValueTest() {
		// Getting Meaning of word Attitude
		assertEquals("a feeling or opinion about something or someone",
				implementation.getValue("Attitude"));
	}

	@Test
	public void sortDictionaryTest() {
		// Sorting Dictionary
		Map<String, String> sortedWords = new HashMap<String, String>();
		sortedWords.put("Anticipate",
				"to imagine or expect that something will happen");
		sortedWords.put("Attitude",
				"a feeling or opinion about something or someone");
		sortedWords.put("Attribute",
				"a quality or characteristic that someone or something has");
		sortedWords.put("Content",
				"pleased with your situation and not hoping for change");
		sortedWords.put("Culture", "the general customs and beliefs");
		sortedWords.put("Sophisticated",
				"having a good understanding of the way people behave");
		assertEquals(sortedWords, implementation.sortDictionary());
	}

	@Test
	public void sortDictionaryInRangeTest() {
		// Sorting Dictionary in Range Attitude to Content
		Map<String, String> sortedWords = new HashMap<String, String>();
		sortedWords.put("Attitude",
				"a feeling or opinion about something or someone");
		sortedWords.put("Attribute",
				"a quality or characteristic that someone or something has");
		sortedWords.put("Content",
				"pleased with your situation and not hoping for change");
		assertEquals(sortedWords,
				implementation.sortDictionaryInRange("Attitude", "Content"));
	}

	@Test
	public void initWithNull() throws FileNotFoundException {
		// Adding fileName as Null
		ex.expect(NullPointerException.class);
		ex.expectMessage("fileName can't be Null");
		implementation = new Implementation(null);
	}

	@Test
	public void initWithFileNotFound() throws FileNotFoundException {
		// Adding a File that doesn't exist
		ex.expect(FileNotFoundException.class);
		ex.expectMessage("fileName not Found");
		implementation = new Implementation("Input.JSON");
	}

	@Test
	public void addWordWithNull() throws FileNotFoundException {
		// Adding a null word
		ex.expect(NullPointerException.class);
		ex.expectMessage("Key or Value to be Added can't be Null");
		implementation.addWord(null, "Input");
	}

	@Test
	public void deleteWordWithNullKey() throws FileNotFoundException {
		// Deleting a Null Word
		ex.expect(NullPointerException.class);
		ex.expectMessage("Key to be Deleted can't be Null");
		implementation.deleteWord(null);
	}

	@Test
	public void getValueWithNullKey() throws FileNotFoundException {
		// Getting a Null Word meaning
		ex.expect(NullPointerException.class);
		ex.expectMessage("Key to get Value can't be Null");
		implementation.getValue(null);
	}

	@Test
	public void sortDictionaryInRangeWithNullKey() throws FileNotFoundException {
		// Sorting Dictionary in Range from Null to Null
		ex.expect(NullPointerException.class);
		ex.expectMessage("Key1 or Key2 can't be Null");
		implementation.sortDictionaryInRange(null, null);
	}
}
