package UnfairQueue;

public class NormalQueue implements Queue{
	private QNode  head;
	
	NormalQueue() {
		head = new QNode(null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see UnfairQueue.Queue#insert(java.lang.Integer)
	 */
	
	public void insert(Integer n){
		QNode crt = head;
		QNode newNode = new QNode(n);
		while (crt.getNext() != null) {
			crt = crt.getNext();
		}
		crt.setNext(newNode);
	}
	
	/*
	 * (non-Javadoc)
	 * @see UnfairQueue.Queue#retrieve()
	 */
	public Integer retrieve() {
		if (isEmpty()) {
			System.out.println("Empty Queue");
			return null;
		} else {
			QNode crt = head.getNext();
			head.setNext(crt.getNext());
			crt.setNext(null);
			return crt.getVal();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see UnfairQueue.Queue#isEmpty()
	 */
	public boolean isEmpty() {
		 return head.getNext() == null ? true : false;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see UnfairQueue.Queue#print()
	 */
	public void print(){
		QNode crt = head;
		String str = new String("[");
		while (crt.getNext()!= null ) {
			str += crt.getNext().getVal();
			str += ",";
			crt = crt.getNext();
		}
		str += "]";
		System.out.println("The queue is: " + str);
	}
	
}
