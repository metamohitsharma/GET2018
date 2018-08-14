package GET2018.DSA.DSSession2.CounsellingProcess;

import java.util.ArrayList;

/**
 * This class represents Student details i.e., Name and Interested Program
 * 
 * @author Mohit Sharma
 *
 */
public class Student {
	String name;
	ArrayList<String> interestedProgram = new ArrayList<>();

	public ArrayList<String> getInterestedProgram() {
		return interestedProgram;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInterestedProgram(String program) {
		interestedProgram.add(program);
	}
}
