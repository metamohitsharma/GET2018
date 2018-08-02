package GET2018.DSA.DSSession1.Queue;

import GET2018.DSA.DSSession1.Queue.QueueArray.QueueException;

/**
 * It implements various operations on Queue
 * 
 * @author Mohit Sharma
 *
 */
public interface Queue {
	int maxSize = 4;

	/**
	 * Add the given element to Queue
	 * 
	 * @param newElement
	 * @return true if newElement is pushed to Queue
	 */
	public boolean addItem(String addElement) throws QueueException;

	/**
	 * Pop the Front Element of Queue
	 * 
	 * @return Popped Element from Queue
	 */
	public String deleteItem() throws QueueException;

	/**
	 * It checks whether the Queue is Empty or not
	 * 
	 * @return true if the Queue is Empty
	 */
	public boolean isEmpty();

	/**
	 * It checks whether the Queue is full or not
	 * 
	 * @return true is the Queue is Full
	 */
	public boolean isFull();
}
