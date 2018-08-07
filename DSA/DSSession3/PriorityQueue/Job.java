package GET2018.DSA.DSSession3.PriorityQueue;

/**
 * This class contains details of Job i.e., Value and Priority of Job
 * 
 * @author Mohit Sharma
 *
 */
public class Job {
	String value;
	int priority;

	public Job(String value, int priority) {
		this.value = value;
		this.priority = priority;
	}

	public String getValue() {
		return value;
	}

	public int getPriority() {
		return priority;
	}
}
