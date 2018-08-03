package GET2018.SCF.SCFSession7.SparseMatrix;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import GET2018.SCF.SCFSession7.SparseMatrix.SparseMatrix.SparseMatrixException;

/**
 * This TestClass test various TestCases on methods of SparseMatrix Class
 * 
 * @author Mohit Sharma
 *
 */
public class SparseMatrixTest {
	static SparseMatrix sparseMatrix;

	@BeforeClass
	public static void init() throws SparseMatrixException {
		/*
		 * Given Matrix
		 * |0	4	0|
		 * |1	6	0|
		 * |0	0	5|
		 * |0	10	0|
		 */
		sparseMatrix = new SparseMatrix(new int[][] { { 0, 4, 0 }, { 1, 6, 0 }, { 0, 0, 5 }, { 0, 10, 0 } });
	}

	@Test
	public void transposeTest() {
		/*
		 * Transpose of Given Matrix
		 * |0	1	0	0 |
		 * |4	6	0   10|	
		 * |0	0	5	0 |
		 */
		assertArrayEquals(new int[][] { { 0, 1, 0, 0 }, { 4, 6, 0, 10 }, { 0, 0, 5, 0 } }, sparseMatrix.transpose());
	}

	@Test
	public void symmetricalTest() throws SparseMatrixException {
		/*
		 * Given Symmetrical Matrix
		 * |0	4	0|
		 * |4	0	0|
		 * |0	0	5|
		 */
		assertTrue(new SparseMatrix(new int[][] { { 0, 4, 0 }, { 4, 0, 0 }, { 0, 0, 5 } }).isSymmetricalMatrix());
	}

	@Test
	public void additionTest() throws SparseMatrixException {
		/*
		 * Given Second Matrix for Addition
		 * |1	2	0|
		 * |0  -3	0|	
		 * |0	2	0|
		 * |0  10	0|
		 * 
		 * After Addition
		 * |1	6	0|
		 * |1	3	0|
		 * |0	2	5|
		 * |0	20	0|
		 */
		SparseMatrix matrix2 = new SparseMatrix(new int[][] { { 1, 2, 0 }, { 0, -3, 0 }, { 0, 2, 0 }, { 0, 10, 0 } });
		assertArrayEquals(new int[][] { { 1, 6, 0 }, { 1, 3, 0 }, { 0, 2, 5 }, { 0, 20, 0 } },
				SparseMatrix.addSparseMatrix(sparseMatrix, matrix2));
	}

	@Test
	public void multiplyTest() throws SparseMatrixException {
		/*
		 * Given Second Matrix for Multiplication
		 * |1	2	0	0 |
		 * |0  -3	0	10|
		 * |0	2	0	0 |
		 * 
		 * After Multiplication
		 * |0	-12		0	40 |
		 * |1	-16		0	60 |
		 * |0	 10		0	0  |
		 * |0	-30		0	100|
		 */
		SparseMatrix matrix2 = new SparseMatrix(new int[][] { { 1, 2, 0, 0 }, { 0, -3, 0, 10 }, { 0, 2, 0, 0 } });
		assertArrayEquals(new int[][] { { 0, -12, 0, 40 }, { 1, -16, 0, 60 }, { 0, 10, 0, 0 }, { 0, -30, 0, 100 } },
				SparseMatrix.multiplySparseMatrix(sparseMatrix, matrix2));
	}

	@Test
	public void intializeWithNull() throws SparseMatrixException {
		try {
			new SparseMatrix(null);
		} catch (NullPointerException ex) {
			assertEquals("Input Matrix is Null", ex.getMessage());
		}
	}

	@Test
	public void intializeLengthWithZero() {
		try {
			new SparseMatrix(new int[][] {});
		} catch (SparseMatrixException ex) {
			assertEquals("Matrix is Empty", ex.getMessageException());
		}
	}

	@Test
	public void nonSquareMatrixInSymmetricalTest() {
		try {
			sparseMatrix.isSymmetricalMatrix();
		} catch (SparseMatrixException ex) {
			assertEquals("Matrix should be Square for checking Symmetricity", ex.getMessageException());
		}
	}

	@Test
	public void checkSparseMatrixAddition() {
		/*
		 * Given Second Matrix for Addition
		 * |1	2	0	2|
		 * |0	-3	0	0|
		 * |0	2	0	1|
		 * |0	10	0	0|
		 */
		try {
			SparseMatrix matrix2 = new SparseMatrix(
					new int[][] { { 1, 2, 0, 2 }, { 0, -3, 0, 0 }, { 0, 2, 0, 1 }, { 0, 10, 0, 0 } });
			SparseMatrix.addSparseMatrix(sparseMatrix, matrix2);
		} catch (SparseMatrixException ex) {
			assertEquals("No. of Rows and Columns don't match in Addtion", ex.getMessageException());
		}
	}

	@Test
	public void checkSparseMatrixMultiplication() {
		/*
		 * Given Second Matrix for Multiplication
		 * |1	2	0	2|
		 * |0	-3	0	0|
		 * |0	2	0	1|
		 * |0	10	0	0|
		 */
		try {
			SparseMatrix matrix2 = new SparseMatrix(
					new int[][] { { 1, 2, 0, 2 }, { 0, -3, 0, 0 }, { 0, 2, 0, 1 }, { 0, 10, 0, 0 } });
			SparseMatrix.multiplySparseMatrix(sparseMatrix, matrix2);
		} catch (SparseMatrixException ex) {
			assertEquals("No of Columns of Matrix1 should be equal to No of Rows in Matrix2 for multiplication",
					ex.getMessageException());
		}
	}

	@Test
	public void checkSparseMatrix() {
		/*
		 * Given Matrix
		 * |1	2	4|
		 * |0	4	5|
		 * |1	0	0|
		 */
		try {
			new SparseMatrix(new int[][] { { 1, 2, 4 }, { 0, 4, 5 }, { 1, 0, 0 } });
		} catch (SparseMatrixException ex) {
			assertEquals("Given Matrix is not a Sparse Matrix", ex.getMessageException());
		}
	}
}
