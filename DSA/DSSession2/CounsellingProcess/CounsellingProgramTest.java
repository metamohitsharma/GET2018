package GET2018.DSA.DSSession2.CounsellingProcess;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on different methods in CounsellingProgram
 * class
 * 
 * @author Mohit Sharma
 *
 */
public class CounsellingProgramTest {

	CounsellingProgram cp;
	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() {
		cp = new CounsellingProgram();
	}

	@Test
	public void testCounsellingProgram() throws IOException, QueueException {
		// Adding Students and Programs and Allotting them Programs according to Queue
		assertTrue(cp.addProgram("Programs.xlsx"));
		assertTrue(cp.addStudent("Student.xlsx"));
		assertTrue(cp.allotPrograms());
	}

	@Test
	public void programFileNotExistTest() throws IOException {
		// Adding Program from a file that Doesn't exist
		ex.expect(IOException.class);
		ex.expectMessage("File Not Found while adding Programs");
		cp.addProgram("CounsellingProgram.xlsx");
	}

	@Test
	public void studentFileNotExistTest() throws QueueException, IOException {
		// Adding Students from a file that Doesn't exist
		ex.expect(IOException.class);
		ex.expectMessage("File Not Found while adding Students");
		cp.addStudent("StudentList.xlsx");
	}
}
