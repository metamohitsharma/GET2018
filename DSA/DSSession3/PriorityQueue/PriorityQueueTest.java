package GET2018.DSA.DSSession3.PriorityQueue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on Priority Queue
 * 
 * @author Mohit Sharma
 *
 */
public class PriorityQueueTest {

	PriorityQueue priorityQueue;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() {
		priorityQueue = new PriorityQueue(5);
		priorityQueue.enqueue("Process-1", 2);
		priorityQueue.enqueue("Process-2", 1);
		priorityQueue.enqueue("Process-3", 5);
		priorityQueue.enqueue("Process-4", 6);
	}

	@Test
	public void enqueueTest() {
		// Adding Process-5 having Priority 3
		assertTrue(priorityQueue.enqueue("Process-5", 3));
	}

	@Test
	public void dequeueTest() {
		// Deleting Process having MaxPriority
		assertEquals("Process-4", priorityQueue.dequeue());
	}

	@Test
	public void dequeueEmptyQueueTest() {
		// Deleting After Queue is Empty
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		ex.expect(IndexOutOfBoundsException.class);
		ex.expectMessage("Queue is empty, Can't Delete");
		priorityQueue.dequeue();
	}

	@Test
	public void peekTest() {
		// Peeking Queue
		assertEquals("Process-4", priorityQueue.peek());
	}

	@Test
	public void peekEmptyQueueTest() {
		// Peeking Queue when it is Empty
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		ex.expect(IndexOutOfBoundsException.class);
		ex.expectMessage("Queue is empty, Can't Peek");
		priorityQueue.peek();
	}

	@Test
	public void enQueueInFullTest() {
		// Adding Process After Queue is Full
		priorityQueue.enqueue("Process-5", 9);
		ex.expect(IndexOutOfBoundsException.class);
		ex.expectMessage("Queue Array is full, Can't Insert");
		priorityQueue.enqueue("Process-6", 0);
	}

}
