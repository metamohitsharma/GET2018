package GET2018.PF.PFAssignment3.AreaCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AreaCalculatorTest {

	@Test
	void test() {
		AreaCalculator areaCalculator = new AreaCalculator();
		assertEquals(60.00, areaCalculator.areaOfTriangle(10, 12));
		assertEquals(84.00, areaCalculator.areaOfRectangle(7, 12));
		assertEquals(163.84, areaCalculator.areaOfSquare(12.8));
		assertEquals(56.21, areaCalculator.areaOfCircle(4.23));
	}
}
