package Queue;

public class PersonQueueImpl {
	private PersonImpl head;
	
	public PersonQueueImpl() {
		head = null;
	}
	
	/*
	 * insert dataVal
	 * loop from head to the end, and insert the dataVal;
	 */
	public void insert(Object dataVal) {
		PersonImpl np = new PersonImpl(dataVal);
		if (head != null) {
			PersonImpl crt = head;
			while (crt.getNext() != null) {
				crt = crt.getNext();
			}
			crt.setNext(np);
		} else {
			head = np;
		}
	}
	
	/*
	 * retrieve at the beginnig of the queue
	 */
	Object retrieve() {
		if (head == null) {
			System.out.println("Empty Queue");
			return null;
		} else {
			PersonImpl crt = head;
			head = head.getNext();
			return crt.getVal();
		}
	}
	
	/*
	 * Print the queue
	 */
	
	void print() {
		PersonImpl crt = head;
		String str = new String("[");
		while (crt!=null) {
			str += crt.getVal();
			crt = crt.getNext();
		}
		str += "]";
		System.out.println("The queue is: " + str);
	}

	
}
