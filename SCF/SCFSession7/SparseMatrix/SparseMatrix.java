package GET2018.SCF.SCFSession7.SparseMatrix;

/**
 * This class implements various methods in Sparse Matrix
 * 
 * @author Mohit Sharma
 *
 */
public final class SparseMatrix {
	final int sparseMatrix[][];
	final int rows;
	final int columns;

	public SparseMatrix(int inputMatrix[][]) throws SparseMatrixException {
		if (inputMatrix == null) {
			throw new NullPointerException("Input Matrix is Null");
		}
		if (inputMatrix.length == 0) {
			throw new SparseMatrixException("Matrix is Empty");
		}
		int lengthOfElements = 0;
		int lengthOfZeroElements = 0;
		rows = inputMatrix.length;
		columns = inputMatrix[0].length;

		/*
		 * Calculating No of Non-Zero Elements
		 */
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++) {
				if (inputMatrix[i][j] != 0) {
					lengthOfElements++;
				} else {
					lengthOfZeroElements++;
				}
			}
		}
		if (lengthOfZeroElements < lengthOfElements) {
			throw new SparseMatrixException("Given Matrix is not a Sparse Matrix");
		}
		sparseMatrix = new int[lengthOfElements][3];
		int index = 0;

		/*
		 * Storing only Non-Zero Values in sparseMatrix
		 */
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++) {
				if (inputMatrix[i][j] != 0) {
					sparseMatrix[index][0] = i;
					sparseMatrix[index][1] = j;
					sparseMatrix[index][2] = inputMatrix[i][j];
					index++;
				}
			}
		}
	}

	/**
	 * Initialize Matrix with Zeros
	 * 
	 * @param matrix
	 */
	static void initializeMatrixWithZero(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	/**
	 * Returns the Transpose of Matrix Complexity :- O(n)
	 * 
	 * @return
	 */
	int[][] transpose() {
		int transposeMatrix[][] = new int[columns][rows];
		SparseMatrix.initializeMatrixWithZero(transposeMatrix);
		for (int i = 0; i < sparseMatrix.length; i++) {
			transposeMatrix[sparseMatrix[i][1]][sparseMatrix[i][0]] = sparseMatrix[i][2];
		}
		return transposeMatrix;
	}

	/**
	 * Checks Symmetricity of Matrix Complexity :- O(n*n)
	 * 
	 * @return
	 * @throws SparseMatrixException
	 */
	boolean isSymmetricalMatrix() throws SparseMatrixException {
		if (rows != columns) {
			throw new SparseMatrixException("Matrix should be Square for checking Symmetricity");
		}
		for (int i = 0; i < sparseMatrix.length; i++) {
			boolean flag = false;
			for (int j = 0; j < sparseMatrix.length; j++) {
				if (sparseMatrix[i][0] == sparseMatrix[j][1] && sparseMatrix[i][1] == sparseMatrix[j][0]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Adding Two Sparse Matrices Complexity :- O(n)
	 * 
	 * @param matrix1
	 * @param matrix2
	 * @return
	 * @throws SparseMatrixException
	 */
	static int[][] addSparseMatrix(SparseMatrix matrix1, SparseMatrix matrix2) throws SparseMatrixException {
		if (matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns) {
			throw new SparseMatrixException("No. of Rows and Columns don't match in Addtion");
		}
		int addMatrix[][] = new int[matrix1.rows][matrix1.columns];
		SparseMatrix.initializeMatrixWithZero(addMatrix);
		int i = 0;
		int j = 0;
		for (; i < matrix1.sparseMatrix.length && j < matrix2.sparseMatrix.length;) {

			/*
			 * Comparing Row Index
			 */
			if (matrix1.sparseMatrix[i][0] == matrix2.sparseMatrix[j][0]) {

				/*
				 * Comparing Column Index
				 */
				if (matrix1.sparseMatrix[i][1] == matrix2.sparseMatrix[j][1]) {
					addMatrix[matrix1.sparseMatrix[i][0]][matrix1.sparseMatrix[i][1]] = matrix1.sparseMatrix[i][2]
							+ matrix2.sparseMatrix[j][2];
					i++;
					j++;
				} else if (matrix1.sparseMatrix[i][1] > matrix2.sparseMatrix[j][1]) {
					addMatrix[matrix2.sparseMatrix[j][0]][matrix2.sparseMatrix[j][1]] = matrix2.sparseMatrix[j][2];
					j++;
				} else {
					addMatrix[matrix1.sparseMatrix[i][0]][matrix1.sparseMatrix[i][1]] = matrix1.sparseMatrix[i][2];
					i++;
				}
			} else if (matrix1.sparseMatrix[i][0] > matrix2.sparseMatrix[j][0]) {
				addMatrix[matrix2.sparseMatrix[j][0]][matrix2.sparseMatrix[j][1]] = matrix2.sparseMatrix[j][2];
				j++;
			} else {
				addMatrix[matrix1.sparseMatrix[i][0]][matrix1.sparseMatrix[i][1]] = matrix1.sparseMatrix[i][2];
				i++;
			}
		}

		/*
		 * Adding Matrix1 remaining Elements
		 */
		while (i < matrix1.sparseMatrix.length) {
			addMatrix[matrix1.sparseMatrix[i][0]][matrix1.sparseMatrix[i][1]] = matrix1.sparseMatrix[i][2];
			i++;
		}

		/*
		 * Adding Matrix2 remaining Elements
		 */
		while (j < matrix2.sparseMatrix.length) {
			addMatrix[matrix2.sparseMatrix[j][0]][matrix2.sparseMatrix[j][1]] = matrix2.sparseMatrix[j][2];
			j++;
		}
		return addMatrix;
	}

	/**
	 * Multiplying Two Matrices Complexity :- O(n*n)
	 * 
	 * @param matrix1
	 * @param matrix2
	 * @return
	 * @throws SparseMatrixException
	 */
	static int[][] multiplySparseMatrix(SparseMatrix matrix1, SparseMatrix matrix2) throws SparseMatrixException {
		if (matrix1.columns != matrix2.rows) {
			throw new SparseMatrixException(
					"No of Columns of Matrix1 should be equal to No of Rows in Matrix2 for multiplication");
		}
		int multiplyMatrix[][] = new int[matrix1.rows][matrix2.columns];
		SparseMatrix.initializeMatrixWithZero(multiplyMatrix);
		for (int i = 0; i < matrix1.sparseMatrix.length; i++) {
			for (int j = 0; j < matrix2.sparseMatrix.length; j++) {
				if (matrix1.sparseMatrix[i][1] == matrix2.sparseMatrix[j][0]) {
					multiplyMatrix[matrix1.sparseMatrix[i][0]][matrix2.sparseMatrix[j][1]] += matrix1.sparseMatrix[i][2]
							* matrix2.sparseMatrix[j][2];
				}
			}
		}
		return multiplyMatrix;
	}

	@SuppressWarnings("serial")
	static class SparseMatrixException extends Exception {
		String messageException;

		public SparseMatrixException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
