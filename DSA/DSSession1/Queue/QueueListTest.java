package GET2018.DSA.DSSession1.Queue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on QueueLinkedList class methods
 * 
 * @author Mohit Sharma
 *
 */
public class QueueListTest {

	QueueLinkedList queueList;

	@Rule
	public ExpectedException ex = ExpectedException.none();

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
	public void testPushQueueUsingListOverflow() throws QueueException {
		// Adding element when Queue is Full
		queueList.addItem("Wall");
		ex.expect(QueueException.class);
		ex.expectMessage("Queue is Full");
		queueList.addItem("Street");
	}

	@Test
	public void pushNullInQueueUsingList() throws QueueException {
		// Adding Null Element in Queue
		ex.expect(NullPointerException.class);
		ex.expectMessage("Can't add Null to Queue");
		queueList.addItem(null);
	}

	@Test
	public void testDeleteQueueUsingList() throws QueueException {
		// Deleting Element from Queue
		assertEquals("Wolf", queueList.deleteItem());
		assertEquals("of", queueList.deleteItem());
	}

	@Test
	public void testDeleteQueueUsingArrayUnderflow() throws QueueException {
		// Deleting from an Empty Stack
		queueList.deleteItem();
		queueList.deleteItem();
		queueList.deleteItem();
		ex.expect(QueueException.class);
		ex.expectMessage("Queue is Empty");
		queueList.deleteItem();
	}
}
