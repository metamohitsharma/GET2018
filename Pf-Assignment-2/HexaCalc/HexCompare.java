/**
 * This Class compares two Hexadecimal Numbers with each other
 * @author Mohit
 */
public class HexCompare {
	final private String hexaDecimal1;
	final private String hexaDecimal2;
	final private String digits = "0123456789ABCDEF";
	
	public HexCompare(String hexaDecimal1, String hexaDecimal2) {
		this.hexaDecimal1 = hexaDecimal1.replaceFirst("^0*", "");
		this.hexaDecimal2 = hexaDecimal2.replaceFirst("^0*", "");
	}
  
	/**
	 * Computes whether First No is greater than Second
	 * @return
	 */
	boolean isGreaterThan() {
		if (hexaDecimal1.length() != hexaDecimal2.length()) {
			return (hexaDecimal1.length() > hexaDecimal2.length());
		}
		for (int i = 0; i < hexaDecimal1.length(); i++) {
			if (digits.indexOf(hexaDecimal1.charAt(i)) > digits.indexOf(hexaDecimal2.charAt(i))) {
				return true;
			}
			if (digits.indexOf(hexaDecimal1.charAt(i)) < digits.indexOf(hexaDecimal2.charAt(i))) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Computes whether First No is less than Second
	 * @return 
	 */
	boolean isLessThan() {
		if (hexaDecimal1.length() != hexaDecimal2.length()) {
			return (hexaDecimal1.length() < hexaDecimal2.length());
		}
		for (int i = 0; i < hexaDecimal1.length(); i++) {
			if (digits.indexOf(hexaDecimal1.charAt(i)) < digits.indexOf(hexaDecimal2.charAt(i))) {
				return true;
			}
			if (digits.indexOf(hexaDecimal1.charAt(i)) > digits.indexOf(hexaDecimal2.charAt(i))) {
				return false;
			}
		}
		return false;
	}
}