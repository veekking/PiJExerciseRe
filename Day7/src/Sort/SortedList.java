/*
 * Create a linked list of integers that is automatically sorted.
 */

package Sort;

public class SortedList {
	Node head;
	public static int capacity = 0;
	
	
	/*
	 * default constructor
	 */
	SortedList() {
		head = new NodeImpl(null);
	}
	
	
	/*
	 * Constructor from an array
	 * call add method
	 */
	SortedList(Integer[] arr) {
		head = new NodeImpl(null);   //have to initialize head first; constructor
		for (int i = 0; i<arr.length; i++) {
			add(arr[i]);
		}
	}
	
	
	/*
	 * Add integer object
	 */
	public void add(Integer n) {
		Node current = head;
		Node newNode = new NodeImpl(n);
		for (int i = 0; i<capacity; i++) {
			if (n.compareTo((Integer) current.getNext().getVal()) < 0) break;
			current = current.getNext();
		}
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		capacity++;
	}
	
	/*
	 * list size
	 */
	public int size() {
		return capacity;
	}
	
	/*
	 * Call static function print in ListUtilities class
	 */
	public void print() {
		ListUtilities.print(head);
	}

}
