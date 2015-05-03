package CircularList;

interface Node {
	
	Object getVal();
	void setVal(Object dataVal);
	void setNext(Node n);
	Node getNext();
}
