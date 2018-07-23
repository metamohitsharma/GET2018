package GET2018.PF.PFAssignment4.ArrOperations;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains Exception TestCases for different methods in ArrOperation
 * Class
 * 
 * @author Mohit Sharma
 *
 */
public class ArrOperationsExceptionTest {

	ArrOperation arrayOperations;

	@Before
	public void init() {
		arrayOperations = new ArrOperation();
	}

	@Test(expected = AssertionError.class)
	public void largestMirrorTest() {
		assertNotEquals(2, arrayOperations.largestMirror(new int[] {}));
	}

	@Test(expected = AssertionError.class)
	public void numberOfClumpsTest() {
		assertNotEquals(5, arrayOperations.numbersOfClumps(new int[] {}));
	}

	@Test(expected = AssertionError.class)
	public void fixXYTest() {
		Assert.assertThat(new int[] { 9, 4, 5, 4, 5, 5 }, IsNot.not(IsEqual
				.equalTo(arrayOperations.fixXy(4, 5, new int[] {}))));
	}

	@Test(expected = AssertionError.class)
	public void splitArrayTest() {
		assertNotEquals(-1, arrayOperations.splitArray(new int[] {}));
	}

}
