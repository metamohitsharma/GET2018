package AreaCalculator;

/**
 * It computes Area of Different Geometrical Shapes
 * 
 * @author Mohit Sharma
 *
 */
public class AreaCalculator {

	/**
	 * Computes Area of Triangle
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	double areaOfTriangle(double width, double height) {
		return 0.5 * width * height;
	}

	/**
	 * Computes Area of Rectangle
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	double areaOfRectangle(double width, double height) {
		return width * height;
	}

	/**
	 * Computes Area of Square
	 * 
	 * @param width
	 * @return
	 */
	double areaOfSquare(double width) {
		return width * width;
	}

	/**
	 * Computes Area of Circle
	 * 
	 * @param radius
	 * @return
	 */
	double areaOfCircle(double radius) {
		return Math.PI * radius * radius;
	}
}
