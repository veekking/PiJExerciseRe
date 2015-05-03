package TreeStructure;

public class IntegerTree1 implements Tree{
	int val;
	IntegerTree1 left;
	IntegerTree1 right;
	boolean isEmpty = true;
	static int elemCount;
	
	IntegerTree1() {
		val = 0;
		left = null;
		right = null;
		isEmpty = true;
		elemCount = 0;
	}
	
	IntegerTree1(int n) {
		val = n;
		left = null;
		right = null;
		isEmpty = false;
		
	}
	
	public void insert(int n) {
		if (isEmpty) {
			val = n;
			left = null;
			right = null;
			isEmpty = false;
			elemCount = 1;
		} else if (n > val){
			if (right == null) {
				right = new IntegerTree1(n);
				elemCount++;
			} else {
				right.insert(n);
			}
		} else {
			if (left == null) {
				left = new IntegerTree1(n);
				elemCount++;
			} else {
				left.insert(n);	
			}
		}
	}
	
	public boolean contains(int n) {
		if (val == n) {
			return true;
		} else if (n>val){
			if (right == null) {
				return false;
			} else {
				return right.contains(n);
			}
		} else {
			if (left == null) {
				return false;
			} else {
				return left.contains(n);
			}
		}
	}
	
	public int getMax() {
		if (isEmpty()) {
			System.out.println("Empty Tree");
			return 0;
		} else {
			if (right == null) return val;
			return right.getMax();
		}
	}
	
	public int getMin() {
		if (isEmpty()) {
			System.out.println("Empty Tree");
			return 0;
		} else {
			if (left == null) return val;
			return left.getMin();
		}
	}
	
	
	public boolean isEmpty() {
		return isEmpty? true : false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see TreeStructure.Tree#toStringSimple()
	 */
	public String toStringSimple() {
		String str = new String("[");
		if (!isEmpty()) {
			str += val;
			str += "L"; 
			if (left!= null ) {
				str += left.toStringSimple(); 
			} else {
				str += "[";
			}
			str += "]";
			str += "R";
			if (right != null ) {
				str += right.toStringSimple();
			} else {
				str += "[";
			}
			str += "]";
			return str;
		} else {
			str += "]";
			return str;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see TreeStructure.Tree#toStringSimple1()
	 */
	public String toStringSimple1() {
		if (isEmpty()) {System.out.println("Empty String"); return "";}
		return "["+val+ " L" + (left== null? "[" : left.toStringSimple1() )+ "] R" + (right == null? "[" :right.toStringSimple1()) + "]";
	}
	
	/*
	 * (non-Javadoc)
	 * @see TreeStructure.Tree#toStringSimple2()
	 */
	public String toStringSimple2() {
		if (isEmpty()) {System.out.println("Empty String"); return "";}
		return " ["+val + (left== null? "" : left.toStringSimple2() ) + (right == null? "" :right.toStringSimple2()) + "] ";
	}
	
	/*
	 * (non-Javadoc)
	 * @see TreeStructure.Tree#depth()
	 * the depth of left and right subtree, whichever is deepest;
	 */
	public int depth() {
		if (isEmpty()) {System.out.println("Empty tree, no depty"); return -1;}
		return Math.max(left==null? 0 : 1+left.depth(), right== null? 0 : 1+right.depth());
	}
	
	public void delete(int n) {
		if (n>val) {
			if (right != null) {
				if (n == right.val) {
					// always check null first, otherwise will throw nullPointerException
					if (right.right == null && right.left == null) {
						right = null;
						elemCount--;
					} else if (right.right == null) {
							IntegerTree1 crt = right.left.MaxNode();
							crt.right = right.right;
							right = crt;
							elemCount--;
					} else {
							IntegerTree1 crt = right.right.MinNode();
							crt.left = right.left;
							right = crt;
							elemCount--;
					}
				} else {
					right.delete(n);
				}
			} else {
				System.out.println("value doesn't exist");
			}
		} else {
			if (left != null) {
				if (n == left.val) {
					if (left.left == null && left.right == null)  {
						left = null;
						elemCount--;
					} else if (left.right == null) {
							IntegerTree1 crt = left.left.MaxNode();
							crt.right = left.right;
							left = crt;
							elemCount--;
					} else {
							IntegerTree1 crt = left.right.MinNode();
							crt.left = left.left;
							left = crt;
							elemCount--;
					}				
				} else {
					left.delete(n);
				}
			} else {
				System.out.println("value doesn't exist");
			}
		}
		
		// the problem remains of how to delete the root node???
		// cannot assign this = this.left or this= this.right
	}
			
			
	/*
	 * Return the rightmost node of this tree
	 */
	private IntegerTree1 MaxNode() {
		if (this == null) return null;
		if (right!=null) {
			return right.MaxNode();
		} else {
			return this;
		}
	}
	
	/*
	 * return the leftmost node of this tree
	 */
	private IntegerTree1 MinNode() {
		if (this == null ) return null;
		return (left!=null) ? left.MinNode() : this;
	}
	
	/*
	 * The number of nodes in the tree
	 */
	public int size() {
		
		//System.out.println("Lef sub tree size is: " + left.size());
		//System.out.println("Lef sub tree size is: " + right.size());
		return elemCount;
	}
	
	/*
	 * Return medium element
	 */
	
	//private IntegerTree1 medium() {
		
	//}
	
	
}
