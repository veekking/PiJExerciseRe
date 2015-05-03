/*
 * This Matrix class create mxn matrix
 * initialize value into -1;
 * replace row or column values by string
 * print matrix value in string
 * compare 1D and 2D Symmetry
 * isTriangle?
 */

import java.util.Arrays;
import java.util.StringTokenizer;
import java.lang.String;
import java.lang.Integer;
import java.util.ArrayList; // to convert 2D to 1D

public class CreatMatrix {
	
	private int row = 0;
	private int col = 0;
	private int[][] Arr;
	
	CreatMatrix(int x, int y) {
		
		row = x;
		col = y;
		Arr = new int[row] [col];
		for (int[] rows :Arr) {
			Arrays.fill(rows, -1); //fill only for 1D, has to loop 
		}
	}
	
	public void setElem(int pos1, int pos2, int elem) {
		if ((pos1>=0 && pos1<=row) && (pos2>=0 && pos2<=col)) Arr[pos1][pos2] = elem;
	}
	
	public void setRow(int pos, String str) {
		setRowOrColumn(pos, str, 'r');
	}
	
	public void setColumn(int pos, String str) {
		setRowOrColumn(pos, str, 'c');
	}
	
	public String toStrings() {
		String str = new String("[");
		for (int[] rows: Arr) {
			for (int n:rows) {
				str += String.valueOf(n);
				str += ",";
			}
			str += ";";
		}
		str += "]";
		return str;
	}
	
	private void setRowOrColumn(int pos, String str, char c) {
		int idx = (c == 'r'? col : row);
		int d2 = (c=='r'? row: col);
		if (pos >= 0 && pos <=d2) {
			String[] elements = str.split(",");
			if (elements.length == idx) {
				for (int i = 0; i<idx ; i++) {
					if (c == 'r') Arr[pos][i] = Integer.parseInt(elements[i]);
					if (c == 'c') Arr[i][pos] = Integer.parseInt(elements[i]);
				}
			}
		}
	}
	
	/*
	 * mxn matrix only returns n
	 */
	private int Size() {
		return Arr.length;
	}
	
	/*
	 * Caller function, if 1D convert to 2D array and call checkSymmetry1
	 * if 2D, call checkSymmetry2;
	 */
	public boolean isSymmetry() {
		if (row == 1 || col == 1) {
			int[] DArr = convert1Dto2D();
			return checkSymmetry1(DArr);
		}
		return checkSymmetry2();
	}
	
	/*
	 * check Triangular
	 */
	public boolean isTriangulr() {
		for (int i =1; i<row; i++) {
			for (int j=0; j<i; j++) {
				if (Arr[i][j] != 0) return false;
			}
		}
		return true;
	}
	
	/*
	 * Convert 2 dimensional matrix with 1 row or column to array
	 * Arry -> ArrayList (return Integer[]) -> int[]
	 */
	
	private int[] convert1Dto2D() {
		ArrayList<Integer> lst = new ArrayList<>();
	
		for (int[] rows: Arr) {
			for (int n: rows) lst.add(n);
		}
		
		// ArrayList<int> () returns wrapper class Integer();
		// has to convert from Integer() to int[]
		int[] newArr = new int[lst.size()];
		for (int i =0; i<lst.size(); i++) newArr[i] = lst.get(i);
		return newArr;
	}
	
	/*
	 * Check 1D symmetry
	 * Recursive call
	 */
	private boolean checkSymmetry1(int[] arr) {
		if (arr.length == 0 || arr.length == 1) {
			return true;
		} else {
			return (arr[0] == arr[arr.length -1] && checkSymmetry1(Arrays.copyOfRange(arr,1,arr.length-1)));
		}
	}
	
	private boolean checkSymmetry2() {
		for (int i=0; i<row; i++) {
			for (int j=0; j<i; j++) {
				if (Arr[i][j] != Arr[j][i]) return false;
				}
			}
		return true;
	}
	
	
	
	
	
	public static void main(String[] args) {
		CreatMatrix m = new CreatMatrix(4,5);
		System.out.println("The created string is: " + m.toStrings());
		System.out.println("2D is" +( m.isSymmetry() ? "Yes" : "No"));
		m.setRow(2,"6,5,4,3,2");
		System.out.println("The rest string is: " + m.toStrings());
		System.out.println("Size is:  " + m.Size());
		System.out.println("2D is" +( m.isSymmetry() ? "Yes" : "No"));
		System.out.println("2D is" +( m.isTriangulr() ? "Yes" : "No"));
		
		
		CreatMatrix m1 = new CreatMatrix(4,1);
		System.out.println("The 1D string is: " + m1.toStrings());
		System.out.println("1D is" + (m1.isSymmetry()? "Yes" : "No"));
		
		
		
	}
	

}
