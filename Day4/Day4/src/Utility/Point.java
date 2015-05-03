package Utility;
import java.lang.Math;

public class Point {
	private 
	// cannot make static reference to non-static variable??
		static double x = 0;
		static double y = 0;
		
		public Point() {x=0; y=0;};
		
		public Point (double x,double y) {
			this.x = x;
			this.y = y;
		}
		
	public double getX() {return x;}
	public double getY() {return y;}
	
	public void setX(double x) {this.x = x;};
	public void setY(double y) {this.y = y;};
	
	public  double distanceTo(Point p) {
		return Math.sqrt(Math.pow(x-p.getX(),2) + Math.pow(y - p.getY(),2));
	}
	
	public double distanceToOrigin() {
		return distanceTo(new Point(0,0));
	}
	
	public void moveTo(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void moveTo(Point p) {
		this.setX(p.getX());
		this.setY(p.getY());
	}
	
	public Point clone() {
		Point np = new Point();
		np.setX(this.getX());
		np.setY(this.getY());
		return np;
	}
	
	public Point opposite() {
		Point np = new Point(-this.getX(),-this.getY());
		return np;
	}

}
