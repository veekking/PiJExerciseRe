package UtilPack;

import java.util.Scanner;
import java.util.Random;

public class Util {
	
	/*
	 * read n numbers and output an array
	 */
	public static double[] ReadDouble(int n) {
		Scanner MyScanner = new Scanner(System.in);
		double[] input = new double[n];
		for (int i = 0; i<n; i++) {
			System.out.println("Please type # " + (i+1) + " double");
			while (!MyScanner.hasNextDouble()) {
				System.out.println("Try again: ");
				MyScanner.next();
			}
			input[i] = MyScanner.nextDouble();
		}
		MyScanner.close();
		return input;                     
	};
	
	/*
	 * Swap a and b's value
	 * Since Java cannot pass by ref for primitive data types
	 * wrap-up class RefClass is created, so that a and b are directly modified
	 */
	public static void swap(RefClass a, RefClass b) {
		RefClass temp = new RefClass(a.val);
		a.val = b.val;
		b.val = temp.val;
	}
	
	/*
	 * Ask user for input if invalid
	 * Pass by ref, Scanner 
	 */
	public static void ValidInputDouble (Scanner s) {
		while (!s.hasNextDouble()) {
			System.out.println("Invalid input, try again: ");
			s.next();
		} 
	}
    
    
    /*
     * Random integer generator min to max
     */
    
    public static int RandInt (int a, int b) {
        Random r = new Random();
        return a+r.nextInt(b);
        
    }
    
    
    /*
     * Generage an array of size n of Ranger integers min to max
     */
    
    public static int[] RandIntArr(int a, int b, int n) {
        Random r = new Random();
        int[] arr = new int[n];
        
        for (int i = 0; i< n; i++) {
            arr[i] = a+ r.nextInt(b);
        }
        
        return arr;
    }
}
