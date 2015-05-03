/*
 * Construct a linked list from an integer array
 */

package Sort;

import DoubleLinkedList.*; //include the package
import java.lang.Integer;

public class ListUtilities {
	Node head;
	public static int capacity;
	
	/*
	 * Empty constructor
	 */
	ListUtilities() {
		head = null;
	}
	
	/*
	 * Constructor
	 */
	ListUtilities(Integer[] arr) {
		head = new NodeImpl(null);
		for (int i = 0; i<arr.length; i++){
			add(arr[i]);  // Use the add(Object dataVal) method to initiate the constructor;
		}
	}
	
	/*
	 * add Object to construct the list
	 */
	private void add(Object dataVal) {
		Node newNode = new NodeImpl(dataVal);
		Node current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newNode);
		capacity++;
	}
	
	public void print() {
		print(head);
	}
	
	
	public static void print(DoubleLinkedList.Node h) {
		DoubleLinkedList.Node current = h;
		String str = new String("[");
		while (current.getNodeBack().getNodeBack() != null) { //because there is one additional tail node, so jump forward twise
			current = current.getNodeBack();
			str += current.getValue();   // why cannot use current.getVal().toString() ??
			str += ",";
		}
		str += "]";
		System.out.println("The output is: " + str);
	}
	
	/*
	 * Print the result
	 */
	
	public static void print(Node h) {
		Node current = h;
		String str = new String("[");
		while (current.getNext() != null) {
			current = current.getNext();
			str += current.getVal();   // why cannot use current.getVal().toString() ??
			str += ",";
		}
		str += "]";
		System.out.println("The output is: " + str);
	}
	
	/*
	 * Bubble sort the node
	 */
	public void sortNode() {
		int sortCount = 1;
		if (capacity > 1) {
			while (sortCount != 0) {
				sortCount = 0;
				Node current = head;
				for (int i = 1; i<capacity; i++) {  
					
					//make sure the current Node doesn't go over the limit
					Node first = current.getNext();
					Node second = first.getNext();
					
					// compare fist and second node value, swap if needed
					if (((Integer) first.getVal()).compareTo((Integer) second.getVal()) > 0) {
						swapNode(current, first, second);
						sortCount++; //update sortCount
					}
					current = current.getNext();
				}
			}
		}
	}
	
	/*
	 * Cocktail sort
	 * Because cocktail sort use the Double list, which belongs to another package
	 * Include the package, packageName.class for any class belongs to that package
	 * cannot cast the type among two different packages, us the underlying implementation/data structures are different
	 * Be aware of the counts!!!
	 */
	public void cocktailSort() {
		DoubleList dl = new DoubleList();
		Node current = head;
		while (current.getNext() != null ) {  //why cannot use getVal != null
			dl.addBack(current.getNext().getVal());
			current = current.getNext();
		}
		System.out.print("The copies double linked list is: ");
		print(dl.getHead()); 
		
		int sortCount = 1;
		while (sortCount != 0) {
			sortCount = 0;
			DoubleLinkedList.Node crt = dl.getHead();  
			DoubleLinkedList.Node first = null;
			DoubleLinkedList.Node second = null;
			// sort on the way up
			for (int i=1; i<dl.size(); i++) {
				first = crt.getNodeBack();
				second = first.getNodeBack();
				
				// if first is bigger than second, swap
				if ( ((Integer) first.getValue()).compareTo((Integer) second.getValue()) > 0 ) {
					swapNodeBack(crt, first, second);
					sortCount++;}
				crt = crt.getNodeBack();
			}
			
			// sort on the way down
			crt = second;
			for (int j = 1; j < dl.size()-2; j++) { //why size()-2??
				first = crt.getNodeFront();
				second = first.getNodeFront();
				
				// if first is smaller than second, swap
				if  ( ((Integer) first.getValue()).compareTo((Integer) second.getValue()) < 0 ) {
					swapNodeForward(crt, first, second);
					sortCount++;
				}
				crt = crt.getNodeFront();
			}
		}
		System.out.print("The cocktail sort result is: ");
		print(dl.getHead()); // why need  cast to Node; because otherwise return DoubleLinkedList.Node
		
		
	}
	
	/*
	 * Swap a and b
	 * base -> a -> b
	 */
	private void swapNode(Node base, Node a, Node b) {
		if (a.getVal() != null && b.getVal()!= null) {
			base.setNext(b);
			Node temp = b.getNext();
			b.setNext(a);
			a.setNext(temp);
		}
	}
	
	/*
	 * Swap a, b position
	 * Before base->a->b
	 * After base->b->a
	 */
	private void swapNodeBack(DoubleLinkedList.Node base, DoubleLinkedList.Node a, DoubleLinkedList.Node b) {
		if (a.getValue() != null && b.getValue()!= null) {
			base.setNodeBack(b);
			DoubleLinkedList.Node temp = b.getNodeBack();
			b.setNodeBack(a);
			b.setNodeFront(base);
			a.setNodeBack(temp);
			a.setNodeFront(b);
			temp.setNodeFront(a);
			
		}
	}
	
	/*
	 * Swap a, b position 
	 * Before b<-a<-base
	 * After  a<-b<-base
	 */
	private void swapNodeForward(DoubleLinkedList.Node base, DoubleLinkedList.Node a, DoubleLinkedList.Node b) {
		if (a.getValue() != null && b.getValue()!= null) {
			base.setNodeFront(b);
			DoubleLinkedList.Node temp = b.getNodeFront();
			b.setNodeFront(a);
			b.setNodeBack(base);
			a.setNodeFront(temp);
			a.setNodeBack(b);
			temp.setNodeBack(a);
			
		}
	}
	
}
