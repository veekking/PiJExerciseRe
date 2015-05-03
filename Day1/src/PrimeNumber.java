	/*
	 * Ask User's input of integer and output if it is a prime number
	 */

import java.util.Scanner;
import java.util.InputMismatchException;
import java.math.*;

public class PrimeNumber {


		public static void main(String[] args){
			
			int input;
			int i;
			String result = "not";
			Scanner myIn = new Scanner(System.in);
			System.out.println("Please type an integer:");
			
			// Make sure an input is integer
		
			while (!myIn.hasNextInt()){
				System.out.println("Please enter again an integer");
				myIn.next(); // next token
			}
			
			
			/*
			 * Why cannot 
			 * using next() in Try/Catch and nextInt() in Main moves the token forward twice
			 * while (CheckInteger(myIn) == false)	myIn.next();
			 */
			
			input = myIn.nextInt();
			
			i = 2;
			int mid = (int) Math.floor(input/2);
			while (i < mid){
				if (input%i == 0) break;
				i++;
			}
			if ((i == mid) && (input % i != 0)) result = "";
			
			System.out.println("The input integer " + input + " is " + result + " a prime");

			
		};
		
		
		public static boolean CheckInteger(Scanner Input) {
			try{
				int usrInput =Input.nextInt();
			}
			catch(InputMismatchException exception)
			{
				System.out.println("Please enter integer");
				return false;
			}
			return true;
		};
	}


