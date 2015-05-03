/*
 * Evaluate the regular expression from user input
 * Try 4 operations by sequence: +; -; *; /
 * If non of the operations valid, return the catch error
 */

import java.util.StringTokenizer;
import java.lang.Double;
import java.lang.String;
import java.util.Scanner;

public class Calculate {
	public static void main(String[] args) {
		System.out.println("Please type an expression");
		Scanner myScan = new Scanner(System.in);
		String s = new String(myScan.nextLine());
		String[] op = new String[] {"+", "-", "*","/"};
		int count = 0;
		double n1 = 0;
		double n2 = 0;
		double result = 0.0;
		
		// catch the error if all 4 operations have been tried
		try {
			while (count < 4){
				
				// When an error occured, go to next operator as deliminitor 
				try {
				String o =  op[count];
				StringTokenizer st = new StringTokenizer(s, o);
				
				n1 = Double.parseDouble(st.nextToken()); 
				n2 = Double.parseDouble(st.nextToken());
					 
					 if (o == "+") result = n1+ n2;
					 if (o == "-") result = n1- n2;
					 if (o == "*") result = n1*n2;
					 if (o == "/") result = n1/n2;
					 System.out.println("The evaluation of " + n1 + o + n2 + " is " + result);
					 break;
				
				} catch (NumberFormatException exception) {
					count++;
				};
			}
				
		} catch (NumberFormatException exception) {
			System.out.println("Expression not recognised");

		};
		
	}

}
