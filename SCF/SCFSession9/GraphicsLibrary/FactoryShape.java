package GET2018.SCF.SCFSession9.GraphicsLibrary;

import java.util.Date;
import java.util.List;
import GET2018.SCF.SCFSession9.GraphicsLibrary.Screen.ScreenException;

/**
 * This class is Factory class for Shapes
 * 
 * @author Mohit Sharma
 *
 */
public class FactoryShape {
	static Shape createShape(ShapeType shapeType, Point point,
			List<Double> parameters) throws ScreenException {
		if (shapeType == null || point == null || parameters == null) {
			throw new NullPointerException(
					"Arguments in addShape can't be Null");
		}
		switch (shapeType) {
		case Circle:
			if (parameters.size() != 1) {
				throw new ScreenException("Circle Radius should be Given");
			}
			return new Circle(parameters.get(0), point, new Date());
		case Rectangle:
			if (parameters.size() != 2) {
				throw new ScreenException(
						"Rectangle Width and Height should be Given");
			}
			return new Rectangle(parameters.get(0), parameters.get(1), point,
					new Date());
		case Square:
			if (parameters.size() != 1) {
				throw new ScreenException("Square Width should be Given");
			}
			return new Square(parameters.get(0), point, new Date());
		case Triangle:
			if (parameters.size() != 3) {
				throw new ScreenException(
						"Triangle Base Height and one Side Should be Given should be Given");
			}
			return new Triangle(parameters.get(0), parameters.get(1),
					parameters.get(2), point, new Date());
		default:
			return (Shape) new ScreenException("Shape out of Bounds");
		}
	}
}
