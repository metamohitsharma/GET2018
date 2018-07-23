package GET2018.PF.PFAssignment3.AreaCalculator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AreaCalculatorNegativeTest {

	AreaCalculator areaCalculator;

	@Before
	public void init() {
		areaCalculator = new AreaCalculator();
	}

	@Test
	public void testAreaTriangle() {
		assertNotEquals(43.56, areaCalculator.areaOfTriangle(10, 12));
	}

	@Test
	public void testArearectangle() {
		assertNotEquals(84.23, areaCalculator.areaOfRectangle(7, 12));
	}

	@Test
	public void testAreaSquare() {
		assertNotEquals(0, areaCalculator.areaOfSquare(12.8));
	}

	@Test
	public void testAreaCircle() {
		assertNotEquals(66.21, areaCalculator.areaOfCircle(4.23));
	}
}
