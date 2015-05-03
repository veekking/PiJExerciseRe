/*
 * 
 */

import java.util.Scanner;
import UtilPack.Util;

public class Maximising {
	public static void main(String[] args){
		System.out.println("Please  type positive numbers, " +
				"the program will terminate when input is -1");
		Scanner myScanner = new Scanner(System.in);
		
		double input, max, last;
		boolean f = true;
		boolean asnd = true, dsnd = true;
        int count = 0;
		
		Util.ValidInputDouble(myScanner); //promp user to re-enter until a valid double input
		input = myScanner.nextDouble();
		max = input;
		last = input;
			
			do {
				if (input > 0 ) {
					
					// compare max
					if( input > max) max = input; 
					
					// check ascending or descending
					if (input <= last) f = false; 
					
					
					if ( count > 0 && (input - last == 1 ) && asnd){
						asnd = true; dsnd = false; 
					} else {
						if (count > 0 && (input - last == -1 ) && dsnd) {
							asnd = false; dsnd = true;
						} else {
							asnd = false; dsnd = false;
						}
							
					}
					System.out.println("Another one: ");
					Util.ValidInputDouble(myScanner);
					last = input;        // last input is stored only if it is positive;
					input = myScanner.nextDouble();
                    count++;
				} else {
					if (input == -1){
						break;
					} else {
						System.out.println("A positive one, please: ");
						Util.ValidInputDouble(myScanner);
						input = myScanner.nextDouble();
					}
				}

			} while (true);
			System.out.println("The maximium number is " + max);
			System.out.println("The sequence is " + (f==true? "" : "not ") + "ascending");
        System.out.println("The seequence is "+ ((asnd || dsnd) ? "" : "not ") + "consecutive" );
	}
	
}
