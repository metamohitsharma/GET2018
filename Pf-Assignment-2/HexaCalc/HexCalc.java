/**
 * This class implements various methods on Hexadecimal No
 * @author Mohit
 */
public class HexCalc {
	String	hexaDecimal;
	
	public HexCalc(String hexaDecimal) {
		this.hexaDecimal = hexaDecimal;
	}
	
	/**
	 * Computes Addition of two Hexadecimal No
	 * @param hexaCalc
	 * @return addition of Hexadecimal Numbers
	 */
	String addHexaDecimal(HexCalc hexaCalc) {
		if (testHexaDecimal(hexaDecimal) && testHexaDecimal(hexaCalc.hexaDecimal)) {
			int addResult = hexa2Decimal(hexaDecimal) + hexa2Decimal(hexaCalc.hexaDecimal);
			return decimal2Hexa(addResult).toUpperCase();
		} else {
			return "false";
		}
	}
	
	/**
	 * Computes Subtraction of two Hexadecimal No
	 * @param hexaCalc
	 * @return subtraction of Hexadecimal Numbers
	 */
	String subtractHexaDecimal(HexCalc hexaCalc) {
		if (testHexaDecimal(hexaDecimal) && testHexaDecimal(hexaCalc.hexaDecimal)) {
			if (hexa2Decimal(hexaDecimal) > hexa2Decimal(hexaCalc.hexaDecimal)) {
				int subtractResult = hexa2Decimal(hexaDecimal) - hexa2Decimal(hexaCalc.hexaDecimal);
				return decimal2Hexa(subtractResult).toUpperCase();
			}
		} 
		return "false";
	}
	
	/**
	 * Computes Multiplication of two Hexadecimal No
	 * @param hexaCalc
	 * @return multiplication of Hexadecimal Numbers
	 */
	String multiplyHexaDecimal(HexCalc hexaCalc) {
		if (testHexaDecimal(hexaDecimal) && testHexaDecimal(hexaCalc.hexaDecimal)) {
			int multiplyResult = hexa2Decimal(hexaDecimal) * hexa2Decimal(hexaCalc.hexaDecimal);
			return decimal2Hexa(multiplyResult).toUpperCase();
		} else {
			return "false";
		}
	}
	
	/**
	 * Computes Division of two Hexadecimal No
	 * @param hexaCalc
	 * @return division of Hexadecimal Numbers
	 */
	String divisionHexaDecimal(HexCalc hexaCalc) {
		if (testHexaDecimal(hexaDecimal) && testHexaDecimal(hexaCalc.hexaDecimal)) {
			int secondNo = hexa2Decimal(hexaCalc.hexaDecimal);
			if (secondNo > 0) {
				int divisionResult = hexa2Decimal(hexaDecimal) / secondNo;
				return decimal2Hexa(divisionResult).toUpperCase();
			}
		}
		return "false";
	}
	
	/**
	 * Checks whether the Input is Hexadecimal No or not
	 * @param hexaDecimalNo
	 * @return true if input is HexaDecimal No
	 */
	boolean testHexaDecimal(String hexaDecimalNo) {
		boolean	check = false;
		try {
			int temp = Integer.parseInt(hexaDecimalNo, 16);
			if (temp >= 0) {
				check = true;
			}
		} catch (NumberFormatException e) {
		}
		return (check);
	}
	
	/**
	 * Computes Hexadecimal to Decimal
	 * @param hexaDecimal
	 * @return Decimal equivalent of Hexadecimal No
	 */
	int hexa2Decimal(String hexaDecimal) {
		return Integer.parseInt(hexaDecimal, 16);
	}
	
	/**
	 * Computes Decimal to Hexadecimal
	 * @param decimal
	 * @return Hexadecimal equivalent of Decimal No
	 */
	String decimal2Hexa(int decimal) {
		return Integer.toHexString(decimal);
	}
}
