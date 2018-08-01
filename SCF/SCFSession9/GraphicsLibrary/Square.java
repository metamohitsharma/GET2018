package GET2018.SCF.SCFSession9.GraphicsLibrary;

import java.text.DecimalFormat;
import java.util.Date;
import GET2018.SCF.SCFSession9.GraphicsLibrary.Screen.ScreenException;

/**
 * This Square class implements Shape interface
 * 
 * @author Mohit Sharma
 *
 */
public class Square implements Shape {

	final double width;
	final Point origin;
	final Date timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Square(double width, Point origin, Date timestamp) throws ScreenException {
		this.width = width;
		this.origin = origin;
		this.timestamp = timestamp;
		if ((origin.getxPoint() + width) > 1920
				|| (origin.getyPoint() + width) > 1080) {
			throw new ScreenException("Width is out of Screen in Square");
		}
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * width));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(4 * width));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {

		/*
		 * If originX <= pointX <= originX+width and originY <= pointY
		 * <=originY+width then the given point is enclosed by Rectangle
		 */
		if (origin.getxPoint() <= isPointEnclosed.getxPoint()
				&& isPointEnclosed.getxPoint() <= origin.getxPoint() + width) {
			if (origin.getyPoint() <= isPointEnclosed.getyPoint()
					&& isPointEnclosed.getyPoint() <= origin.getyPoint()
							+ width) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.Square;
	}
}
