package GET2018.PF.PFAssignment3.AreaCalculator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import GET2018.PF.PFAssignment3.AreaCalculator.AreaCalculator.AreaCalculatorException;

/**
 * This Class performs different test on AreaCalculator Class
 * 
 * @author Mohit Sharma
 *
 */
public class AreaCalculatorTest {

	AreaCalculator areaCalculator;

	@Before
	public void init() {
		areaCalculator = new AreaCalculator();
	}

	@Test
	public void testAreaTriangle() throws AreaCalculatorException {
		assertEquals(60.00, areaCalculator.areaOfTriangle(10, 12), 0);
	}

	@Test
	public void testArearectangle() throws AreaCalculatorException {
		assertEquals(84.00, areaCalculator.areaOfRectangle(7, 12), 0);
	}

	@Test
	public void testAreaSquare() throws AreaCalculatorException {
		assertEquals(163.84, areaCalculator.areaOfSquare(12.8), 0);
	}

	@Test
	public void testAreaCircle() throws AreaCalculatorException {
		assertEquals(56.21, areaCalculator.areaOfCircle(4.23), 0);
	}

	@Test
	public void testAreaTriangleWithNegativeInputs() {
		try {
			areaCalculator.areaOfTriangle(-1, 12);
		} catch (AreaCalculatorException ex) {
			assertEquals("Negative Width or Height Not Allowed in Triangle", ex.getMessageException());
		}
	}

	@Test
	public void testArearectangleWithNegativeInputs() {
		try {
			areaCalculator.areaOfRectangle(-1, -12);
		} catch (AreaCalculatorException ex) {
			assertEquals("Negative Width or Height Not Allowed in Rectangle", ex.getMessageException());
		}
	}

	@Test
	public void testAreaSquareWithNegativeInputs() {
		try {
			areaCalculator.areaOfSquare(-6);
		} catch (AreaCalculatorException ex) {
			assertEquals("Negative Width Not Allowed in Square", ex.getMessageException());
		}
	}

	@Test
	public void testAreaCircleWithNegativeInputs() {
		try {
			areaCalculator.areaOfCircle(-56);
		} catch (AreaCalculatorException ex) {
			assertEquals("Negative Radius Not Allowed in Circle", ex.getMessageException());
		}
	}
}