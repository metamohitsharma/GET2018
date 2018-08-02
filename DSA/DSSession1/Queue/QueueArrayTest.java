package GET2018.DSA.DSSession1.Queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import GET2018.DSA.DSSession1.Queue.QueueArray.QueueException;

/**
 * This class performs various tests on QueueArray class methods
 * 
 * @author Mohit Sharma
 *
 */
public class QueueArrayTest {
	QueueArray queueArray;

	@Before
	public void init() throws QueueException {
		queueArray = new QueueArray();
		queueArray.addItem("The");
		queueArray.addItem("Fault");
		queueArray.addItem("In");
		queueArray.addItem("Our");
	}

	@Test
	public void testPushUsingArrayQueue() throws QueueException {
		// Adding Element in Queue
		queueArray.addItem("Stars");
	}

	@Test
	public void testPushQueueUsingArrayOverflow() {
		// Adding element when Queue is Full
		try {
			queueArray.addItem("Stars");
			queueArray.addItem("Written");
		} catch (QueueException ex) {
			assertEquals("Queue is Full", ex.getMessageException());
		}
	}

	@Test
	public void pushNullInQueueUsingArray() throws QueueException {
		// Adding Null Element in Queue
		try {
			queueArray.addItem(null);
		} catch (NullPointerException ex) {
			assertEquals("Can't add Null to Queue", ex.getMessage());
		}
	}

	@Test
	public void testDeleteQueueUsingArray() throws QueueException {
		// Deleting Element from Queue
		assertEquals("The", queueArray.deleteItem());
		assertEquals("Fault", queueArray.deleteItem());
	}

	@Test
	public void testDeleteQueueUsingArrayUnderflow() {
		// Deleting from an Empty Stack
		try {
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
		} catch (QueueException ex) {
			assertEquals("Queue is Empty", ex.getMessageException());
		}
	}
}