
import java.lang.String;
import java.lang.Integer;
import java.util.Scanner;

public class dataType {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		System.out.println("Please type two integers: ");
		
		String input = new String(myScan.nextLine());
		System.out.println("Output is: "+ input );
		
		int n1 =  Integer.parseInt(input);
		int n2 =  Integer.parseInt(input);
		
		System.out.println("The n1: " + n1 + "; The n2:" + n2);
	}

}
