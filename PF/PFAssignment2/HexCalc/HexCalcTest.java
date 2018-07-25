package GET2018.PF.PFAssignment2.HexCalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HexCalcTest {
	HexCalc hexaCalculator1;
	HexCalc hexaCalculator2;

	@Before
	public void init() {
		hexaCalculator1 = new HexCalc("4CB");
		hexaCalculator2 = new HexCalc("21A");
	}

	@Test
	public void additionHexatestWithValidInput() {
		assertEquals("6E5", hexaCalculator1.addHexaDecimal(hexaCalculator2));
	}

	@Test
	public void subtractionHexatestWithValidInput() {
		assertEquals("2B1",
				hexaCalculator1.subtractHexaDecimal(hexaCalculator2));
	}

	@Test
	public void multiplicationHexatestWithValidInput() {
		assertEquals("A129E",
				hexaCalculator1.multiplyHexaDecimal(hexaCalculator2));
	}

	@Test
	public void divisionHexatestWithValidInput() {
		assertEquals("2", hexaCalculator1.divisionHexaDecimal(hexaCalculator2));
	}

	@Test
	public void isGreaterHexatestWithValidInput() {
		assertTrue(hexaCalculator1.isGreaterThan(hexaCalculator2));
	}

	@Test
	public void isLessHexatestWithValidInput() {
		assertFalse(hexaCalculator1.isLessThan(hexaCalculator2));
	}

	@Test
	public void isEqualHexatestWithValidInput() {
		assertFalse(hexaCalculator1.isEqualTo(hexaCalculator2));
	}

	@Test
	public void intializeWithNullTest() {
		try {
			hexaCalculator1 = new HexCalc(null);
		} catch (NullPointerException e) {
			assertEquals("HexaDecimal No is Null", e.getMessage());
		}
	}

	@Test
	public void addtionHexCalcWithNullPointer() {
		try {
			hexaCalculator1.addHexaDecimal(null);
		} catch (NullPointerException e) {
			assertEquals("HexaDecimal No is Null in Addition", e.getMessage());
		}
	}

	@Test
	public void subtractionHexCalcWithNullPointer() {
		try {
			hexaCalculator1.subtractHexaDecimal(null);
		} catch (NullPointerException e) {
			assertEquals("HexaDecimal No is Null in Subtraction",
					e.getMessage());
		}
	}

	@Test
	public void mulitplicationHexCalcWithNullPointer() {
		try {
			hexaCalculator1.multiplyHexaDecimal(null);
		} catch (NullPointerException e) {
			assertEquals("HexaDecimal No is Null in Multiplication",
					e.getMessage());
		}
	}

	@Test
	public void divisionHexCalcWithNullPointer() {
		try {
			hexaCalculator1.divisionHexaDecimal(null);
		} catch (NullPointerException e) {
			assertEquals("HexaDecimal No is Null in Division", e.getMessage());
		}
	}

	@Test
	public void isGreaterHexCalcWithNullPointer() {
		try {
			hexaCalculator1.isGreaterThan(null);
		} catch (NullPointerException e) {
			assertEquals("HexaDecimal No is Null in Greater than",
					e.getMessage());
		}
	}

	@Test
	public void isLessHexCalcWithNullPointer() {
		try {
			hexaCalculator1.isLessThan(null);
		} catch (NullPointerException e) {
			assertEquals("HexaDecimal No is Null in Less Than", e.getMessage());
		}
	}

	@Test
	public void isEqualHexCalcWithNullPointer() {
		try {
			hexaCalculator1.isEqualTo(null);
		} catch (NullPointerException e) {
			assertEquals("HexaDecimal No is Null in Equal to", e.getMessage());
		}
	}

	@Test
	public void divisionHexCalcWithSecondNumberZero() {
		try {
			hexaCalculator2 = new HexCalc("0");
			hexaCalculator1.divisionHexaDecimal(hexaCalculator2);
		} catch (ArithmeticException e) {
			assertEquals("/ by Zero is not Allowed in Division", e.getMessage());
		}
	}

	@Test
	public void additionHexCalcWithSingleInvalidInput() {
		try {
			hexaCalculator1 = new HexCalc("45GH");
			hexaCalculator1.addHexaDecimal(hexaCalculator2);
		} catch (NumberFormatException e) {
			assertEquals("HexaDecimal No Invalid", e.getMessage());
		}
	}

	@Test
	public void additionHexCalcWithBothInvalidInput() {
		try {
			hexaCalculator1 = new HexCalc("45GH!");
			hexaCalculator2 = new HexCalc("7-l'");
			hexaCalculator1.addHexaDecimal(hexaCalculator2);
		} catch (NumberFormatException e) {
			assertEquals("HexaDecimal No Invalid", e.getMessage());
		}
	}
}
