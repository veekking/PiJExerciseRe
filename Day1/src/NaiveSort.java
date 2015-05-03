import UtilPack.RefClass;
import UtilPack.Util;


public class NaiveSort {
	public static void main(String[] args) {
		int n = 3;
		double[] input = Util.ReadDouble(n);
		RefClass[] comp =  new RefClass[n] ;
		
		// Initialization of RefClass
		for (int i = 0; i< n; i++)
			comp[i] = new RefClass(input[i]);
		
		// Sort using wrap-up class RefClass, so as to pass by reference
		// Bubble Sort
		int j = 1;
		while (j < n){
			for (int k=j; k>0; k--) {
				if (comp[k].val < comp[k-1].val)
				Util.swap(comp[k], comp[k-1]);
			}
			j++;
		}
		
		// Output
		System.out.println("Sorted sequence is: ");
		for (int i = 0; i< n; i++)
			System.out.print(comp[i].val + " "); 

	}
}


