package GET2018.PF.PFAssignment2.HexCalc;

/**
 * This class implements various methods on Hexadecimal No
 * 
 * @author Mohit Sharma
 */
public class HexCalc {
	String hexaDecimal;

	public HexCalc(String hexaDecimal) {
		if (hexaDecimal.equals(null)) {
			throw new NullPointerException("HexaDecimal No is Null");
		}
		this.hexaDecimal = hexaDecimal;
	}

	/**
	 * Computes Addition of two Hexadecimal No
	 * 
	 * @param hexaCalc
	 * @return addition of Hexadecimal Numbers
	 */
	String addHexaDecimal(HexCalc hexaCalc) {
		if (hexaCalc.equals(null)) {
			throw new NullPointerException("HexaDecimal No is Null");
		}
		int addResult = hexa2Decimal(hexaDecimal)
				+ hexa2Decimal(hexaCalc.hexaDecimal);
		return decimal2Hexa(addResult).toUpperCase();
	}

	/**
	 * Computes Subtraction of two Hexadecimal No
	 * 
	 * @param hexaCalc
	 * @return subtraction of Hexadecimal Numbers
	 */
	String subtractHexaDecimal(HexCalc hexaCalc) {
		if (hexaCalc.equals(null)) {
			throw new NullPointerException("HexaDecimal No is Null");
		}
		if (hexa2Decimal(hexaDecimal) > hexa2Decimal(hexaCalc.hexaDecimal)) {
			int subtractResult = hexa2Decimal(hexaDecimal)
					- hexa2Decimal(hexaCalc.hexaDecimal);
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
		if (hexaCalc.equals(null)) {
			throw new NullPointerException("HexaDecimal No is Null");
		}
		int multiplyResult = hexa2Decimal(hexaDecimal)
				* hexa2Decimal(hexaCalc.hexaDecimal);
		return decimal2Hexa(multiplyResult).toUpperCase();
	}

	/**
	 * Computes Division of two Hexadecimal No
	 * 
	 * @param hexaCalc
	 * @return division of Hexadecimal Numbers
	 */
	String divisionHexaDecimal(HexCalc hexaCalc) {
		if (hexaCalc.equals(null)) {
			throw new NullPointerException("HexaDecimal No is Null");
		}
		if (hexa2Decimal(hexaCalc.hexaDecimal) == 0) {
			throw new ArithmeticException("/ by Zero is not Allowed");
		}
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
		try {
			return Integer.parseInt(hexaDecimal, 16);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("HexaDecimal No Invalid");
		}
	}

	/**
	 * Computes Decimal to Hexadecimal
	 * 
	 * @param decimal
	 * @return Hexadecimal equivalent of Decimal No
	 */
	String decimal2Hexa(int decimal) {
		try {
			return Integer.toHexString(decimal);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("HexaDecimal No Invalid");
		}
	}

	/**
	 * Computes whether First No is greater than Second
	 * 
	 * @return
	 */
	boolean isGreaterThan(HexCalc hexaDecimal2) {
		if (hexaDecimal2.equals(null)) {
			throw new NullPointerException("HexaDecimal No is Null");
		}
		String digits = "0123456789ABCDEF";
		hexaDecimal = hexaDecimal.replaceFirst("^0*", "");
		hexaDecimal2.hexaDecimal = hexaDecimal2.hexaDecimal.replaceFirst("^0*",
				"");
		if (hexaDecimal.length() != hexaDecimal2.hexaDecimal.length()) {
			return (hexaDecimal.length() > hexaDecimal2.hexaDecimal.length());
		}
		for (int i = 0; i < hexaDecimal.length(); i++) {
			if (digits.indexOf(hexaDecimal.charAt(i)) > digits
					.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
				return true;
			}
			if (digits.indexOf(hexaDecimal.charAt(i)) < digits
					.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
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
		if (hexaDecimal2.equals(null)) {
			throw new NullPointerException("HexaDecimal No is Null");
		}
		String digits = "0123456789ABCDEF";
		hexaDecimal = hexaDecimal.replaceFirst("^0*", "");
		hexaDecimal2.hexaDecimal = hexaDecimal2.hexaDecimal.replaceFirst("^0*",
				"");
		if (hexaDecimal.length() != hexaDecimal2.hexaDecimal.length()) {
			return false;
		}
		for (int i = 0; i < hexaDecimal.length(); i++) {
			if (digits.indexOf(hexaDecimal.charAt(i)) != digits
					.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
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
		if (hexaDecimal2.equals(null)) {
			throw new NullPointerException("HexaDecimal No is Null");
		}
		String digits = "0123456789ABCDEF";
		hexaDecimal = hexaDecimal.replaceFirst("^0*", "");
		hexaDecimal2.hexaDecimal = hexaDecimal2.hexaDecimal.replaceFirst("^0*",
				"");
		if (hexaDecimal.length() != hexaDecimal2.hexaDecimal.length()) {
			return (hexaDecimal.length() < hexaDecimal2.hexaDecimal.length());
		}
		for (int i = 0; i < hexaDecimal.length(); i++) {
			if (digits.indexOf(hexaDecimal.charAt(i)) < digits
					.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
				return true;
			}
			if (digits.indexOf(hexaDecimal.charAt(i)) > digits
					.indexOf(hexaDecimal2.hexaDecimal.charAt(i))) {
				return false;
			}
		}
		return false;
	}
}
