import Utility.Point;

public class PointMore {
	public static void main(String[] args) {
	
	Point px = new Point(100,200);
	Point py= new Point(50,200);
	
	System.out.println("The clone of p1 is" + px.getX() + "and " + px.getY());
	System.out.println("The distance to 4,6 is" + px.distanceTo(px));
	//System.out.println("The distance to origin is " + p1.distanceToOrigin());
	//p1.moveTo(p2);
	//System.out.println("After the move distance is " + p1.distanceTo(p2));
	
	//Point p3 = p1.clone();
	//System.out.println("The clone of p1 is" + p3.getX() + "and " + p3.getY());
	}	
}
