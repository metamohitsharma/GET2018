package GET2018.PF.PFAssignment3.Marksheet;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import GET2018.PF.PFAssignment3.Marksheet.Marksheet.MarksheetException;

/**
 * This Class performs different test on Marksheet Class
 * 
 * @author Mohit Sharma
 *
 */
public class MarksheetTest {

	static Marksheet marksheet;

	@BeforeClass
	public static void init() throws MarksheetException {
		marksheet = new Marksheet(5, new double[] { 23.45, 70, 97.55, 34.67, 66.08 });
	}

	@Test
	public void testAverageOfGrades() {
		assertEquals(58.35, marksheet.averageOfGrades(), 0);
	}

	@Test
	public void testMaximumGrade() {
		assertEquals(97.55, marksheet.maximumGrade(), 0);
	}

	@Test
	public void testMinimumGrade() {
		assertEquals(23.45, marksheet.minimumGrade(), 0);
	}

	@Test
	public void testPercentOfPassedStudents() {
		assertEquals(60.0, marksheet.percentOfPassedStudents(), 0);
	}

	@Test
	public void testZeroNoOfStudents() {
		try {
			marksheet = new Marksheet(0, new double[] { 23, 54, 24.5 });
		} catch (MarksheetException ex) {
			assertEquals("No Of Students can't be Zero or Negative", ex.getMessageException());
		}
	}

	@Test
	public void testNotInRangeGrades() {
		try {
			marksheet = new Marksheet(4, new double[] { 23, 54, -34.45, 149.99 });
		} catch (MarksheetException ex) {
			assertEquals("Enter Grades in 0 to 100 range only", ex.getMessageException());
		}
	}
}
