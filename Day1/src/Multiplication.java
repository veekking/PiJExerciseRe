import java.util.Scanner;

import UtilPack.Util;

public class Multiplication {
	public static void main(String[] args) {

		double[] input = Util.ReadDouble(2); //ReachDouble is a static method, doesn't need to initialte object
		double mul;
		
		mul = input[0] * input[1];
		System.out.println("The multiplication of " + input[0] + "and " + input[1] + "is" + mul);
	}
	
	
	}

