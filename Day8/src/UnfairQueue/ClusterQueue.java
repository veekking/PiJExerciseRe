/*
 * table table
 * table[0] - NormalQueue (age > 65)
 * table[1] - NormalQueue (18 < age <= 65)
 * table[2] - NormalQueue (age <= 18)
 */

package UnfairQueue;

public class ClusterQueue implements Queue {

	static final int capacity = 3;
	NormalQueue[] table;
	
	ClusterQueue() {
		table = new NormalQueue[capacity];
		for (int i = 0; i<capacity; i++) {
			table[i] = new NormalQueue(); //Have to initialize every NormalQueue, 
										  //otherwise nullPoiterException
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see UnfairQueue.Queue#insert(java.lang.Integer)
	 * insert the Integer to the right bracket
	 */
	public void insert(Integer n) {
		int nt = n.hashCode();
		if (nt > 65) {
			table[0].insert(n); 
		} else if (nt > 18){
			table[1].insert(n);
		} else {
			table[2].insert(n);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see UnfairQueue.Queue#retrieve()
	 * retrieve the first element in non-empty bracket
	 */
	public Integer retrieve() {
		if (isEmpty()) {
			System.out.println("Empty queue, cannot retrieve");
			return null;
		} else {
			for (int i=0; i<capacity; i++){
				if (!table[i].isEmpty()) return table[i].retrieve();
			}
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see UnfairQueue.Queue#isEmpty()
	 */
	public boolean isEmpty() {
		return (table[0].isEmpty() && table[1].isEmpty() && table[2].isEmpty()) ? true : false;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see UnfairQueue.Queue#print()
	 */
	public void print() {
		if (!isEmpty()) {
			String str = new String("[");
			for (int i=0; i<capacity; i++) {
				table[i].print();
			}
		} else {
			System.out.println("Empty queue, cannot print");
		}
	}
}
