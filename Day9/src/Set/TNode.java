package Set;

public class TNode {
	private int val;
	private TNode left;
	private TNode right;
	
	TNode() {
		val = 0;
		left = null;
		right = null;
	}
	
	TNode(int n) {
		val = n;
		left = null;
		right = null;
	}
	
	int getVal() {
		return val;
	}
	
	void setVal(int n) {
		val = n;
	}
	
	TNode getLeft() {
		return left;
	}
	
	TNode getRight() {
		return right;
	}
	
	void setLeft(TNode l) {
		left = l;
	}
	
	void setRight(TNode r) {
		right = r;
	}
}
