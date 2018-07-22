package GET2018.PF.PFAssignment2.HexCalc;

/**
 * This class implements various methods on Hexadecimal No
 * 
 * @author Mohit Sharma
 */
public class HexCalc {
	String hexaDecimal;

	public HexCalc(String hexaDecimal) {
		this.hexaDecimal = hexaDecimal;
	}

	/**
	 * Computes Addition of two Hexadecimal No
	 * 
	 * @param hexaCalc
	 * @return addition of Hexadecimal Numbers
	 */
	String addHexaDecimal(HexCalc hexaCalc) {
		int addResult = hexa2Decimal(hexaDecimal) + hexa2Decimal(hexaCalc.hexaDecimal);
		return decimal2Hexa(addResult).toUpperCase();
	}

	/**
	 * Computes Subtraction of two Hexadecimal No
	 * 
	 * @param hexaCalc
	 * @return subtraction of Hexadecimal Numbers
	 */
	String subtractHexaDecimal(HexCalc hexaCalc) {
		if (hexa2Decimal(hexaDecimal) > hexa2Decimal(hexaCalc.hexaDecimal)) {
			int subtractResult = hexa2Decimal(hexaDecimal) - hexa2Decimal(hexaCalc.hexaDecimal);
			return decimal2Hexa(subtractResult).toUpperCase();
		}
		return "false";
	}

	/**
	 * Computes Multiplication of two Hexadecimal No
	 * 
	 * @param hexaCalc
	 * @return multiplication of Hexadecimal Numbers
	 */
	String multiplyHexaDecimal(HexCalc hexaCalc) {
		int multiplyResult = hexa2Decimal(hexaDecimal) * hexa2Decimal(hexaCalc.hexaDecimal);
		return decimal2Hexa(multiplyResult).toUpperCase();
	}

	/**
	 * Computes Division of two Hexadecimal No
	 * 
	 * @param hexaCalc
	 * @return division of Hexadecimal Numbers
	 */
	String divisionHexaDecimal(HexCalc hexaCalc) {
		int secondNo = hexa2Decimal(hexaCalc.hexaDecimal);
		int divisionResult = hexa2Decimal(hexaDecimal) / secondNo;
		return decimal2Hexa(divisionResult).toUpperCase();
	}

	/**
	 * Computes Hexadecimal to Decimal
	 * 
	 * @param hexaDecimal
	 * @return Decimal equivalent of Hexadecimal No
	 */
	int hexa2Decimal(String hexaDecimal) {
		return Integer.parseInt(hexaDecimal, 16);
	}

	/**
	 * Computes Decimal to Hexadecimal
	 * 
	 * @param decimal
	 * @return Hexadecimal equivalent of Decimal No
	 */
	String decimal2Hexa(int decimal) {
		return Integer.toHexString(decimal);
	}

	/**
	 * Computes whether First No is greater than Second
	 * 
	 * @return
	 */
	boolean isGreaterThan(HexCalc hexaDecimal2) {
		String digits = "0123456789ABCDEF";
		hexaDecimal = hexaDecimal.replaceFirst("^0*", "");
		hexaDecimal2.hexaDecimal = hexaDecimal2.hexaDecimal.replaceFirst("^0*", "");
		if (hexaDecimal.length() != hexaDecimal2.hexaDecimal.length()) {
			return (hexaDecimal.length() > hexaDecimal2.hexaDecimal.length());
		}
		for (int i = 0; i < hexaDecimal.length(); i++) {
			if (digits.indexOf(hexaDecimal.charAt(i)) > digits.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
				return true;
			}
			if (digits.indexOf(hexaDecimal.charAt(i)) < digits.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Computes whether First No is equal to Second
	 * 
	 * @return
	 */
	boolean isEqualTo(HexCalc hexaDecimal2) {
		String digits = "0123456789ABCDEF";
		hexaDecimal = hexaDecimal.replaceFirst("^0*", "");
		hexaDecimal2.hexaDecimal = hexaDecimal2.hexaDecimal.replaceFirst("^0*", "");
		if (hexaDecimal.length() != hexaDecimal2.hexaDecimal.length()) {
			return false;
		}
		for (int i = 0; i < hexaDecimal.length(); i++) {
			if (digits.indexOf(hexaDecimal.charAt(i)) != digits.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Computes whether First No is less than Second
	 * 
	 * @return
	 */
	boolean isLessThan(HexCalc hexaDecimal2) {
		String digits = "0123456789ABCDEF";
		hexaDecimal = hexaDecimal.replaceFirst("^0*", "");
		hexaDecimal2.hexaDecimal = hexaDecimal2.hexaDecimal.replaceFirst("^0*", "");
		if (hexaDecimal.length() != hexaDecimal2.hexaDecimal.length()) {
			return (hexaDecimal.length() < hexaDecimal2.hexaDecimal.length());
		}
		for (int i = 0; i < hexaDecimal.length(); i++) {
			if (digits.indexOf(hexaDecimal.charAt(i)) < digits.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
				return true;
			}
			if (digits.indexOf(hexaDecimal.charAt(i)) > digits.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
				return false;
			}
		}
		return false;
	}
}
