package Set;

public class TreeSet {
	private TNode head;
	
	TreeSet() {
		head = null;
	}
	
	/*
	 * Add element to the tree
	 */
	public void insert(int n ) {
		if (head==null) {
			TNode nd = new TNode(n);
			head = nd;
		} else {
			add(head, n);
		}
	}
	
	
	/*
	 * Recursive call function to add a TNode
	 */
	private void add(TNode t, int n) {
		if (n > t.getVal()) {
			if (t.getRight() == null) {
				t.setRight(new TNode(n));
			} else {
				add(t.getRight(), n); 
			}
		} else {
			if (n < t.getVal()) {
				if (t.getLeft() == null) {
					t.setLeft(new TNode(n));
				} else {
					add(t.getLeft(), n);
				}
			}
		}
	}
	
	public boolean contains(int n) {
		if (head == null) {System.out.println("Empty tree"); return false;}
		return isContain(head, n);
	}
	
	public boolean containsVerbose(int n) {
		if (head == null) {System.out.println("Empty set"); return false;}
		return isContainsVerbose(head, n);
	}
	
	public String toString() {
		if (head == null) return "Empty String";
		return toStringVal(head);
	}
	
	String toStringVal(TNode t) {
	 return (t.getLeft() == null ? "" : toStringVal(t.getLeft()) ) + t.getVal() + ", "+ (t.getRight() == null ? "" : toStringVal(t.getRight()));
		
	}
	
	private boolean isContain(TNode t, int n) {
		
		if (t.getVal() == n) {
			return true;
		} else {
			if (n > t.getVal()) {
				if (t.getRight() == null) {
					return false;
				} else {
					return isContain(t.getRight(), n);
				}
			} else {
				if (t.getLeft() == null) {
					return false;
				} else {
					return isContain(t.getLeft(), n);
				}
			}
		}
	}
	
	private boolean isContainsVerbose(TNode t, int n) {
		System.out.print(t.getVal() + "/t"); // the only difference compared to isContains()
			
			if (t.getVal() == n) {
				return true;
			} else {
				if (n > t.getVal()) {
					if (t.getRight() == null) {
						return false;
					} else {
						return isContainsVerbose(t.getRight(), n);
					}
				} else {
					if (t.getLeft() == null) {
						return false;
					} else {
						return isContainsVerbose(t.getLeft(), n);
					}
				}
			}
		}

	
	
	
	
	
}
