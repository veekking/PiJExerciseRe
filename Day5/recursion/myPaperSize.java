import java.util.Scanner;
import java.lang.String;
import java.lang.Character;


public class myPaperSize {
	private int length = 0;
	private int width = 0;
	private String type;
	
	
	myPaperSize() {
		length = 1189;
		width = 841;
		type = "A0";
	}
	
	myPaperSize(String st) {
		type = st;
		myPaperSize mp ; 
		if (st.length() == 2) {
			mp = ConstructSmallPaper(Character.getNumericValue(st.charAt(1)));
		} else {
			mp = ConstructLargePaper(st.length()-1); 
		}
		length = mp.getLength();
		width = mp.getWdith();
	}
	
	private myPaperSize ConstructSmallPaper(int n) {
		myPaperSize mmp = new myPaperSize();
		paperSize(mmp.getLength(), mmp.getWidth(), n);
	}
	
	
	
	
private myPaperSize paperSize(int L, int W, int digit) {
		if (digit == 0) {
			return new myPaperSize();
		} else {
			return paperSize(W, L/2, digit-1);
		}
	}
private int paperSizeNext(int L, int W, int digitNext) {
	if (digitNext == 1)  {
		return  sizeZero(L, W) 
	} else {
		return paperSizeNext(W*2, L, digitNext-1);
	}
}

private void sizeZero() {
	myPaperSize mz = new myPaperSize();
}

public static void main(String[] args) {
	System.out.println("Please type a paper size");
	Scanner myScan = new Scanner(System.in);
	String str = myScan.nextLine();
	if ( (str.charAt(0) == 'A' )&& ((str.length() == 2 && Character.isDigit(str.charAt(1)) ) || 
							str.substring(1,str.length()).matches("[0]++")) ) {
		myPaperSize paper = new myPaperSize(str);
	} else {
		System.out.println("Invalid input");
	}
	
}

}
