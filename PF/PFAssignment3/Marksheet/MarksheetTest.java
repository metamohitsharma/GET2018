package GET2018.PF.PFAssignment3.Marksheet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MarksheetTest {

	@Test
	void test() {
		Marksheet marksheet = new Marksheet(5, new double[] { 23.45, 70, 97.55, 34.67, 66.08 });
		assertEquals(58.35, marksheet.averageOfGrades());
		assertEquals(97.55, marksheet.maximumGrade());
		assertEquals(23.45, marksheet.minimumGrade());
		assertEquals(60.0, marksheet.percentOfPassedStudents());
	}
}
