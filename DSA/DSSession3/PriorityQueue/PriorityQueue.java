package GET2018.DSA.DSSession3.PriorityQueue;

/**
 * This class implements methods of Queue for Priority Queue
 * 
 * @author Mohit Sharma
 *
 */
public class PriorityQueue implements Queue {

	private Job[] jobArray;
	private int noOfJob = -1;
	private final int size;

	public PriorityQueue(int size) {
		this.jobArray = new Job[size];
		this.size = size;
	}

	public boolean enqueue(String value, int priority) {
		if (!isFull()) {
			jobArray[++noOfJob] = new Job(value, priority);
		} else {
			throw new IndexOutOfBoundsException("Queue Array is full, Can't Insert");
		}
		return true;
	}

	public String dequeue() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Queue is empty, Can't Delete");
		}
		Job element = jobArray[getHighestPriority()];
		for (int i = getHighestPriority(); i < noOfJob; i++) {
			jobArray[i] = jobArray[i + 1];
		}
		noOfJob--;
		return element.getValue();
	}

	public String peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Queue is empty, Can't Peek");
		}
		return jobArray[getHighestPriority()].getValue();
	}

	public boolean isEmpty() {
		if (noOfJob == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (noOfJob == size - 1) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns the index of Job having maxPriority
	 * 
	 * @return
	 */
	private int getHighestPriority() {
		int maxPriority = jobArray[0].priority;
		int indexOfHighestPriority = 0;
		for (int i = 0; i < noOfJob + 1; i++) {
			if (jobArray[i].priority > maxPriority) {
				indexOfHighestPriority = i;
				maxPriority = jobArray[i].priority;
			}
		}
		return indexOfHighestPriority;
	}
}
