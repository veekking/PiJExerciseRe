/*
 * Test the size of the stack
 * for doulbe, The size of stack is9534, is9574, is9602
 * for int, is9602, is9754...
 */

import java.lang.StackOverflowError;

public class OverFlow {
	
	private int count;
	
	public static void main(String[] args){
		OverFlow of = new OverFlow(0);
		of.recursiveCall(0);
	}
	
	OverFlow(int n) {count = n;}
	
	private void recursiveCall(int n) {
		try {
			count = count+1;
			recursiveCall(n+1);
		} catch (StackOverflowError exception) {
			System.out.println("The size of stack is" + count);
		}
	}
	
	
	

}
