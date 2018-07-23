package GET2018.PF.PFAssignment5.KnightProblem;

/**
 * This class solves the Knight Problem
 * 
 * @author Mohit Sharma
 *
 */
public class KnightProblem {
	int sizeOfBoard = 8;

	/**
	 * Checks whether xPoint and yPoint are valid on ChessBoard
	 * 
	 * @param xPoint
	 * @param yPoint
	 * @param sol
	 * @return
	 */
	boolean isSafe(int xPoint, int yPoint, int tourMatrix[][]) {
		return (xPoint >= 0 && xPoint < sizeOfBoard && yPoint >= 0 && yPoint < sizeOfBoard
				&& tourMatrix[xPoint][yPoint] == -1);
	}

	/**
	 * It prints the tourMatrix of the Knight
	 * 
	 * @param sol
	 */
	void printSolution(int sol[][]) {
		for (int x = 0; x < sizeOfBoard; x++) {
			for (int y = 0; y < sizeOfBoard; y++) {
				System.out.print(sol[x][y] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Initializes the parameters used to solve Knight's Problem
	 * 
	 * @return true if path is closed otherwise false
	 */
	boolean init() {
		int tourMatrix[][] = new int[8][8];
		for (int x = 0; x < sizeOfBoard; x++) {
			for (int y = 0; y < sizeOfBoard; y++) {
				tourMatrix[x][y] = -1;
			}
		}

		/*
		 * xMove[] and yMove[] define next move of Knight. xMove[] is for next value of
		 * x coordinate yMove[] is for next value of y coordinate
		 */
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		tourMatrix[0][0] = 0;
		if (!solveKnightProblem(0, 0, 1, tourMatrix, xMove, yMove)) {
			return false;
		} else {
			printSolution(tourMatrix);
		}
		return true;
	}

	/**
	 * Recursive method to solve the Knight's Problem
	 * 
	 * @param xPoint
	 * @param yPoint
	 * @param noOfMove
	 * @param tourMatrix
	 * @param xMove
	 * @param yMove
	 * @return
	 */
	boolean solveKnightProblem(int xPoint, int yPoint, int noOfMove, int tourMatrix[][], int xMove[], int yMove[]) {
		int nextXPoint;
		int nextYPoint;
		if (noOfMove == sizeOfBoard * sizeOfBoard) {
			return true;
		}
		for (int i = 0; i < 8; i++) {
			nextXPoint = xPoint + xMove[i];
			nextYPoint = yPoint + yMove[i];
			if (isSafe(nextXPoint, nextYPoint, tourMatrix)) {
				tourMatrix[nextXPoint][nextYPoint] = noOfMove;
				if (solveKnightProblem(nextXPoint, nextYPoint, noOfMove + 1, tourMatrix, xMove, yMove)) {
					return true;
				} else {
					// BackTracking
					tourMatrix[nextXPoint][nextYPoint] = -1;
				}
			}
		}
		return false;
	}
}
