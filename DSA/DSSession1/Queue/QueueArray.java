package GET2018.DSA.DSSession1.Queue;

/**
 * It implements the methods defined in Queue using Array
 * 
 * @author Mohit Sharma
 *
 */
public class QueueArray implements Queue {
	private int front = -1;
	private int rear = -1;
	String queueArray[] = new String[5];;

	@Override
	public boolean addItem(String addElement) throws QueueException {
		if (addElement == null) {
			throw new NullPointerException("Can't add Null to Queue");
		}
		if (isFull()) {
			throw new QueueException("Queue is Full");
		}
		front++;
		queueArray[front] = addElement;
		return true;
	}

	@Override
	public String deleteItem() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is Empty");
		} else {
			rear++;
			return queueArray[rear];
		}
	}

	@Override
	public boolean isEmpty() {
		return (front == rear);
	}

	@Override
	public boolean isFull() {
		return (front == maxSize);
	}

	@SuppressWarnings("serial")
	static class QueueException extends Exception {
		String messageException;

		public QueueException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}

}
