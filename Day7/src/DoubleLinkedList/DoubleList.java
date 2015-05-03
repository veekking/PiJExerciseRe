
/*
 * [3, 2, 1, a, bb, dd, ]
	[dd'bb'a'1'2'3']
	[2, 1, a, ] print()  if free the nodes from the deleteFront() wny??
	[bb'a'1'2'] printReverse

 */

/*
 * Create a double linked list
 * add Node from both  front and back
 * delete Node from both front and back
 * print and printReverse()
 */


package DoubleLinkedList;

import java.lang.String;

public class DoubleList {
	private Node head;
	private Node tail;
	public static int nodCount = 0;
	
	public DoubleList() {
		head = new NodeImpl(null);
		tail = new NodeImpl(null);
		head.setNodeBack(tail);
		tail.setNodeFront(head);
		
	}
	
	public DoubleList(Object[] arr) {
		head = new NodeImpl(null);
		tail = new NodeImpl(null);
		head.setNodeBack(tail);
		tail.setNodeFront(head);
		
		for(int i = 0; i<arr.length; i++) {
			addBack(arr[i]);
		}
	}
	
	public Node getHead() {
		return head;
	}
	
	public int size() {
		return nodCount;
	}
	/*
	 * Add a new Node at the beginning
	 */
	public void addFront(Object dataVal) {
		Node newNode = new NodeImpl(dataVal);
		newNode.setNodeBack(head.getNodeBack()); // 
		newNode.setNodeFront(head);
		head.getNodeBack().setNodeFront(newNode);
		head.setNodeBack(newNode);
		nodCount++;
	}
	
	/*
	 * Add a new Node at the end
	 */
	public void addBack(Object dataVal) {
		Node newNode = new NodeImpl(dataVal);
		newNode.setNodeFront(tail.getNodeFront());
		newNode.setNodeBack(tail);
		tail.getNodeFront().setNodeBack(newNode);
		tail.setNodeFront(newNode);
		nodCount++;
	}
	
	/*
	 * Delete node at the beginning
	 * but have to completely free the deleted Node
	 */
	public void deleteFront() {
		if (nodCount == 0) {
			System.out.println("Empty list.") ;
		} else {
			Node current = head.getNodeBack();
			head.setNodeBack(current.getNodeBack());
			current.getNodeBack().setNodeFront(head);
			current.setNodeFront(null);
			current.setNodeBack(null);
			nodCount--;
		}
	}
	
	/*
	 * Delete node at the end
	 * but have to completely free the deleted Node
	 */
	public void deleteBack() {
		if (nodCount == 0) {
			System.out.println("Empty List.");
		} else {
			Node current = tail.getNodeFront();
			tail.setNodeFront(current.getNodeFront());
			current.getNodeFront().setNodeBack(tail);
			current.setNodeBack(null);
			current.setNodeFront(null);
			nodCount--;
		}
	}
	
	/*
	 * Print in order
	 */
	public void print() {
		Node current = head.getNodeBack();
		String str = new String();
		
		if (nodCount == 0) {
			str = "Empty list";
		} else {
			str += "[";
			do {
				str += current.getValue().toString();
				str += ", ";
				current = current.getNodeBack();
			} while (current.getNodeBack() != null);
		str += "]";
		}
		System.out.println(str);	
	}
	
	/*
	 * Print in reverse order
	 */
	public void printReverse() {
		String str = new String();
		if (nodCount == 0 ) {
			str = "Empty list";
		} else {
			Node current = tail.getNodeFront();
			str += "[";
			do {
				str += current.getValue().toString();
				str += "'";
				current = current.getNodeFront();
			} while (current.getNodeFront() != null);
			str += "]";
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		DoubleList myList = new DoubleList();
		myList.addFront("1");
		myList.addBack("a");
		myList.addFront("2");
		myList.addFront("3");
		myList.addBack("bb");
		myList.addBack("dd");
		myList.print();
		myList.printReverse();
		
		myList.deleteFront();
		myList.deleteBack();
		myList.print();
		myList.printReverse();
		
	}
	
	
	
}
