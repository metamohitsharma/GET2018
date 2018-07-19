package AreaCalculator;

import java.util.Scanner;

/**
 * It contains main method which implements AreaCalculator class operations
 * 
 * @author Mohit Sharma
 *
 */
public class Implementation {
	public static void main(String[] args) {
		double width;
		double height;
		double radius;
		Scanner inputParameter = new Scanner(System.in);
		AreaCalculator areaCalc = new AreaCalculator();
		while (true) {
			System.out.println("Enter operation you want to perform:- ");
			System.out.println("1.Area of Triangle\n2.Area of Rectangle\n3.Area of Square"
							+ "\n4.Area of Circle\n5.Exit");
			switch (inputParameter.nextInt()) {
			case 1:
				System.out.println("Enter Width of Triangle:-");
				width = inputParameter.nextDouble();
				System.out.println("Enter Height of Triangle:");
				height = inputParameter.nextDouble();
				System.out.println("Area of Triangle = "
						+ areaCalc.areaOfTriangle(width, height));
				break;

			case 2:
				System.out.println("Enter Width of Rectangle:-");
				width = inputParameter.nextDouble();
				System.out.println("Enter Height of Rectangle:-");
				height = inputParameter.nextDouble();
				System.out.println("Area of Rectangle = "
						+ areaCalc.areaOfRectangle(width, height));
				break;

			case 3:
				System.out.println("Enter Width of Square:-");
				width = inputParameter.nextDouble();
				System.out.println("Area of Square = "
						+ areaCalc.areaOfSquare(width));
				break;

			case 4:
				System.out.println("Enter Radius of Circle :-");
				radius = inputParameter.nextDouble();
				System.out.println("Area of Circle = "
						+ areaCalc.areaOfCircle(radius));
				break;

			case 5:
				System.exit(1);

			default:
				System.out.println("Wrong Input");
			}
		}
	}
}
