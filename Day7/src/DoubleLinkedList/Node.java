package DoubleLinkedList;

public interface Node {
	
	Object  getValue(); 
	void setValue(Object dataVal);
	Node getNodeFront();
	Node getNodeBack();
	void setNodeFront(Node node);
	void setNodeBack(Node node);
	
}
