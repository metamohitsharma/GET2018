package GET2018.DSA.DSSession4.UniqueCharacters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on UniqueCharacters class
 * 
 * @author Mohit Sharma
 *
 */
public class UniqueCharactersTest {

	UniqueCharacters uniqueString;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() {
		uniqueString = new UniqueCharacters();
		uniqueString.calculateUniqueCharacters("nnnnf");
		uniqueString.calculateUniqueCharacters("43h/#v/");
	}

	@Test
	public void testCalculateUniqueCharacters() {
		// Calculating Unique Charaters in String Mohit Sharma35 -^ -^
		assertEquals(14, uniqueString.calculateUniqueCharacters("Mohit Sharma35 -^ -^"));
	}

	@Test
	public void testCalculateUniqueCharactersAlreadyStored() {
		// Calculating Unique Characters in String that is already stored
		assertEquals(2, uniqueString.calculateUniqueCharacters("nnnnf"));
		assertEquals(6, uniqueString.calculateUniqueCharacters("43h/#v/"));
	}

	@Test
	public void testCalculateUniqueCharactersWithNull() {
		// Calculating Unique Characters in Null String
		ex.expect(NullPointerException.class);
		ex.expectMessage("Input String Can't be Null");
		uniqueString.calculateUniqueCharacters(null);
	}
}
