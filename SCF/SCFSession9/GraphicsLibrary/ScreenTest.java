package GET2018.SCF.SCFSession9.GraphicsLibrary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import GET2018.SCF.SCFSession9.GraphicsLibrary.Screen.ScreenException;

/**
 * This class performs various test cases on Screen Class
 * 
 * @author Mohit Sharma
 *
 */
public class ScreenTest {
	Screen screen;

	@Before
	public void init() throws ScreenException {
		screen = new Screen();
	}

	@Test
	public void testAddShape() throws ScreenException {
		// Adding a new Shape to shapeList
		screen.addShape(ShapeType.Circle, new Point(20, 35), new ArrayList<>(
				Arrays.asList(25d)));
	}

	@Test
	public void testDeleteShape() throws ScreenException {
		// Deleting Shape from shapeList
		assertTrue(screen.deleteShape(ShapeType.Square, new Point(300, 100)));
	}

	@Test
	public void testAllDeleteShape() throws ScreenException {
		// Delete shapes of Specific type for ex: Circle
		screen.deleteShapesOfSpecificType(ShapeType.Circle);
	}

	@Test
	public void testAscendingInArea() throws ScreenException {
		// Sorting Shapes on the basis of Area
		List<Shape> sortedShape = new ArrayList<Shape>();
		sortedShape.add(Screen.shapesList.get(1));
		sortedShape.add(Screen.shapesList.get(0));
		sortedShape.add(Screen.shapesList.get(3));
		sortedShape.add(Screen.shapesList.get(2));
		assertEquals(sortedShape, screen.ascendingInArea());
	}

	@Test
	public void testAscendingInPerimeter() throws ScreenException {
		// Sorting Shapes on the basis of Perimeter
		List<Shape> sortedShape = new ArrayList<Shape>();
		sortedShape.add(Screen.shapesList.get(1));
		sortedShape.add(Screen.shapesList.get(0));
		sortedShape.add(Screen.shapesList.get(2));
		sortedShape.add(Screen.shapesList.get(3));
		assertEquals(sortedShape, screen.ascendingInPerimeter());
	}

	@Test
	public void testAscendingInTimestamp() throws ScreenException {
		// Sorting Shapes on the basis of Timestamp
		List<Shape> sortedShape = new ArrayList<Shape>();
		sortedShape.add(Screen.shapesList.get(0));
		sortedShape.add(Screen.shapesList.get(1));
		sortedShape.add(Screen.shapesList.get(2));
		sortedShape.add(Screen.shapesList.get(3));
		assertEquals(sortedShape, screen.ascendingInTimestamp());
	}

	@Test
	public void testAscendingInOriginDistance() throws ScreenException {
		// Sorting Shapes on the basis of Origin Distance to (0,0)
		List<Shape> sortedShape = new ArrayList<Shape>();
		sortedShape.add(Screen.shapesList.get(1));
		sortedShape.add(Screen.shapesList.get(3));
		sortedShape.add(Screen.shapesList.get(0));
		sortedShape.add(Screen.shapesList.get(2));
		assertEquals(sortedShape, screen.ascendingInOriginDistance());
	}

	@Test
	public void testIsPointEnclosed() throws ScreenException {
		// Providing List of Shapes that all Enclose the Given Point
		List<Shape> sortedShape = new ArrayList<Shape>();
		sortedShape.add(Screen.shapesList.get(2));
		assertEquals(sortedShape, screen.isPointEnclosed(new Point(300, 200)));
	}

	@Test
	public void testIsPointEnclosedWithNull() {
		// Providing Point as Null
		try {
			screen.isPointEnclosed(null);
		} catch (NullPointerException ex) {
			assertEquals("Point can't be Null in isPointEnclosed",
					ex.getMessage());
		}
	}

	@Test
	public void testDeleteSpecifiedShapeTypeWithNull() {
		// Providing ShapeType as Null
		try {
			screen.deleteShapesOfSpecificType(null);
		} catch (NullPointerException ex) {
			assertEquals(
					"ShapeType can't be Null in deleteShapesOfSpecificType",
					ex.getMessage());
		}
	}

	@Test
	public void testDeleteShapeWithNull() throws ScreenException {
		// Providing Inputs in Delete Shape as Null
		try {
			screen.deleteShape(null, null);
		} catch (NullPointerException ex) {
			assertEquals("Arguments in deleteShape can't be Null",
					ex.getMessage());
		}
	}

	@Test
	public void testAddSquareOutOfBounds() throws ScreenException {
		// Providing a Square Points Out of Screen
		try {
			screen.addShape(ShapeType.Square, new Point(1000, 1000),
					new ArrayList<Double>(Arrays.asList(250d)));
		} catch (ScreenException e) {
			assertEquals("Width is out of Screen in Square",
					e.getMessageException());
		}
	}

	@Test
	public void testAddCircleOutOfBounds() throws ScreenException {
		// Providing a Circle Points Out of Screen
		try {
			screen.addShape(ShapeType.Circle, new Point(1000, 1000),
					new ArrayList<Double>(Arrays.asList(250d)));
		} catch (ScreenException e) {
			assertEquals("Circle is out of Screen", e.getMessageException());
		}
	}

	@Test
	public void testAddTriangleOutOfBounds() throws ScreenException {
		// Providing a Triangle Points Out of Screen
		try {
			screen.addShape(ShapeType.Triangle, new Point(1000, 1000),
					new ArrayList<Double>(Arrays.asList(250d, 25d, 100d)));
		} catch (ScreenException e) {
			assertEquals(
					"Triangle Can't be add because Sum of two Sides of Triangle must be greater than the third side",
					e.getMessageException());
		}
	}

	@Test
	public void testAddRectangleOutOfBounds() throws ScreenException {
		// Providing a Triangle Points Out of Screen
		try {
			screen.addShape(ShapeType.Rectangle, new Point(1000, 1000),
					new ArrayList<Double>(Arrays.asList(250d, 25d)));
		} catch (ScreenException e) {
			assertEquals("Width or Height is out of Screen in Rectangle",
					e.getMessageException());
		}
	}
}
