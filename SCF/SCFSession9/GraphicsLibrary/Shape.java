package GET2018.SCF.SCFSession9.GraphicsLibrary;

import java.util.Date;

import GET2018.SCF.SCFSession9.GraphicsLibrary.Screen.ScreenException;

/**
 * This interface is made for Shapes Properties
 * 
 * @author Mohit Sharma
 *
 */
public interface Shape {

	double getArea();

	double getPerimeter();

	Point getOrigin() throws ScreenException;

	boolean isPointEnclosed(Point isPointEnclosed);

	Date getTimestamp();

	ShapeType getShapeType();
}

enum ShapeType {
	Square, Rectangle, Circle, Triangle;
}