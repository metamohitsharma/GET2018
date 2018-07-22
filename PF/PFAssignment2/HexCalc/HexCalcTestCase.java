package GET2018.PF.PFAssignment2.HexCalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HexCalcTestCase {

	@Test
	void test() {
		HexCalc hexaCalculator1 = new HexCalc("4CB");
		HexCalc hexaCalculator2 = new HexCalc("21A");
		assertEquals("6E5", hexaCalculator1.addHexaDecimal(hexaCalculator2));
		assertEquals("2B1", hexaCalculator1.subtractHexaDecimal(hexaCalculator2));
		assertEquals("A129E", hexaCalculator1.multiplyHexaDecimal(hexaCalculator2));
		assertEquals("2", hexaCalculator1.divisionHexaDecimal(hexaCalculator2));
		assertEquals(true, hexaCalculator1.isGreaterThan(hexaCalculator2));
		assertEquals(false, hexaCalculator1.isLessThan(hexaCalculator2));
		assertEquals(false, hexaCalculator1.isEqualTo(hexaCalculator2));
	}
}
