package GET2018.DSA.DSSession2.CounsellingProcess;

/**
 * This interface provides various methods on Queue
 * 
 * @author Mohit Sharma
 *
 */
public interface Queue {

	/**
	 * Returns the Deleted Item from Queue
	 * 
	 * @return
	 */
	public Student deQueue() throws QueueException;

	/**
	 * Inserts Item in Queue
	 * 
	 * @param element
	 * @return
	 */
	public boolean enQueue(Student newStudent) throws QueueException;

	/**
	 * Returns Topmost Element in Queue
	 * 
	 * @return
	 */
	public Student peek() throws QueueException;
}
