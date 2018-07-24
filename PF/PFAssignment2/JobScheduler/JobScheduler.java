package GET2018.PF.PFAssignment2.JobScheduler;

import java.text.DecimalFormat;

/**
 * This Class schedules Processes on the First Come First Serve Basis
 * 
 * @author Mohit Sharma
 *
 */
public class JobScheduler {
	int processes[][];
	int completionTime[];
	int turnAroundTime[];
	int waitingTime[];
	int totalWaitingTime = 0;
	int maximumWaitingTime = 0;
	int noOfProcess = 0;
	double avgWaitingTime;

	public JobScheduler(int noOfProcess, int[][] processInput) {
		if (noOfProcess == 0) {
			throw new AssertionError("No Of Processes can't be Zero");
		}
		if (processInput.equals(null)) {
			throw new NullPointerException(
					"Process Arrival time and Burst Time can't be Null");
		}
		this.noOfProcess = noOfProcess;
		for (int i = 0; i < processInput.length; i++) {
			for (int j = 0; j < processInput[0].length; j++) {
				if (processInput[i][j] < 0) {
					throw new AssertionError(
							"Arrival Time or Burst Time can't be Negative");
				}
			}
		}
		processes = processInput;
		completionTime = new int[noOfProcess];
		turnAroundTime = new int[noOfProcess];
		waitingTime = new int[noOfProcess];
	}

	/**
	 * Computes Completion Time of Processes
	 * 
	 * @return
	 */
	int[] calCompletionTime() {

		/*
		 * process[i][0] is Arrival Time of process i, process[i][1] is Burst
		 * Time of process i
		 */
		for (int i = 0; i < noOfProcess; i++) {
			if (i == 0) {
				completionTime[i] = processes[i][0] + processes[i][1];
			} else {
				if (processes[i][0] > completionTime[i - 1]) {
					completionTime[i] = processes[i][0] + processes[i][1];
				} else {
					completionTime[i] = completionTime[i - 1] + processes[i][1];
				}
			}
		}
		return completionTime;
	}

	/**
	 * Computes Turn Around Time of Processes
	 * 
	 * @return
	 */
	int[] calTurnAroundTime() {
		for (int i = 0; i < noOfProcess; i++) {
			turnAroundTime[i] = completionTime[i] - processes[i][0];
		}
		return turnAroundTime;
	}

	/**
	 * Computes Waiting Time of Processes
	 * 
	 * @return
	 */
	int[] calWaitingTime() {
		for (int i = 0; i < noOfProcess; i++) {
			waitingTime[i] = turnAroundTime[i] - processes[i][1];
		}
		return waitingTime;
	}

	/**
	 * Computes Average Waiting Time of Processes
	 * 
	 * @return
	 */
	double averageWaitingTime() {
		DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");
		for (int i = 0; i < noOfProcess; i++) {
			totalWaitingTime += waitingTime[i];
		}
		avgWaitingTime = (double) totalWaitingTime / noOfProcess;
		return Double
				.parseDouble(decimalFormatSpecifier.format(avgWaitingTime));
	}

	/**
	 * Computes Maximum Waiting Time of Processes
	 * 
	 * @return
	 */
	int maxWaitingTime() {
		for (int i = 0; i < noOfProcess; i++) {
			if (maximumWaitingTime < waitingTime[i]) {
				maximumWaitingTime = waitingTime[i];
			}
		}
		return maximumWaitingTime;
	}
}
