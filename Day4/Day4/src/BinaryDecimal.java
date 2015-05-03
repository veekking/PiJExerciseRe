import java.util.Scanner;
import java.lang.String;
import java.lang.Math;
import java.lang.Character;
import java.util.InputMismatchException;

public class BinaryDecimal {
    public static void main(String[] args){
        System.out.println("Please choose a method: ");
        System.out.println("1. Binary -> Decimal");
        System.out.println("2. Decimal -> Binary");
        
        Scanner myScan = new Scanner(System.in);
        try {
            int method = myScan.nextInt();
            if (method == 1) {
                System.out.println("Please type a decimal number");
                System.out.println("The binary number is: " + IntegerToBinary(myScan));
            } else {
                if (method == 2) {
                    System.out.println("Please type a binary number");
                    System.out.println("The decimal is: " + BinaryToDecimal(myScan));
                } else {
                    System.out.println("Invalid choice.");
                }
            }
            
        }
        catch (InputMismatchException exception) {
            System.out.println("Invalid choice.");
        }
        
    }
    
    private static String IntegerToBinary(Scanner scan) {
        try{
            int n = scan.nextInt();
            //StringBuilder sb = new StringBuilder();
            int devider = n;
            int remainder = 0;
            String result = new String();
            while (devider!=0) {
            	remainder = devider%2;
                result =  remainder + result;
                devider = (int) Math.floor(devider/2);
            }
            return result;
            
        }
        catch (InputMismatchException exception) {
            System.out.println("Invalid decimal, try again: ");
            return IntegerToBinary(scan);
        }
    }
    
    
    private static int BinaryToDecimal(Scanner scan) {
    	
        String bi = scan.next();  //Why in this occasion to use next() not nextLine()
        int result = 0;
        if (validateBinary(bi)){
            for (int i=0; i<bi.length(); i++) {
                result += Character.getNumericValue(bi.charAt(i))*((int) Math.pow(2, bi.length()-i-1));
            }
            return result;
                
            } else {
               System.out.println("Invalid binary number, try again:");
               return BinaryToDecimal(scan);
            }
 
        }

    private static boolean validateBinary(String st ) {
        for (int i = 0; i<st.length(); i++){
            if (st.charAt(i) != '0' && st.charAt(i) != '1') return false;
        }
        return true;
    }

}