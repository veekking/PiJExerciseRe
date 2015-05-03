/*
 * Read a text string and return a value double in half value
 * Only reads the first identified number
 * e.g. lkj3.344,3.23    The input number is 3.344
 * e.g. 3,4,,.23.3,2     The input number is 34.230000000000004
 * e.g. sde234.23 34     The input number is 234.23
 */

import java.util.Scanner;
import java.lang.Character;
import java.lang.String; 
import java.lang.Math;

public class Text2Number {
public static void main(String[] args) {
	System.out.println("Please type a number or a text contains number");
	Scanner myScan = new Scanner(System.in);
	String str = myScan.nextLine();
	
	boolean numFlag = false;
	int decimCount = 0;
	
	int i = 0;
	double num = 0;
	int power = 1;
	
	while(i < str.length()) {
		char c = str.charAt(i++);
		if (Character.isDigit(c)) {
			numFlag = true;
			
			// if in integer place, do x10
			// if in decimal place, do /10
			if (decimCount == 1) {
				num = num + (double) Character.getNumericValue(c)/Math.pow(10,power++);
			} else {
				if (decimCount == 0 )num = num*10 + (double) Character.getNumericValue(c);
			}
		} else {
			// comma cannot occure after dot
			if (c == ',' && numFlag == true && decimCount < 1) { 
				//Do nothing, simply skip
			} else {
				// decimal dot only valid when in the number
				if (c=='.' && numFlag == true ) { decimCount++;
				} else {
					// if already in a number, and the digit is not valid, terminate
					if (numFlag == true) break;
				}
			}
		}
	}
	System.out.println("The input number is " + num);
	System.out.println("Half of the value is " + num/2);
	}
}
