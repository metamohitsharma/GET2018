package GET2018.DSA.DSSession1.Queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GET2018.DSA.DSSession1.Queue.QueueArray.QueueException;

/**
 * This class performs various tests on QueueLinkedList class methods
 * 
 * @author Mohit Sharma
 *
 */
public class QueueListTest {

	QueueLinkedList queueList;

	@Before
	public void init() throws QueueException {
		queueList = new QueueLinkedList();
		queueList.addItem("Wolf");
		queueList.addItem("of");
		queueList.addItem("the");
	}

	@Test
	public void testPushUsingListQueue() throws QueueException {
		// Adding Element in Queue
		queueList.addItem("Wall");
	}

	@Test
	public void testPushQueueUsingListOverflow() {
		// Adding element when Queue is Full
		try {
			queueList.addItem("Wall");
			queueList.addItem("Street");
		} catch (QueueException ex) {
			assertEquals("Queue is Full", ex.getMessageException());
		}
	}

	@Test
	public void pushNullInQueueUsingList() throws QueueException {
		// Adding Null Element in Queue
		try {
			queueList.addItem(null);
		} catch (NullPointerException ex) {
			assertEquals("Can't add Null to Queue", ex.getMessage());
		}
	}

	@Test
	public void testDeleteQueueUsingList() throws QueueException {
		// Deleting Element from Queue
		assertEquals("Wolf", queueList.deleteItem());
		assertEquals("of", queueList.deleteItem());
	}

	@Test
	public void testDeleteQueueUsingArrayUnderflow() {
		// Deleting from an Empty Stack
		try {
			queueList.deleteItem();
			queueList.deleteItem();
			queueList.deleteItem();
			queueList.deleteItem();
			queueList.deleteItem();
		} catch (QueueException ex) {
			assertEquals("Queue is Empty", ex.getMessageException());
		}
	}
}
