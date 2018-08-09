package GET2018.SCF.SCFSession9.GraphicsLibrary;

import GET2018.SCF.SCFSession9.GraphicsLibrary.Screen.ScreenException;

/**
 * This class represent the location of PointX and PointY on a screen size of
 * 1920x1080
 * 
 * @author Mohit Sharma
 *
 */
public class Point {
	private final double xPoint;
	private final double yPoint;

	public Point(double xPoint, double yPoint) throws ScreenException {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		if (!checkLocation()) {
			throw new ScreenException("Point out of Screen Size");
		}
	}

	boolean checkLocation() {
		if (xPoint >= 0 && xPoint <= 1920 && yPoint >= 0 && yPoint <= 1080) {
			return true;
		}
		return false;
	}

	public double getxPoint() {
		return xPoint;
	}

	public double getyPoint() {
		return yPoint;
	}
}
