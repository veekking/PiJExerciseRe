import java.util.Scanner;
import java.lang.Math;

public class MoneyChange {
public static void main(String[] args) {
	Scanner myScan = new Scanner(System.in);
	double input = Math.ceil(myScan.nextDouble()*100)/100.0;
	double[] notes = new double[] {50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
	int[] qty = new int[notes.length];
	double rem = input;
	
	for (int i = 0; i<notes.length; i++) {
		qty[i] = (int)Math.floor(rem/notes[i]); // why cannot cast to int
		rem = rem%notes[i];
	}
	//while (Math.abs(rem - 0) < 1.0E16) {
	
	System.out.println("The notes value " + input + "Requires: ");
	for (int i=0; i<notes.length; i++) {
		System.out.println(qty[i] + "of " + notes[i] + ";");
	
	}
}
}
