package UnfairQueue;

public class SimpleQueue implements Queue{
	private QNode head;
	private int count = 0;
	
	public SimpleQueue() {
		head = new QNode(null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see UnfairQueue.Queue#insert(java.lang.Integer)
	 */
	public void insert(Integer n) {
		QNode newNode = new QNode(n);
		QNode crt = head;
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
			System.out.println("Empty Queue"); return null;
		} else {
			QNode crt = head;
			QNode rm = head;	
			while (crt.getNext()!= null) {
				if (crt.getNext().getVal().compareTo(rm.getNext().getVal()) > 0 ) {
					rm = crt;
				}
				crt = crt.getNext();
			}
		return removeNext(rm);
		}
	}
	
	public boolean isEmpty() {
		 return head.getNext() == null ? true : false;
	}
	
	/*
	 * remove the QNode after place
	 */
	private Integer removeNext(QNode place) {
		QNode crt = place.getNext();
		place.setNext(crt.getNext());
		crt.setNext(null);
		return crt.getVal();
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
