package TreeStructure;

public class IntegerTree {
	IntegerTreeNode head; 
	
	IntegerTree() {
		head = null;
	}
	
	public void insert(int n) {
		if (head == null) {
			head = new IntegerTreeNode(n);
		} else
			add(head, n);
		}
	
	// if nd and add point to the same class 
	private void add(IntegerTreeNode nd, int n) {
		if (nd == null) {
			 nd = new IntegerTreeNode(n);
		} else if (n > nd.getVal()){
			 add(nd.getRight() , n);
		} else {
			 add(nd.getLeft(), n);
		}
		// if equal, do noghing;
	}
	
	public boolean contains(int n) {
		return find(head, n);
	}
	
	private boolean find(IntegerTreeNode nd, int n) {
		if (nd == null) {return false;}
		if (nd.getVal() == n){
			return true;
		} else if (n > nd.getVal()) {
			return find(nd.getRight(), n);
		} else {
			return find(nd.getLeft(), n);
		}
	}
	
	public int getMax(){
		if (isEmpty()) {
			System.out.println("Empty Tree"); 
			return 0;
		} else {
			IntegerTreeNode crt = head;
			while (head.getRight() != null) {
				crt = crt.getRight();
			}
			return crt.getVal();
		}
	}
	
	public int getMin(){
		if (isEmpty()) {
			System.out.println("Empty Tree"); 
			return 0;
		} else {
			IntegerTreeNode crt = head;
			while (head.getLeft() != null) {
				crt = crt.getLeft();
			}
			return crt.getVal();
		}
	}

	
	public boolean isEmpty() {
		return head == null ? true: false;
	}
	

}
