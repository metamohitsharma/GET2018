package GET2018.PF.PFAssignment6.Polynomial;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import GET2018.PF.PFAssignment6.Polynomial.Poly.PolynomialException;

public class PolyTest {
	static Poly poly1;
	static Poly poly2;

	@BeforeClass
	public static void init() throws PolynomialException {
		poly1 = new Poly(new int[][] { { 4, 2 }, { 12, 4 }, { 2, 1 }, { 0, 5 } });
		poly2 = new Poly(new int[][] { { 3, 1 }, { 15, 4 }, { 6, 3 }, { -2, 6 } });
	}

	@Test
	public void evalutePolyTest() {
		assertEquals(1014, poly1.evaluate(3), 0);

	}

	@Test
	public void degreePolyTest() {
		assertEquals(4, poly1.degree());
	}

	@Test
	public void addPolyTest() {
		assertArrayEquals(new int[][] { { 5, 1 }, { 4, 2 }, { 6, 3 }, { 27, 4 }, { -2, 6 } },
				Poly.addPoly(poly1, poly2));
	}

	@Test
	public void multiplyPolyTest() {
		assertArrayEquals(new int[][] { { 6, 2 }, { 12, 3 }, { 12, 4 }, { 90, 5 }, { 60, 6 }, { 68, 7 }, { 172, 8 },
				{ -24, 10 } }, Poly.multiplyPoly(poly1, poly2));
	}

	@Test
	public void intializeWithNull() throws PolynomialException {
		try {
			new Poly(null);
		} catch (NullPointerException ex) {
			assertEquals("Input Array is Null", ex.getMessage());
		}
	}

	@Test
	public void widthExceptionTest() throws PolynomialException {
		try {
			new Poly(new int[][] { { 2 }, { 1, 5 }, { 2, 5, 6 } });
		} catch (PolynomialException ex) {
			assertEquals("Array Width can't be more or less than 2", ex.getMessageException());
		}
	}

	@Test
	public void lengthExceptionTest() throws PolynomialException {
		try {
			new Poly(new int[][] {});
		} catch (PolynomialException ex) {
			assertEquals("Array Length can't be Zero", ex.getMessageException());
		}
	}
}
