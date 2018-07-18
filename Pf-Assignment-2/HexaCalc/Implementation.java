import java.util.Scanner;

/**
 * This class implements main method that provides Arithmetic Functions
 * on Hexadecimal Numbers
 * @author Mohit
 */
public class Implementation {
	public static void main(String args[]) {
		HexCalc hexaCalc1;
		HexCalc hexaCalc2;
		while (true) {
			System.out.println("Enter the operation who want to perform: -");
			System.out.println("1. Add two Hecadecimal No\n2. Subtract two HexaDecimal No\n3. Multiply two"
					+ " HexaDecimal No\n4. Divide two HexaDecimal No\n5. Compare");
			Scanner inputChoice = new Scanner(System.in);
			String operation = inputChoice.nextLine();
			System.out.println("Enter First HexaDecimal No");
			String hexaDecimal1 = inputChoice.nextLine();
			System.out.println("Enter Second HexaDecimal No");
			String hexaDecimal2 = inputChoice.nextLine();
			hexaCalc1 = new HexCalc(hexaDecimal1);
			hexaCalc2 = new HexCalc(hexaDecimal2);
			String result;
			switch (operation) {
			case "1" :
				result = hexaCalc1.addHexaDecimal(hexaCalc2);
				if (("false").equals(result)) {
					System.out.println("Enter characters from 0-9 and A-F");
				} else {
					System.out.println("Addition :- " + result);
				}
				break;
			
			case "2":
				result = hexaCalc1.subtractHexaDecimal(hexaCalc2);
				if (("false").equals(result)) {
					System.out.println("Enter characters from 0-9 and A-F and First No should be greater than Second");
				} else {
					System.out.println("Subtraction :- " + result);
				}
				break;
				
			case "3":
				result = hexaCalc1.multiplyHexaDecimal(hexaCalc2);
				if (("false").equals(result)) {
					System.out.println("Enter characters from 0-9 and A-F");
				} else {
					System.out.println("Multiplication :- " + result);
				}
				break;
				
			case "4":
				result = hexaCalc1.divisionHexaDecimal(hexaCalc2);
				if (("false").equals(result)) {
					System.out.println("Enter characters from 0-9 and A-F also second HexaDecimal shouldnot be Zero");
				} else {
					System.out.println("Division :- " + result);
				}
				break;
				
			case "5":
				if (hexaCalc1.testHexaDecimal(hexaDecimal1) && hexaCalc2.testHexaDecimal(hexaDecimal2)) {
					HexCompare hexCompare = new HexCompare(hexaDecimal1, hexaDecimal2);
					if (hexCompare.isGreaterThan()) {
						System.out.println(hexaDecimal1 + " is greater than " + hexaDecimal2);
					} else if (hexCompare.isLessThan()) {
						System.out.println(hexaDecimal1 + " is less than " + hexaDecimal2);
					} else {
						System.out.println(hexaDecimal1 + " is equal to " + hexaDecimal2);
					} 
				} else {
					System.out.println("Enter characters from 0-9 and A-F");
				}
				break;	
				
			default:
				System.out.println("Wrong Input");
			}
		}
	}
}
