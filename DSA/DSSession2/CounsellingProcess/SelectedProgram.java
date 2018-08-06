package GET2018.DSA.DSSession2.CounsellingProcess;

/**
 * This class represents Student Name and their Alloted Program
 * 
 * @author Mohit Sharma
 *
 */
public class SelectedProgram {
	String studentName;
	String selectedProgram;

	public SelectedProgram(String studentName, String selectedProgram) {
		this.studentName = studentName;
		this.selectedProgram = selectedProgram;
	}

	public String getSelectedProgram() {
		return selectedProgram;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setSelectedProgram(String selectedProgram) {
		this.selectedProgram = selectedProgram;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
