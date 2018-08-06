package GET2018.DSA.DSSession2.CircularQueue;

/**
 * This class inpements the methods defined in Queue Interface
 * 
 * @author Mohit Sharma
 *
 */
public class CircularQueue implements Queue {
	int front;
	int rear;
	int[] queueArray;
	int MAX_SIZE;

	public CircularQueue(int max) {
		front = -1;
		rear = -1;
		MAX_SIZE = max;
		queueArray = new int[MAX_SIZE];
	}

	@Override
	public int deQueue() throws QueueException {
		if (front == -1) {
			throw new QueueException("Queue is empty! Can't remove item.");
		} else {
			int deletedElement = queueArray[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (front == MAX_SIZE - 1) {
				front = 0;
			} else {
				front++;
			}
			return deletedElement;
		}
	}

	@Override
	public boolean enQueue(int newElement) throws QueueException {
		if (front == rear + 1 || (rear == MAX_SIZE - 1 && front == 0)) {
			throw new QueueException("Queue is Full! Can't Add item.");
		} else {
			if (front == -1) {
				front++;
				rear++;
			} else if (rear == MAX_SIZE - 1) {
				rear = 0;
			} else {
				rear++;
			}
			queueArray[rear] = newElement;
			return true;
		}
	}

	@Override
	public int peek() throws QueueException {
		if (front == -1) {
			throw new QueueException("Queue is empty! Can't Peek");
		} else {
			return queueArray[front];
		}
	}
}
