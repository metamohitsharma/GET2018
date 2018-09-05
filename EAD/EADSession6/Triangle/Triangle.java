package GET2018.EAD.EADSession6;

/**
 * This class is used to calculate Area of Triangle
 * 
 * @author Mohit Sharma
 *
 */
public class Triangle {

	/**
	 * Returns Area of Triangle using Heron's Formula
	 * 
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 * @return
	 */
	public double area(double sideA, double sideB, double sideC) {
		double p = (sideA + sideB + sideC) / 2;
		double area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
		return area;
	}
}
