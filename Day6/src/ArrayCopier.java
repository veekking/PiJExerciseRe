/*
 * Copy array a to array b, why print this strage numbers?
 * The value of b is
16
16
16
16
16
9
9
9
9
9

 * However, the result seems allright when the print statement changed to 
 * System.out.println("Result is: " + b[i] + '\t');  
 */

import java.util.Arrays;
import java.lang.Math;

public class ArrayCopier {
	public static void main(String[] args) {
	int[] a = new int[5];
	Arrays.fill(a, 7);
	int[] b = new int[10];
	Arrays.fill(b, 100);
	arrayCopy(a, b);
	System.out.println("The value of b is");
	//for(int item:b) System.out.print(item + '\t');
	for (int i = 0; i<b.length; i++) System.out.println(b[i] + '\t'); 
	}
	
	private static void arrayCopy(int[] src, int[] dst) {
		java.util.Arrays.fill(dst, 0);
		
		for (int i = 0; i<Math.min(src.length, dst.length); i++) {
			dst[i] = src[i];
		}
	}
	
	
	
}
