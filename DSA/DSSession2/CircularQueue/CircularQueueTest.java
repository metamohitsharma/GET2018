package GET2018.DSA.DSSession2.CircularQueue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This test class performs various Testcases on CircularQueue
 * 
 * @author Mohit Sharma
 *
 */
public class CircularQueueTest {

	CircularQueue circularQueue;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() throws QueueException {
		circularQueue = new CircularQueue(5);
		circularQueue.enQueue(3);
		circularQueue.enQueue(2);
		circularQueue.enQueue(4);
		circularQueue.enQueue(1);
	}

	@Test
	public void testEnQueueInCircularQueue() throws QueueException {
		// Adding Element in Queue
		assertEquals(true, circularQueue.enQueue(10));
	}

	@Test
	public void testEnQueueInFullQueue() throws QueueException {
		// Adding Element when Queue is Full
		circularQueue.enQueue(9);
		ex.expect(QueueException.class);
		ex.expectMessage("Queue is Full! Can't Add item.");
		circularQueue.enQueue(10);
	}

	@Test
	public void testPeekInEmptyQueueAtFirst() throws QueueException {
		// Peeking the Queue
		assertEquals(3, circularQueue.peek());
	}

	@Test
	public void testDeQueueInCircularQueue() throws QueueException {
		// Deleting Element from CircularQueue
		assertEquals(3, circularQueue.deQueue());
	}

	@Test
	public void testDeQueueInEmptyQueue() throws QueueException {
		// Deleting Element from an Empty CircularQueue
		circularQueue.deQueue();
		circularQueue.deQueue();
		circularQueue.deQueue();
		circularQueue.deQueue();
		ex.expect(QueueException.class);
		ex.expectMessage("Queue is empty! Can't remove item.");
		circularQueue.deQueue();
	}

	@Test
	public void testPeekInEmptyQueue() throws QueueException {
		circularQueue.deQueue();
		circularQueue.deQueue();
		circularQueue.deQueue();
		circularQueue.deQueue();
		ex.expect(QueueException.class);
		ex.expectMessage("Queue is empty! Can't Peek");
		circularQueue.peek();
	}

	@Test
	public void testEnqueueInFullQueueRandom() throws QueueException {
		assertEquals(true, circularQueue.enQueue(3));
		assertEquals(3, circularQueue.deQueue());
		assertEquals(2, circularQueue.deQueue());
		assertEquals(4, circularQueue.deQueue());
		assertEquals(true, circularQueue.enQueue(4));
		assertEquals(true, circularQueue.enQueue(1));
		assertEquals(true, circularQueue.enQueue(6));
		assertEquals(1, circularQueue.deQueue());
		assertEquals(true, circularQueue.enQueue(4));
	}
}
