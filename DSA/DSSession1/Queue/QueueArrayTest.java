package GET2018.DSA.DSSession1.Queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on QueueArray class methods
 * 
 * @author Mohit Sharma
 *
 */
public class QueueArrayTest {
	QueueArray queueArray;

	@Rule
	public ExpectedException ex = ExpectedException.none();

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
	public void testPushQueueUsingArrayOverflow() throws QueueException {
		// Adding element when Queue is Full
		queueArray.addItem("Stars");
		ex.expect(QueueException.class);
		ex.expectMessage("Queue is Full");
		queueArray.addItem("Written");
	}

	@Test
	public void pushNullInQueueUsingArray() throws QueueException {
		// Adding Null Element in Queue
		ex.expect(NullPointerException.class);
		ex.expectMessage("Can't add Null to Queue");
		queueArray.addItem(null);
	}

	@Test
	public void testDeleteQueueUsingArray() throws QueueException {
		// Deleting Element from Queue
		assertEquals("The", queueArray.deleteItem());
		assertEquals("Fault", queueArray.deleteItem());
	}

	@Test
	public void testDeleteQueueUsingArrayUnderflow() throws QueueException {
		// Deleting from an Empty Stack
		queueArray.deleteItem();
		queueArray.deleteItem();
		queueArray.deleteItem();
		queueArray.deleteItem();
		ex.expect(QueueException.class);
		ex.expectMessage("Queue is Empty");
		queueArray.deleteItem();
	}
}