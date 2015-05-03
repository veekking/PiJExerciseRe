package TreeStructure;

public class IntegerTreeNode {
	int val;
	IntegerTreeNode left;
	IntegerTreeNode right;
	
	IntegerTreeNode(int n) {
		val = n;
		left = null;
		right = null;
	}
	
	int getVal() {
		return val;
	}
	
	void setVal(int n){
		val = n;
	}
	
	IntegerTreeNode getLeft() {
		return left;
	}
	
	IntegerTreeNode getRight() {
		return right;
	}
	
	void setLeft(IntegerTreeNode l) {
		left = l;
	}
	
	void setRight(IntegerTreeNode r) {
		right = r;
	}
}
