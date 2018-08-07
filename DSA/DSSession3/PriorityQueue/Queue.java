package GET2018.DSA.DSSession3.PriorityQueue;

/**
 * This interface provides various operations on Queue
 * 
 * @author Mohit Sharma
 *
 */
public interface Queue {

	/**
	 * Adds element to Queue
	 * 
	 * @param newElement
	 * @param priority
	 * @return
	 */
	public boolean enqueue(String newElement, int priority);

	/**
	 * Removes Front Element from Queue
	 * 
	 * @return
	 */
	public String dequeue();

	/**
	 * Peeks in Queue
	 * 
	 * @return
	 */
	public String peek();

	/**
	 * Checks whether Queue is Full or not
	 * 
	 * @return
	 */
	public boolean isFull();

	/**
	 * Checks whether Queue is Empty or not
	 * 
	 * @return
	 */
	public boolean isEmpty();
}
