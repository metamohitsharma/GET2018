package GET2018.DSA.DSSession1.Queue;

import java.util.LinkedList;

/**
 * It implements the methods defined in Queue using Linked List
 * 
 * @author Mohit Sharma
 *
 */
public class QueueLinkedList implements Queue {
	LinkedList<String> queueList = new LinkedList<>();

	@Override
	public boolean addItem(String addElement) throws QueueException {
		if (addElement == null) {
			throw new NullPointerException("Can't add Null to Queue");
		}
		if (isFull()) {
			throw new QueueException("Queue is Full");
		}
		queueList.add(addElement);
		return true;
	}

	@Override
	public String deleteItem() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is Empty");
		} else {
			String itemDeleted = queueList.get(0);
			queueList.remove(0);
			return itemDeleted;
		}
	}

	@Override
	public boolean isEmpty() {
		return (queueList.size() == 0);
	}

	@Override
	public boolean isFull() {
		return (queueList.size() == maxSize);
	}
}
