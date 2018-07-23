package GET2018.PF.PFAssignment3.Marksheet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MarksheetNegativeTest {
	Marksheet marksheet;

	@Before
	public void init() {
		marksheet = new Marksheet(5, new double[] { 23.45, 70, 97.55, 34.67, 66.08 });
	}

	@Test
	public void testAverageOfGrades() {
		assertNotEquals(34.2, marksheet.averageOfGrades(), 0);
	}

	@Test
	public void testMaximumGrade() {
		assertNotEquals(97.51, marksheet.maximumGrade(), 0);
	}

	@Test
	public void testMinimumGrade() {
		assertNotEquals(43.21, marksheet.minimumGrade(), 0);
	}

	@Test
	public void testPercentOfPassedStudents() {
		assertNotEquals(23.21, marksheet.percentOfPassedStudents(), 0);
	}

}
