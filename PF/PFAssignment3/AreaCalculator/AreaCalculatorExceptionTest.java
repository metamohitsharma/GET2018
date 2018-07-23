package GET2018.PF.PFAssignment3.AreaCalculator;

import org.junit.Before;
import org.junit.Test;

public class AreaCalculatorExceptionTest {

	AreaCalculator areaCalculator;

	@Before
	public void init() {
		areaCalculator = new AreaCalculator();
	}

	@Test(expected = AssertionError.class)
	public void testAreaTriangle() {
		areaCalculator.areaOfTriangle(-1, 12);
	}

	@Test(expected = AssertionError.class)
	public void testArearectangle() {
		areaCalculator.areaOfRectangle(-1, -12);
	}

	@Test(expected = AssertionError.class)
	public void testAreaSquare() {
		areaCalculator.areaOfSquare(-6);
	}

	@Test(expected = AssertionError.class)
	public void testAreaCircle() {
		areaCalculator.areaOfCircle(-56);
	}

}
