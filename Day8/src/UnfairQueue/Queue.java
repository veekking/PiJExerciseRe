package UnfairQueue;

public interface Queue {
	
	/*
	 * Insert value at the back
	 */
	void insert(Integer n);
	
	/*
	 * retrieve the value at the front;
	 */
	Integer retrieve();
	
	/*
	 * test if the queue is empty
	 */
	boolean isEmpty();
	
	/*
	 * Print all elements in the queue
	 * if nothing, print []
	 */
	void print();
}
