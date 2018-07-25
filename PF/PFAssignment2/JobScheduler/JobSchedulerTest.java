package GET2018.PF.PFAssignment2.JobScheduler;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import GET2018.PF.PFAssignment2.JobScheduler.JobScheduler.JobSchedulerException;

public class JobSchedulerTest {
	static JobScheduler fcfs;

	@BeforeClass
	static public void init() throws JobSchedulerException {
		fcfs = new JobScheduler(3, new int[][] { { 0, 5 }, { 3, 9 }, { 6, 6 } });
	}

	@Test
	public void completionTimeTestWithValidInput() {
		assertArrayEquals(new int[] { 5, 14, 20 }, fcfs.calCompletionTime());
	}

	@Test
	public void turnAroundTimeTestWithValidInput() {
		fcfs.calCompletionTime();
		assertArrayEquals(new int[] { 5, 11, 14 }, fcfs.calTurnAroundTime());
	}

	@Test
	public void averageWaitingTimeTestWithValidInput() {
		fcfs.calCompletionTime();
		fcfs.calTurnAroundTime();
		fcfs.calWaitingTime();
		assertEquals(3.33, fcfs.averageWaitingTime(), 0);
	}

	@Test
	public void maximumWaitingTimeTestWithValidInput() {
		fcfs.calCompletionTime();
		fcfs.calTurnAroundTime();
		fcfs.calWaitingTime();
		assertEquals(8, fcfs.maxWaitingTime());
	}

	@Test
	public void waitingTimeTestWithValidInput() {
		fcfs.calCompletionTime();
		fcfs.calTurnAroundTime();
		assertArrayEquals(new int[] { 0, 2, 8 }, fcfs.calWaitingTime());
	}

	@Test
	public void initializeWithInvalidInputs() {
		try {
			fcfs = new JobScheduler(0, new int[][] { { 0, 5 }, { 3, 9 },
					{ 6, 6 } });
		} catch (JobSchedulerException ex) {
			assertEquals("No Of Processes can't be Zero",
					ex.getMessageException());
		}
	}

	@Test
	public void initializeWithNull() {
		try {
			fcfs = new JobScheduler(3, null);
		} catch (Exception ex) {
			assertEquals("Process Arrival time and Burst Time can't be Null",
					ex.getMessage());
		}
	}

	@Test
	public void initializeWithNegativeValues() {
		try {
			fcfs = new JobScheduler(3, new int[][] { { 0, -5 }, { -3, 9 },
					{ -6, 6 } });
		} catch (JobSchedulerException ex) {
			assertEquals("Arrival Time or Burst Time can't be Negative",
					ex.getMessageException());
		}
	}
}
