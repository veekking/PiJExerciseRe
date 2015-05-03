package Queue;

public class SuperMarket {
	private PersonQueueImpl pq; 
	
	public SuperMarket() {
		pq = new PersonQueueImpl();
	}
	
	public void addPerson(Object dataVal ) {
		pq.insert(dataVal);
	}
	
	public Object serve() {
		return pq.retrieve();
	}
	
	public void print() {
		pq.print();
	}

}
