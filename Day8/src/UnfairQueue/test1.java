package UnfairQueue;

public class test1 {
	public static void main(String[] args) {
		test1 tst = new test1();
		tst. launchCluster();
	}
	
	public void launchSimp() {
		Queue nq = new SimpleQueue();
		nq.print();
		nq.insert(new Integer(4));
		nq.insert(new Integer(100));
		nq.insert(new Integer(60));
		nq.insert(new Integer(-5));
		System.out.println("The retriveed int is: " + nq.retrieve());
		nq.print();
		
		nq.insert(new Integer(0));
		nq.insert(new Integer(999));
		nq.insert(new Integer(40));
		System.out.println("The retriveed int is: " + nq.retrieve());
		nq.print();
		
		nq.retrieve();
		nq.retrieve();
		nq.retrieve();
		nq.retrieve();
		nq.retrieve();
		nq.retrieve();
		nq.retrieve();
		nq.print();
	}
	
	public void launchCluster() {
		Queue cq = new ClusterQueue();
		cq.print();
		cq.insert(new Integer(4));
		cq.insert(new Integer(100));
		cq.insert(new Integer(60));
		cq.insert(new Integer(75));
		System.out.println("The retriveed int is: " + cq.retrieve());
		cq.print();
		
		cq.insert(new Integer(0));
		cq.insert(new Integer(35));
		cq.insert(new Integer(40));
		System.out.println("The retriveed int is: " + cq.retrieve());
		cq.print();
		
		System.out.println("The retriveed int is: " + cq.retrieve());
		System.out.println("The retriveed int is: " + cq.retrieve());
		cq.retrieve();
		cq.retrieve();
		cq.retrieve();
		cq.retrieve();
		cq.retrieve();
		cq.print();
	}

}
