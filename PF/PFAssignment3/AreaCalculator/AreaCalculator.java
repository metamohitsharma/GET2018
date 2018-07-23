package GET2018.PF.PFAssignment3.AreaCalculator;

import java.text.DecimalFormat;

/**
 * It computes Area of Different Geometrical Shapes
 * 
 * @author Mohit Sharma
 *
 */
public class AreaCalculator {
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	/**
	 * Computes Area of Triangle
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	double areaOfTriangle(double width, double height) {
		if (width < 0 || height < 0) {
			throw new AssertionError("Negative Width or Height Not Allowed");
		}
		double area = 0.5 * width * height;
		return Double.parseDouble(decimalFormatSpecifier.format(area));
	}

	/**
	 * Computes Area of Rectangle
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	double areaOfRectangle(double width, double height) {
		if (width < 0 || height < 0) {
			throw new AssertionError("Negative Width or Height Not Allowed");
		}
		double area = width * height;
		return Double.parseDouble(decimalFormatSpecifier.format(area));
	}

	/**
	 * Computes Area of Square
	 * 
	 * @param width
	 * @return
	 */
	double areaOfSquare(double width) {
		if (width < 0) {
			throw new AssertionError("Negative Width Not Allowed");
		}
		double area = width * width;
		return Double.parseDouble(decimalFormatSpecifier.format(area));
	}

	/**
	 * Computes Area of Circle
	 * 
	 * @param radius
	 * @return
	 */
	double areaOfCircle(double radius) {
		if (radius < 0) {
			throw new AssertionError("Negative Radius Not Allowed");
		}
		double area = Math.PI * radius * radius;
		return Double.parseDouble(decimalFormatSpecifier.format(area));
	}
}
