package GET2018.SCF.SCFSession9.GraphicsLibrary;

import java.text.DecimalFormat;
import java.util.Date;

import GET2018.SCF.SCFSession9.GraphicsLibrary.Screen.ScreenException;

/**
 * This Triangle class implements Shape interface
 * 
 * @author Mohit Sharma
 *
 */
public class Triangle implements Shape {
	private Point origin;
	private Point pointA;
	private Point pointB;
	private double height;
	private double base;
	private double sideA;
	private double sideB;
	private double slopeA;
	private double slopeB;
	final Date timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Triangle(double height, double base, double sideA, Point origin,
			Date timestamp) throws ScreenException {
		this.height = height;
		this.base = base;
		this.sideA = sideA;
		this.origin = origin;
		this.timestamp = timestamp;
		try {
			computeOtherParameters();
		} catch (ScreenException e) {
			throw new ScreenException(
					"Triangle Can't be add because Sum of two Sides of Triangle must be greater than the third side");
		}
	}

	@Override
	public double getArea() {
		double perimeter = getPerimeter() / 2;
		return Double.parseDouble(decimalFormatSpecifier.format(Math
				.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB)
						* (perimeter - base))));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(sideA + sideB
				+ base));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	/**
	 * If y - m1 * x <= yO - m1 * xO and y - m2 * x <= yO - m2 * xO and y >= yO
	 * satisfies where (x,y) is the coordinate of Point, (xO,yO) is the origin,
	 * m1 is slopeA, m2 is slopeB then the Point lies inside the Triangle
	 * otherwise not
	 */
	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (isPointEnclosed.getyPoint() - slopeA * isPointEnclosed.getxPoint() <= origin
				.getyPoint() - slopeA * origin.getxPoint()
				&& isPointEnclosed.getyPoint() - slopeB
						* isPointEnclosed.getxPoint() <= pointA.getyPoint()
						- slopeB * pointA.getxPoint()
				&& isPointEnclosed.getyPoint() >= origin.getyPoint()) {
			return true;
		}
		return false;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.Triangle;
	}

	/**
	 * In a Triangle there are three sides and three coordinates We are taking
	 * sideA as the Leftmost side of Base side We are taking sideB as the
	 * Rightmost side of Base side The intersection of sideA and sideB is the
	 * PointA The intersection of sideB and Base side is the Point B
	 * 
	 * @throws ScreenException
	 */
	private void computeOtherParameters() throws ScreenException {
		double differenceOfBase = Math.sqrt(Math.pow(sideA, 2)
				- Math.pow(height, 2));
		double otherDifferenceOfBase = base - differenceOfBase;
		sideB = Math.sqrt(Math.pow(height, 2)
				+ Math.pow(otherDifferenceOfBase, 2));
		pointA = new Point(origin.getxPoint() + differenceOfBase,
				origin.getyPoint() + height);
		pointB = new Point(origin.getxPoint() + base, origin.getyPoint());
		slopeA = (pointA.getyPoint() - origin.getyPoint())
				/ (pointA.getxPoint() - origin.getxPoint());
		slopeB = (pointA.getyPoint() - pointB.getyPoint())
				/ (pointA.getxPoint() - pointB.getxPoint());
	}
}
