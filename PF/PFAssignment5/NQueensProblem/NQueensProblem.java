package GET2018.PF.PFAssignment5.NQueensProblem;

/**
 * This Class computes The N Queens Problem
 * 
 * @author Mohit Sharma
 *
 */
public class NQueensProblem {

	/**
	 * Checks whether N Queens Problem can be solved for dimensionOfMatrix
	 * 
	 * @param board
	 * @param startColumn
	 * @param dimensionOfMatrix
	 * @return true if the solution exits otherwise false
	 * @throws NQueensException
	 */
	boolean nQueen(int board[][], int startColumn, int dimensionOfMatrix) throws NQueensException {
		if (board == null) {
			throw new NullPointerException("Board Array is Null");
		} else if (board.length == 0) {
			throw new NQueensException("Board Array is Empty");
		} else if (board.length != dimensionOfMatrix || board[0].length != dimensionOfMatrix) {
			throw new NQueensException("Board Array not Valid");
		}
		// Base Condition for recursion of NQueen
		if (startColumn >= dimensionOfMatrix) {
			return true;
		}
		for (int i = 0; i < dimensionOfMatrix; i++) {
			if (noQueenCollision(board, i, startColumn, dimensionOfMatrix)) {
				board[i][startColumn] = 1;
				if (nQueen(board, startColumn + 1, dimensionOfMatrix) == true) {
					return true;
				}
				/*
				 * If placing queen in board[i][startColumn] doesn't lead to a solution then
				 * remove queen from board[i][startColumn] i.e., BackTracking
				 */
				board[i][startColumn] = 0;
			}
		}
		return false;
	}

	/**
	 * Checks whether a Queen can be placed without conflicting with other Queen
	 * 
	 * @param board
	 * @param leftRow
	 * @param leftColumn
	 * @param dimensionOfMatrix
	 * @return
	 */
	boolean noQueenCollision(int board[][], int leftRow, int leftColumn, int dimensionOfMatrix) {
		/*
		 * Check Row on Left Side
		 */
		for (int i = 0; i < leftColumn; i++) {
			if (board[leftRow][i] == 1) {
				return false;
			}
		}

		/*
		 * Checking Upper Diagonal
		 */
		for (int i = leftRow, j = leftColumn; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		/*
		 * Checking Lower Diagonal
		 */
		for (int i = leftRow, j = leftColumn; j >= 0 && i < dimensionOfMatrix; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("serial")
	static class NQueensException extends Exception {
		String messageException;

		public NQueensException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
