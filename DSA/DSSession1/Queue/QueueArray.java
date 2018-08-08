package GET2018.DSA.DSSession1.Queue;

/**
 * It implements the methods defined in Queue using Array
 * 
 * @author Mohit Sharma
 *
 */
public class QueueArray implements Queue {
	private int rear = -1;
	private int front = -1;
	String queueArray[] = new String[5];;

	@Override
	public boolean addItem(String addElement) throws QueueException {
		if (addElement == null) {
			throw new NullPointerException("Can't add Null to Queue");
		}
		if (isFull()) {
			throw new QueueException("Queue is Full");
		}
		rear++;
		queueArray[rear] = addElement;
		return true;
	}

	@Override
	public String deleteItem() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is Empty");
		} else {
			front++;
			return queueArray[front];
		}
	}

	@Override
	public boolean isEmpty() {
		return (rear == front);
	}

	@Override
	public boolean isFull() {
		return (rear == maxSize);
	}

}
