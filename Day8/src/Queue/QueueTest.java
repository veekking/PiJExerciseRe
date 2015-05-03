package Queue;

public class QueueTest {
	public static void main(String[] args) {
		launchQueue();
	}
	
	public static void launchQueue() {
		SuperMarket nq = new SuperMarket();
		nq.print();
		nq.addPerson("John");
		nq.addPerson("Mary");
		System.out.println("The retrieved element is: " + nq.serve());
		nq.addPerson("Katy");
		nq.print();
		
		System.out.println("The retrieved element is: " + nq.serve());
		System.out.println("The retrieved element is: " + nq.serve());
		System.out.println("The retrieved element is: " + nq.serve());
		System.out.println("The retrieved element is: " + nq.serve());
		nq.print();
	}	

}
