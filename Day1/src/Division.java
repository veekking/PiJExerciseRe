import UtilPack.Util;

/*
 * Devide two numbers and output Quotient and remainder
 * However the issue arraised when
 * 22.0divided by 2.2 is 10.0, remainder 3.552713678800501E-15
 */

public class Division{
	public static void main(String[] args){
		double[] input =  Util.ReadDouble(2);	
		double div =0, rem = input[0], quot = input[1];
		while (rem>=quot) {
			rem = rem-quot;
			div++;
		}
		System.out.println(input[0] + "divided by " + input[1] + " is " + div + ", remainder " + rem);
	
	}


}