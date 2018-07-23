package GET2018.PF.PFAssignment3.Marksheet;

import org.junit.Test;

public class MarksheetExceptionTest {

	Marksheet marksheet;

	@Test(expected = AssertionError.class)
	public void testZeroNoOfStudents() {
		marksheet = new Marksheet(0, new double[] { 23, 54, 24.5 });
	}

	@Test(expected = AssertionError.class)
	public void testNotInRangeGrade() {
		marksheet = new Marksheet(4, new double[] { 23, 54, -34.45, 149.99 });
	}
}
