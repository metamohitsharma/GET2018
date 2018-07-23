package GET2018.PF.PFAssignment4.ArrOperations;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains Negative TestCases for different methods in ArrOperation
 * Class
 * 
 * @author Mohit Sharma
 *
 */
public class ArrOperationNegativeTest {
	ArrOperation arrayOperations;

	@Before
	public void init() {
		arrayOperations = new ArrOperation();
	}

	@Test
	public void largestMirrorTest() {
		assertNotEquals(
				2,
				arrayOperations.largestMirror(new int[] { 1, 2, 3, 8, 9, 3, 2,
						1 }));
	}

	@Test
	public void numberOfClumpsTest() {
		assertNotEquals(5,
				arrayOperations.numbersOfClumps(new int[] { 1, 2, 2, 3, 4, 4 }));
	}

	@Test
	public void fixXYTest() {
		Assert.assertThat(new int[] { 9, 4, 5, 4, 5, 5 }, IsNot.not(IsEqual
				.equalTo(arrayOperations.fixXy(4, 5, new int[] { 5, 4, 9, 4, 9,
						5 }))));
	}

	@Test
	public void splitArrayTest() {
		assertNotEquals(-1,
				arrayOperations.splitArray(new int[] { 1, 1, 1, 2, 1 }));
	}
}
