package Spy;

public class SpyList {
	private Node head; 
	public static int spyCount = 0;
	
	SpyList() {
		head = new SpyImpl(null);
	}
	
	/*
	 * Add a new spy
	 */
	public void addSpy(Object dataValue) {
		Node newSpy = new SpyImpl(dataValue);
		Node current = head;
		while(current.getNextSpy() != null) {
			current = current.getNextSpy();
		}
		current.setNextSpy(newSpy);
		spyCount++;
	}
	
	/*
	 * Kill the last spy
	 */
	public void killSpy() {
		if (spyCount == 0) {
			System.out.println("No spy exists");
		} else {
			Node current = head;
			while (current.getNextSpy().getNextSpy()!=null) {
				current = current.getNextSpy();
			}
			System.out.println("The last spy has been killed");
			current.setNextSpy(null);
			spyCount--;
		}
	}
	
	
	public void killFirstSpy() {
		if (spyCount == 0) {
			System.out.println("No spy to kill"); 
		} else {
			head.setNextSpy(head.getNextSpy().getNextSpy());
			System.out.println("The first spy has been killed");
			spyCount--;
		}
	}
	/*
	 * Kill the spy with specific ID
	 * if ID not found, cannot kill
	 */
	public void killSpy(Object dataVal) {
		Node current = head;
		while (current.getNextSpy()!=null) {
			if (current.getNextSpy().getSpy().equals(dataVal)) { // check the next spies' value before move the current forward
				System.out.println("Spy" + dataVal.toString() + "has been killed");
				break;
			}
			current = current.getNextSpy();
		}
		if (current.getNextSpy() == null) {
			System.out.println("Spy" + dataVal.toString() + "Cannot be killeld");
		
		} else {
			current.setNextSpy(current.getNextSpy().getNextSpy());
			spyCount--;
		}
		
	}
	
	/*
	 * Print the list of spies
	 */
	public void print() {
		Node current = head.getNextSpy();
		System.out.print("The spys are: \n");
		while (true) {
			System.out.print(current.getSpy().toString() + ",\n");
			if (current.getNextSpy() == null) break;
			current = current.getNextSpy();
		}
		
		System.out.print("Finish!\n");
	}
	
	/*
	 * Total number of spies 
	 */
	public int numSpies() {return spyCount;}
	
	public static void main(String[] args) {
		SpyList spies = new SpyList();
		spies.killSpy();
		spies.addSpy("1");
		spies.addSpy("2");
		spies.addSpy("3");
		spies.addSpy("a");
		spies.addSpy("b");
		spies.addSpy("c");
		
		System.out.println("Total number of splies are " + spies.numSpies());
		spies.print();
		
		spies.killFirstSpy();
		spies.print();
		
		spies.killSpy();
		spies.killSpy("1");
		spies.killSpy("123");
		System.out.println("Total number of splies are " + spies.numSpies());
		spies.print();
	}

}
