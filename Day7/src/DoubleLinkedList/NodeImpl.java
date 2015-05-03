package DoubleLinkedList;

public class NodeImpl implements Node{
	private Object data;
	private Node pre;
	private Node next;
	
	NodeImpl(Object dataVal) {
		data = dataVal;
		pre = null;
		next = null;
	}
	
	public Object  getValue() {
		return data;
	}
	
	public void setValue(Object dataVal) {
		data = dataVal;
	}
	
	public Node getNodeFront() {
		return pre;
	}
	
	public Node getNodeBack() {
		return next;
	}
	
	public void setNodeFront(Node node) {
		pre = node;
	}
	
	public void setNodeBack(Node node) {
		next = node;
	}
	

}
