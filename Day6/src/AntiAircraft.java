/*
 * Use a Shot Class to hit a Target
 * If fail, give directions of left or right, untill succeed
 */

import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;
import java.lang.Math;
import java.util.Arrays;


public class AntiAircraft {
	private int x;
	private int y;
	private int z;
	
	public enum Direction {HIT, FAIL_LEFT, FAIL_RIGHT, FAIL_HIGH, FAIL_LOW, FAIL_SHORT, FAIL_LONG, OUT_OF_RANGE};
	
	public static void main(String[] args) {
		
		Target newTarget = new Target(5);
		newTarget.playGame();
		System.out.println("Would you like to play again: Y/N: ");
		Scanner myScan = new Scanner(System.in);
		while (myScan.nextLine().equals("Y")) newTarget.playGame();
		
	}
	
	public static class Target{
		private int dim;
		private int d1 = 0;
		private int d2 = 0;
		private int d3 = 0;
		private int[][][] space;
		
		/*
		 * Initialize a Target with nxnxn dimention;
		 */
		public Target(int n) {
			space = new int[n][n][n];
			dim = n;
			for (int[][] xy :space) {
				for(int[]x: xy) {
					Arrays.fill(x, 0);
				}
			}
		}
		
		
		/*
		 * Generage a target at position(d1, d2, d3)
		 */
		private void init() {
			d1 = (int) (dim*Math.random());
			d2 = (int) (dim*Math.random());
			d3 = (int) (dim*Math.random());
			space [d1][d2][d3] = 1;
			System.out.print("The tarte is in position:" + d1 + ".." + d2 +".." +d3);
			}
		
		private Shot recordShot() {
			int x, y, z;
			Scanner myScan = new Scanner(System.in);
			System.out.println("Enter x:");	
			x = validInt(myScan);
			System.out.println("Enter y:");	
			y = validInt(myScan);
			System.out.println("Enter z:");
			z = validInt(myScan);
			//myScan.close();   
			// Do not use .close() method, otherwise scanner.hasNextInt() will fail permanently; 
			// Infinite loops
			return new Shot(x, y,z);
		}
		
		/*
		 * If HIT, success, terminate the programme
		 * All other instructions returns false, will loop
		 */
		private boolean checkSuccess(Direction dr) {
			if (dr == Direction.HIT) {
				System.out.println("You hit it. Well dome!"); 
				return true;
			} else {
				System.out.println("You missed it, the target is " + dr);
				return false;
			}
		}
		
		/*
		 * Determine the shot's position relative to Target
		 */
		private Direction checkShot(Shot shotT) {
			if (shotT.x < 0 ||shotT.x > dim*1.5 
					|| shotT.y < 0 || shotT.y > dim*1.5 
					|| shotT.z<0 || shotT.z>1.5*dim) return  Direction.OUT_OF_RANGE;
			if (shotT.x > 0 && shotT.x < d1) return Direction.FAIL_RIGHT;
			if (shotT.x > d1 && shotT.x < dim) return Direction.FAIL_LEFT;
			if (shotT.y > 0 && shotT.y < d2 ) return Direction.FAIL_HIGH;
			if (shotT.y > d2 && shotT.y < dim) return Direction.FAIL_LOW;
			if (shotT.z >0 && shotT.z < d3) return Direction.FAIL_LONG;
			if (shotT.z > d3 && shotT.z < dim) return Direction.FAIL_SHORT;
			return Direction.HIT;
		}
		
		
		private int validInt(Scanner s) {
			while (!s.hasNextInt()) {
				System.out.println("Invalid input. Try again:") ;
				s.next();
			}
			return s.nextInt();
			
		}
		
		
		private class Shot {
			int x;
			int y;
			int z;
			Shot(int x, int y, int z) {
				this.x = z;
				this.y = y;
				this.z = z;
			}
		}
		
		/*
		 * Game procesures
		 * Shot -> determine direction of shot > if Hit terminate, otherwise Shot again
		 */
		public void playGame() {
			init();
			Direction dir;
			System.out.println("Here they come, try to bring the plane down");
			do {
				Shot myShot = recordShot();
				dir = checkShot(myShot);
			} while (!checkSuccess(dir)) ;
				
			}
		}
	}


