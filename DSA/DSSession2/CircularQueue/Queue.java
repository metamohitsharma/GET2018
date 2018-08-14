package GET2018.DSA.DSSession2.CircularQueue;

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
	public int deQueue() throws QueueException;

	/**
	 * Inserts Item in Queue
	 * 
	 * @param element
	 * @return
	 */
	public boolean enQueue(int element) throws QueueException;

	/**
	 * Returns Topmost Element in Queue
	 * 
	 * @return
	 */
	public int peek() throws QueueException;
}
