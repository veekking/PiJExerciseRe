/*
 * Convert between Decimal and Hex
 */

import java.util.Scanner;
import java.lang.String;
import java.lang.Math;
import java.lang.Character;

public class BinaryHex {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		System.out.println("Please type a decimal or hex");
		String st = myScan.nextLine();
		
		if (st.substring(0,2).equals("0x")) {
			if (isHex(st)) {System.out.println("The decimals is: " + HexToDecimal(st));
			} else {
				System.out.println("Invalid Hex input");
			}
		} else {
			if (isDecimal(st)) {
				System.out.println("The Hex is: " + DecimalToHex(st));
			} else {
				System.out.println ("Invalid Input");
			}
		}		
	}
	
	/*
	 * Check a string follows hexadecimal format
	 * every single digit is either a number \d or between A-F or a-f
	 */
	private static boolean isHex(String s) {
		if (s.substring(2,s.length()).matches("[\\dA-Fa-f]+")) return true; //d 
		return false;
	}
	
	private static int HexToDecimal(String st){
		int result = 0;
		st = st.substring(2,st.length());
		for (int i=0; i<st.length(); i++) {
			result += HexDigit(st.charAt(i))*Math.pow(16, st.length()-1-i);
		}
		return result;
	}
	
	/*
	 * Convert0-f to 0-15
	 */
	private static int HexDigit(char c) {
		if (Character.isDigit(c)) return Character.getNumericValue(c);
		switch (c) {
		case 'a': return 10;
		case 'b': return 11;
		case 'c': return 12;
		case 'd': return 13;
		case 'e': return 14;
		case 'f': return 15;
		default: return 0;
		}	
	}
	
	/*
	 * Check if a string contains all the numerical values
	 */
	private static boolean isDecimal (String st) {
		if (st.matches("[\\d]+")) return true;
		return false;
	}
	
	/*
	 * Convert a decimal string to hexadecimal string
	 */
	private static String DecimalToHex(String st) {
		// Convert string to numerical value first;
		int num = 0;
		for (int i = 0; i<st.length(); i++) {
			num = num*10 + HexDigit(st.charAt(i));
		}
		
		int devider = num;
		String result = new String();
		
		// Convert from numerical to haxadecimal 
		while (devider > 0) {
			result = String.valueOf(ToHex(devider%16)) + result;
			devider = (int)Math.floor(devider/16);
		}
		return result;
	} 
	
	/*
	 * Convert from 0-15 to 0-f
	 */
	private static char ToHex(int n) {
		if (n>= 0 && n<=9) return (char)(n+48); //ASCI conversion ASCI 48 == numerical 0
		switch(n) {
		case 10: return 'a';
		case 11: return 'b';
		case 12: return 'c';
		case 13: return 'd';
		case 14: return 'e';
		case 15: return 'f';
		default: return '.';
		}
	}


}
