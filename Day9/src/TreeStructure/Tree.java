package TreeStructure;

public interface Tree {
	
	void insert(int n);
	
	boolean contains(int n);
	
	int getMax();
	
	int getMin();
	
	boolean isEmpty();
	
	/*
	 * The same as toStringSimple1();
	 * But the code is not compact
	 */
	String toStringSimple();
	
	/*
	 * Print tree with all empty and non-empty leaves
	 */
	String toStringSimple1();
	
	/*
	 * Print tree with only non-empty leaves
	 */
	String toStringSimple2();
	
	/*
	 * Return the level of tree
	 * tree with 1 nod is level 0;
	 */
	int depth();
	
	/*
	 * Delete n
	 */
	void delete(int n);
	
	int size();
}
