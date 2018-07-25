package GET2018.PF.PFAssignment6.intSet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GET2018.PF.PFAssignment6.intSet.IntSet.SetException;

public class IntSetTest {
	static IntSet set;

	@Before
	public void init() throws SetException {
		set = new IntSet(new int[] { 2, 35, 678, 97, 53, 46 });
	}

	@Test
	public void isMemebertest() {
		assertEquals(true, set.isMember(100));
	}

	@Test
	public void isSubSettest() throws SetException {
		assertEquals(true, set.isSubSet(new IntSet(new int[] { 2, 35, 46 })));
	}

	@Test
	public void getComplementtest() {
		set.getComplement();
	}

	@Test
	public void unionTest() throws SetException {
		assertArrayEquals(new int[] { 2, 3, 4, 5, 11, 12, 13, 14 },
				IntSet.union(new IntSet(new int[] { 2, 3, 11, 12 }), new IntSet(new int[] { 2, 4, 5, 12, 14, 13 })));
	}

	@Test
	public void initializeWithNull() throws SetException {
		try {
			new IntSet(null);
		} catch (NullPointerException ex) {
			assertEquals("Input Array is Null", ex.getMessage());
		}
	}

	@Test
	public void arrayLengthZeroTest() {
		try {
			new IntSet(new int[] {});
		} catch (SetException ex) {
			assertEquals("Input Array Length can't be Zero", ex.getMessageException());
		}
	}

	@Test
	public void testWithInvalidInput() {
		try {
			new IntSet(new int[] { 2, 5, 43, 124, 1024, -1, 0 });
		} catch (SetException ex) {
			assertEquals("Input Invalid Not in Range 1-1000", ex.getMessageException());
		}
	}
}
