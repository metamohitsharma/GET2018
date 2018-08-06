package GET2018.DSA.DSSession2.CounsellingProcess;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * This class performs various tests on different methods in CounsellingProgram
 * class
 * 
 * @author Mohit Sharma
 *
 */
public class CounsellingProgramTest {

	CounsellingProgram cp;

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
	public void programFileNotExistTest() {
		// Adding Program from a file that Doesn't exist
		try {
			cp.addProgram("CounsellingProgram.xlsx");
		} catch (IOException ex) {
			assertEquals("File Not Found while adding Programs", ex.getMessage());
		}
	}

	@Test
	public void studentFileNotExistTest() throws QueueException {
		// Adding Students from a file that Doesn't exist
		try {
			cp.addStudent("StudentList.xlsx");
		} catch (IOException ex) {
			assertEquals("File Not Found while adding Students", ex.getMessage());
		}
	}
}
