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
	 * @throws AreaCalculatorException
	 */
	double areaOfTriangle(double width, double height) throws AreaCalculatorException {
		if (width < 0 || height < 0) {
			throw new AreaCalculatorException("Negative Width or Height Not Allowed in Triangle");
		}
		return Double.parseDouble(decimalFormatSpecifier.format(0.5 * width * height));
	}

	/**
	 * Computes Area of Rectangle
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	double areaOfRectangle(double width, double height) throws AreaCalculatorException {
		if (width < 0 || height < 0) {
			throw new AreaCalculatorException("Negative Width or Height Not Allowed in Rectangle");
		}
		return Double.parseDouble(decimalFormatSpecifier.format(width * height));
	}

	/**
	 * Computes Area of Square
	 * 
	 * @param width
	 * @return
	 */
	double areaOfSquare(double width) throws AreaCalculatorException {
		if (width < 0) {
			throw new AreaCalculatorException("Negative Width Not Allowed in Square");
		}
		return Double.parseDouble(decimalFormatSpecifier.format(width * width));
	}

	/**
	 * Computes Area of Circle
	 * 
	 * @param radius
	 * @return
	 */
	double areaOfCircle(double radius) throws AreaCalculatorException {
		if (radius < 0) {
			throw new AreaCalculatorException("Negative Radius Not Allowed in Circle");
		}
		return Double.parseDouble(decimalFormatSpecifier.format(Math.PI * radius * radius));
	}

	@SuppressWarnings("serial")
	static class AreaCalculatorException extends Exception {
		String messageException;

		public AreaCalculatorException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
