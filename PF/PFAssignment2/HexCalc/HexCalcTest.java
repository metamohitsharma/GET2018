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

	@Test(expected = NullPointerException.class)
	public void intializeWithNullTest() {
		hexaCalculator1 = new HexCalc(null);
	}

	@Test(expected = NullPointerException.class)
	public void addtionHexCalcWithNullPointer() {
		hexaCalculator1.addHexaDecimal(null);
	}

	@Test(expected = NullPointerException.class)
	public void subtractionHexCalcWithNullPointer() {
		hexaCalculator1.subtractHexaDecimal(null);
	}

	@Test(expected = NullPointerException.class)
	public void mulitplicationHexCalcWithNullPointer() {
		hexaCalculator1.multiplyHexaDecimal(null);
	}

	@Test(expected = NullPointerException.class)
	public void divisionHexCalcWithNullPointer() {
		hexaCalculator1.divisionHexaDecimal(null);
	}

	@Test(expected = NullPointerException.class)
	public void isGreaterHexCalcWithNullPointer() {
		hexaCalculator1.isGreaterThan(null);
	}

	@Test(expected = NullPointerException.class)
	public void isLessHexCalcWithNullPointer() {
		hexaCalculator1.isLessThan(null);
	}

	@Test(expected = NullPointerException.class)
	public void isEqualHexCalcWithNullPointer() {
		hexaCalculator1.isEqualTo(null);
	}

	@Test(expected = ArithmeticException.class)
	public void divisionHexCalcWithSecondNumberZero() {
		hexaCalculator2 = new HexCalc("0");
		hexaCalculator1.divisionHexaDecimal(hexaCalculator2);
	}

	@Test(expected = NumberFormatException.class)
	public void additionHexCalcWithSingleInvalidInput() {
		hexaCalculator1 = new HexCalc("45GH");
		hexaCalculator1.addHexaDecimal(hexaCalculator2);
	}

	@Test(expected = NumberFormatException.class)
	public void additionHexCalcWithBothInvalidInput() {
		hexaCalculator1 = new HexCalc("45GH!");
		hexaCalculator2 = new HexCalc("7-l'");
		hexaCalculator1.addHexaDecimal(hexaCalculator2);
	}
}
