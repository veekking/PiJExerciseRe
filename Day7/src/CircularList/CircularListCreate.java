/*
 * CircularList, the back of last element connects to the beginning of the list
 */

package CircularList;

import java.lang.String;

public class CircularListCreate {
	private Node head;
	public static int nodeCount = 0;
	
	CircularListCreate() {
		head = new NodeImpl(null);
		//head.getNext().setNext(head.getNext()); null anyway
	}
	
	/*
	 * Add a node at the beginning
	 */
	public void addFront(Object dataVal) {
		Node newNode = new NodeImpl(dataVal);
		newNode.setNext(head.getNext());
		head.setNext(newNode);
		
		// link the last node to the newly insserted first node
		Node current = newNode;
		nodeCount++; 
		
		// update the last Node connects to the newNode, which is the beginning of the list
		int i = 1;
		while (i < nodeCount ) {
			current = current.getNext();
			i++;
		}
		current.setNext(head.getNext());
		
	}
	
	/*
	 * Add a node at the back
	 */
	public void addBack(Object dataVal) {
		Node current = head;
		Node newNode = new NodeImpl(dataVal);
		
		for (int i=0; i<nodeCount; i++){
			current = current.getNext();
		}

		newNode.setNext(head.getNext());
		current.setNext(newNode);
		nodeCount++;

	}
	
	
	/*
	 * delete a node at the beginning
	 * free the pointer of the deleted Node
	 */
	public void deleteFront() {
		if (nodeCount == 0) {
			System.out.println("Empty list");
		} else {
			Node current = head;
			for (int i = 0; i<nodeCount; i++){
				current = current.getNext();
			}
			
			current.setNext(head.getNext().getNext());
			current = head.getNext(); //assign the deleted Node, otherwise got lost
			head.setNext(current.getNext());
			current.setNext(null);   // free the pointer of deleted Node
			nodeCount--;
		}		
	}
	
	/*
	 * Delte a Node at the back
	 */
	public void deleteBack() {
		if (nodeCount == 0) {
			System.out.println("Empty List");
		} else {
			Node current = head;
			for(int i = 1; i<nodeCount; i++) {
				current = current.getNext();
			}
			Node temp = current.getNext();
			current.setNext(head.getNext());
			temp.setNext(null);
		}
	}
	
	/*
	 * Print, use nodeCount to control the end of the list
	 */
	public void print() {
		Node current = head;
		String str = new String("[");
		for (int i = 0; i<nodeCount ; i++) {
			current = current.getNext();
			str += current.getVal();
			str += ",";
		}
		str += "]";
		System.out.println("The list is:" + str);
	}
	
	public static void main(String[] args) {
		CircularListCreate ls = new CircularListCreate();
		ls.addFront("1");
		ls.print();
		
		ls.deleteFront();
		ls.deleteBack();
		ls.print();
		
		ls.addFront("2");
		ls.addFront("3");
		ls.addBack("a");
		ls.print();
		
		ls.deleteFront();
		ls.print();
		
		ls.addBack("B");
		ls.print();
		
	}
	
	
}
