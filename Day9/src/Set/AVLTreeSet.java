package Set;

public class AVLTreeSet implements InSet{
	private TWNode head;
	
	AVLTreeSet() {
		head = null;
	}
	
	public void add(int n) {
		if (head == null) {
			head = new TWNode(n);
		} else {
			insertAVL(head, n);
		}
	}
	
	public boolean contains(int n) {return true;}
	public int containsVerbose(int n) {return 0;}
	
	private void insertNormal(TWNode crt,int n) {
		if (n > crt.getVal()) {
			if (crt.getRight() == null) {
				TWNode nd = new TWNode(n);
				crt.setRight(nd);
				nd.setPrn(crt);
			} else {
				insertNormal(crt.getRight(), n);
			}
		} else {
			if (crt.getLeft() == null) {
				TWNode nd = new TWNode(n);
				crt.setLeft(nd);
				nd.setPrn(crt);
			} else {
				insertNormal(crt.getLeft(), n);
			}
		}
	}
	
	private void insertAVL(TWNode crt, int n) {
		if (n > crt.getVal()) {
			if (crt.getRight() == null) {
				TWNode nd = new TWNode(n);
				nd.setRightChild(true);
				crt.setRight(nd);
				nd.setBalance(nd.getBalance());
				updateBalance(nd);
			} else {
				insertAVL(crt.getRight(), n);
			}
		} else if (n < crt.getVal()) {
			if(crt.getLeft() == null) {
				TWNode nd = new TWNode(n);
				nd.setLeftChild(true);
				crt.setLeft(nd);
				nd.setBalance(nd.getBalance());
				updateBalance(crt.getLeft());
			} else {
				insertAVL(crt.getLeft(), n);
			}
		}
	}
	
	void updateBalance(TWNode crt) {
		int t1 = crt.getBalance();
		if (t1< -1 || t1 > 1) rebalance(crt);
		if (crt.getPrn() != null) {
			updateBalance(crt.getPrn());
		}
	}
	
	void rebalance(TWNode crt) {
		if (crt.getBalance() < 0) {
			if (crt.getRight().getBalance() < 0) {
				turnLeft(crt);
			} else {
				turnRight(crt.getRight());
				turnLeft(crt);
			}
		} else {
			if (crt.getBalance() > 0) {
				turnRight(crt);
			} else {
				turnLeft(crt.getLeft());
				turnRight(crt);
			}
		}
	}
	
	void turnLeft(TWNode c) {
		TWNode temp = c.getRight();
		c.setRight(temp.getLeft());
		if (c.isLeftChild() && !c.isRightChild()) c.getPrn().setLeft(temp);
		if (c.isRightChild() && !c.isLeftChild()) c.getPrn().setRight(temp);
		if (!c.isLeftChild() && !c.isRightChild()) head = temp;
		temp.setLeft(c);;
	}
	
	void turnRight(TWNode c) {
		TWNode temp = c.getLeft();
		c.setLeft(temp.getRight());
		if (c.isLeftChild() && !c.isRightChild()) c.getPrn().setLeft(temp);
		if (c.isRightChild() && !c.isLeftChild()) c.getPrn().setRight(temp);
		if (!c.isLeftChild() && !c.isRightChild()) head = temp;
		temp.setRight(c);
	}
	
	
	
	
	
	
	
	public String toString() {
		if (head == null) return "Empty String";
		return toStringVal(head);
	}
	
	private String toStringVal(TWNode t) {
	 return (t.getLeft() == null ? "" : toStringVal(t.getLeft()) ) + t.getVal() + " L" +t.levelCal(t)+ ", "+ (t.getRight() == null ? "" : toStringVal(t.getRight()));
		
	}
	
	
}
