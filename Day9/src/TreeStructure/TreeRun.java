package TreeStructure;

public class TreeRun {
	public static void main(String[] args) {
		TreeRun trun1 = new TreeRun();
		trun1.launchPrintSimple();
	}
	
	public void launchIntegerTree() {
		Tree t1 = new IntegerTree1();
		t1.insert(3);
		t1.insert(9);
		t1.insert(100);
		t1.insert(9);
		t1.insert(-50);
		t1.insert(77);
		
		System.out.println("The min of the tree is: " + t1.getMin());
		System.out.println("The max of the tree is: " + t1.getMax());
		
		System.out.println("The tree contains 9" + (t1.contains(9) ? "Yes" : "No"));
		System.out.println("The tree contains 77" + (t1.contains(77) ? "Yes" : "No"));
	}
	
	public void launchPrintSimple() {
		Tree t2 = new IntegerTree1();
		System.out.println("The depth of the tree is: " + t2.depth());
		t2.insert(6);
		t2.insert(9);
		t2.insert(5);
		System.out.println("The depth of the tree is: " + t2.depth());
		t2.insert(3);
		t2.insert(8);
		t2.insert(11);
		t2.insert(12);
		System.out.println("The print of the tree is: " + t2.toStringSimple2());
		System.out.println("The depth of the tree is: " + t2.depth());
		
		
		t2.delete(6);
		System.out.println("The print of the tree is: " + t2.toStringSimple2());
		System.out.println("The depth of the tree is: " + t2.depth());
		
		System.out.println("The number of elements in the tree is: " + t2.size());
	}
	
	
}
