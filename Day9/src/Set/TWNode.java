package Set;

public class TWNode {
	 int val;
	TWNode left;
	TWNode right;
	TWNode parent;
	int level;
	boolean isRight;
	boolean isLeft;
	
	TWNode() {
		val = 0;
		left = null;
		right = null;
		parent = null;
		level = getBalance();
		isRight = false;
		isLeft = false;
	}
	
	TWNode(int n) {
		val = n;
		left = null;
		right = null;
		parent = null;
		level = getBalance();
		isRight = false;
		isLeft = false;
	}
	
	int getVal() {
		return val;
	}
	
	void setVal(int n) {
		val = n;
	}
	
	TWNode getLeft() {
		return left;
	}
	
	TWNode getRight() {
		return right;
	}
	
	void setLeft(TWNode l ) {
		left = l;
		l.setPrn(this);
	}
	
	void setRight(TWNode r) {
		right = r;
		r.setPrn(this);
	}
	
	TWNode getPrn() {
		return parent;
	}
	
	void setPrn(TWNode p) {
		parent = p;
	}
	
	void setRightChild(boolean t) {
		isRight = true; isLeft= false;
	}
	
	void setLeftChild(boolean t) {
		isLeft = true; isRight = false;
	}
	
	boolean isRightChild() {
		return isRight && (!isLeft);
	}
	
	boolean isLeftChild() {
		return isLeft && (!isRight);
	}
	
	
	/*
	 * Something wrong with the getBalance() function
	 */
	int getBalance() {
		if (this.getLeft() == null || this.getRight() == null) {
			return (this.getLeft()==null ? 0 : 1) - (this.getRight() == null? 0 : 1);
		}else {
			return levelCal(this.getLeft()) - levelCal(this.getRight());
		}
	}
	
	void setBalance(int l) {
		level = l;
	}
	
	public int levelCal(TWNode nd) {
		if (nd.getLeft() == null  && nd.getRight() == null) {
			return 0;
		} else if (nd.getLeft() == null) {
			return 1+levelCal(nd.getRight());
		} else if (nd.getRight() == null) {
			return 1+levelCal(nd.getLeft());
		} else {
			return Math.max(1+levelCal(nd.getLeft()), 1+levelCal(nd.getRight()));
		}
	}
}

