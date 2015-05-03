/*
 * Take text input, convert to letters and words on seperate lines
 */

import java.util.Scanner;
import java.lang.String;
import java.util.StringTokenizer;

public class CountLetter {

    public static void main(String[] args) {
        System.out.println("Please type some text: ");
        Scanner myScan = new Scanner(System.in);
        String str = new String(myScan.nextLine());
        System.out.println("The char output is:");
        for (int i = 0; i<str.length(); i++) {
            System.out.print(str.charAt(i) + "\n");
        }
        
        System.out.println("The words are");
        StringTokenizer st = new StringTokenizer(str, " ");  //StringTokenizer
        while (st.hasMoreTokens())							// StringTokenizer.hasMoreTokens()	
            System.out.println(st.nextToken());				// StringTokenizer.nextToken(); or nextElement()
        
    }
}
