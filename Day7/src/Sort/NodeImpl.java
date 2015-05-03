package Sort;

public class NodeImpl implements Node{
	Object data;
	Node next;
	
	NodeImpl(Object dataVal) {
		data = dataVal;
		next = null;
	}
	
	public Object getVal(){
		return data;
	}
	
	public void setVal(Object dataVal){
		data = dataVal;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node n) {
		next = n;
	}
}
