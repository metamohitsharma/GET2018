package GET2018.PF.PFAssignment2.JobScheduler;

import java.text.DecimalFormat;

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
		this.noOfProcess = noOfProcess;
		processes = processInput;
		completionTime = new int[noOfProcess];
		turnAroundTime = new int[noOfProcess];
		waitingTime = new int[noOfProcess];
	}

	int[] calCompletionTime() {
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

	int[] calTurnAroundTime() {
		for (int i = 0; i < noOfProcess; i++) {
			turnAroundTime[i] = completionTime[i] - processes[i][0];
		}
		return turnAroundTime;
	}

	int[] calWaitingTime() {
		for (int i = 0; i < noOfProcess; i++) {
			waitingTime[i] = turnAroundTime[i] - processes[i][1];
		}
		return waitingTime;
	}

	double averageWaitingTime() {
		DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");
		for (int i = 0; i < noOfProcess; i++) {
			totalWaitingTime += waitingTime[i];
		}
		avgWaitingTime = (double) totalWaitingTime / noOfProcess;
		return Double.parseDouble(decimalFormatSpecifier.format(avgWaitingTime));
	}

	int maxWaitingTime() {
		for (int i = 0; i < noOfProcess; i++) {
			if (maximumWaitingTime < waitingTime[i]) {
				maximumWaitingTime = waitingTime[i];
			}
		}
		return maximumWaitingTime;
	}
}
