package GET2018.PF.PFAssignment2.JobScheduler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JobSchedulerTestCase {

	@Test
	void test() {
		JobScheduler fcfs = new JobScheduler(3, new int[][] { { 0, 5 }, { 3, 9 }, { 6, 6 } });
		assertArrayEquals(new int[] { 5, 14, 20 }, fcfs.calCompletionTime());
		assertArrayEquals(new int[] { 5, 11, 14 }, fcfs.calTurnAroundTime());
		assertArrayEquals(new int[] { 0, 2, 8 }, fcfs.calWaitingTime());
		assertEquals(3.33, fcfs.averageWaitingTime());
		assertEquals(8, fcfs.maxWaitingTime());
	}
}
