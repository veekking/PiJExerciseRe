/*
 * Calculate the distance of any 2 Points out of N points
 * The area formed by the first 2 poins
 * decide 3rd points if in or out the rectangle
 * decide the 5th point if in the two rectangles formed by the first 4 points
 */

import java.util.Scanner;
import java.lang.Math;
import java.lang.String;

public class DistancePTP {
public static void main(String[] args) {
	// 
	int numPoint = 4;
	Point[] points = new Point[numPoint];
	Scanner myScan = new Scanner(System.in);
	double dist = 0;
	
	for (int i = 0; i<numPoint; i++) {
		
		System.out.println("Please enter point:" + (i+1));
		System.out.println("The X coordinate: ");
		double x1 = doubleInput(myScan);
		System.out.println("The Y coordinate: ");
		double y1 = doubleInput(myScan);
		
		points[i] = new Point(x1, y1);
	}
	
	// Distance point-to-point

	for (int i = 0; i<numPoint; i++ ) {
		for (int j=i; j<numPoint; j++) {
			dist = Math.max(dist, getDistance(points[i], points[j]));
		}
	}
	
	System.out.println("The lastest distance among the 2 points is " + dist);
	
	// Rectangle
	Rectangle rec = new Rectangle(points[0], points[1]);
	System.out.println("The rectangle area formed by the first 2 points is " + rec.area());
	
	// In or Out
	System.out.println("The 3rd Point is" + (InOrOut(points[2], rec) ? "" : "not ") + "in the rectangle");
	
	
	// Enter the 5th points and decide of overlaps
	Rectangle rec2 = new Rectangle(points[2], points[3]);
	System.out.println("Please enter the 5th Point: X Coordinate: ");
	double x2 = doubleInput(myScan);
	System.out.println("Y Axis: ");
	double y2 = doubleInput(myScan);
	Point p5 = new Point(x2, y2);
	
	System.out.println("The 5th point is" + Overlap(p5, rec, rec2) + "Rectangles");
	
	myScan.close();
}


private static double getDistance(Point p1, Point p2) {
	return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2) + Math.pow(p1.getY() - p2.getY(),2));
}

public static class Point {
	
	Point() {x = 0; y=0;}
	Point(double xx, double yy) {x=xx; y=yy;}
	double getX() {return x;}
	double getY() {return y;}
	
	private
		double x=0;
		double y=0;

}

public static class Rectangle{
	private 
	Point upLeft ;
	Point downRight ;
	
	public
	Rectangle(Point p1, Point p2){
		// make sure two points are not on the same line
		if (p1.getX()== p2.getX() || p1.getY()== p2.getY()) {
			System.out.println("Cannot built a Ranctangle");
			System.exit(0);
		}
		upLeft = new Point(Math.min(p1.getX(), p2.getX()), Math.max(p1.getY(),p2.getY()));
		downRight = new Point(Math.max(p1.getX(), p2.getX()), Math.min(p1.getY(), p2.getY()));
	}
	
	double getL() {return downRight.getX()-upLeft.getX();} //width
	double getH() {return upLeft.getY() - downRight.getY();} //height
	Point getOrig() {return new Point(downRight.getX() - this.getL(), upLeft.getY() - this.getH());}
	double area() {return this.getL()*this.getH();};

	
}

// Decide if a point is inside a rectangle
public static boolean InOrOut(Point p, Rectangle rec) {
	if ((rec.getOrig().getX() <= p.getX() && p.getX() <= (rec.getOrig().getX()+rec.getL())) &&
			(rec.getOrig().getY() <= p.getY() && p.getY() <= (rec.getOrig().getY() + rec.getH()))) {
		return true; 
		} else {
			return false;
		}
	}

// Overlap?
public static String Overlap(Point p, Rectangle rec1, Rectangle rec2) {
	if (InOrOut(p, rec1) && InOrOut(p, rec2)) {
		return "Inside Both";
	} else {
		if (!InOrOut(p, rec1) && !InOrOut(p, rec2)) {
			return "Out of Both";
		} else {
			return "Inside One Only";
		}
	}
}

private static double doubleInput(Scanner s) {
	while (!s.hasNextDouble()) {
		System.out.print("Invalid input, try again: ");
		s.next();
	}
	return s.nextDouble();
}


}



