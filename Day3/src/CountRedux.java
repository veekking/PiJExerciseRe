/*
 * Count the occurance of a Letter to a Sentence
 * HashSet to terminate to count if Letter repeats
 */

import java.util.Scanner;
import java.lang.String;
import java.util.HashSet;   //HashSet to contain Letters

public class CountRedux {
    public static void main(String[] args) {
    
        Scanner myScan = new Scanner(System.in);
        System.out.println("Please enter a sentence");
        String str = new String(myScan.nextLine());
        
        HashSet<String> pot = new HashSet<String>();
        
        while (true) {
            System.out.println("Which letter would you like to count? :");
            String c = myScan.next().substring(0,1);
            
            if (pot.contains(c)) {   // Define of HashSet contains the Letter
                System.out.println("Repeated character. Exiting");
                System.exit(0);
            } else {
                pot.add(c);
                System.out.println("There are " + countChar(c, str) + "in your text");
            }
        }
    };
    
    private static int countChar(String h, String str) {
        int count = 0;
        for (int i = 0; i<str.length(); i++) {
            if (str.substring(i, i+1).equals(h)) count++; //String.equals()
        }
        return count;
    }
    
    
    
}