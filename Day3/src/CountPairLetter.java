/*
 * Read a short string and long string
 * Count how many times the short string occurs
 */
import java.util.Scanner;
import java.lang.String;

public class CountPairLetter {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.println("Please type a short string");
        String str = new String(myScan.nextLine());
        
        System.out.println("Please type a long text");
        String txt = new String(myScan.nextLine());
        
        int count = 0;
        if (str.length() > txt.length()) {
           count = 0;
        } else {
            for (int i = 0; i< txt.length() - str.length() ; i++) {
                if (str.charAt(0) == txt.charAt(i)) {
                    boolean cmp = true;
                    for (int j=0; j<str.length(); j++) {
                        if (str.charAt(j) != txt.charAt(i+j)) cmp = false;
                    }
                    count += (cmp? 1 :0);
                    
                }
                    
            }
        }
        
        System.out.println("The number of occurance of " + str +" in \n" + txt + "\n is " + count);
    }
}