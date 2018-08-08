package GET2018.SCF.SCFSession9.GraphicsLibrary;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * This Rectangle class implements Shape interface
 * 
 * @author Mohit Sharma
 *
 */
public class Rectangle implements Shape {

	final double width;
	final double height;
	final Point origin;
	final Date timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Rectangle(double width, double height, Point origin, Date timestamp) throws ScreenException {
		this.width = width;
		this.height = height;
		this.origin = origin;
		this.timestamp = timestamp;
		if ((origin.getxPoint() + width) > 1920 || (origin.getyPoint() + height) > 1080) {
			throw new ScreenException("Width or Height is out of Screen in Rectangle");
		}
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * height));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(2 * (width + height)));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {

		/*
		 * If originX <= pointX <= originX+width and originY <= pointY <=originY+height
		 * then the given point is enclosed by Rectangle
		 */
		if (origin.getxPoint() <= isPointEnclosed.getxPoint()
				&& isPointEnclosed.getxPoint() <= origin.getxPoint() + width) {
			if (origin.getyPoint() <= isPointEnclosed.getyPoint()
					&& isPointEnclosed.getyPoint() <= origin.getyPoint() + height) {
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
		return ShapeType.Rectangle;
	}

}
