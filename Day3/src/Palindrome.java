/*
 * Tell whether a text is Palindrome
 * Create Palindrome following the input
 * Recursive
 */
import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;
import java.lang.Character;

public class Palindrome {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.println("Please type some text");
        String str = new String(myScan.nextLine());
        
        System.out.println("The words is " + (isPalindrom(str)? "" : "not ") + "Palindrome");
        System.out.println("The Palindrom output is" + str + createPalindrom(str));
        System.out.println("Loose Palindrome? " + (loosePalindrom(str)? "Yest" : "No"));
        
    }
    
    /*
     * Recursive function
     * Check if a string is Palindrom
     */
    private static boolean isPalindrom(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        } else {
            if (str.charAt(0) == str.charAt(str.length()-1)) return isPalindrom(str.substring(1, str.length()-1));
                return false;
        }
    }
    
    /*
     * Recursive  
     * Return a String in reverse order
     */
    
    private static String createPalindrom(String str1) {
        if (str1.length() == 0) {
            return str1;
        } else {
            return str1.substring(str1.length()-1,
                        str1.length()).concat(createPalindrom(str1.substring(0, str1.length()-1)));
        }
    }
    
    /*
     * Check is a string is loose Palindrom
     * remove non-letter characters first
     * convert array to string
     * invoke isPalindrom function
     */
    private static boolean loosePalindrom (String str) {
        char[] arrRev = new char[str.length()];
        int pos = 0;
        for (int i = 0; i<str.length(); i++)
            if (Character.isLetter(str.charAt(i))) arrRev[pos++] = Character.toLowerCase(str.charAt(i));
        char[] newArr = Arrays.copyOf(arrRev, pos); //Arrays.copyOf(arr, length)
        String strRev = String.valueOf(newArr); // To convert char[] array to string
        										// String strRev = new String(newArr);
        										// String strRev = String.valueOf(newArr);
        return isPalindrom(strRev);
    }
    
}