

package LinkedList;
public class NodeImpl implements Node {

	// data carried by this node.
	// could be of any type you need.
	private Object data;
	
	// reference to the next node in the chain,
	// or null if there isn't one.
	private Node next;

	// Node constructor  
	public NodeImpl(Object dataValue) {
		next = null;
		data = dataValue;
	}

	// another Node constructor if we want to
	// specify the node to point to.
	public NodeImpl(Object dataValue, Node nextValue) {
		next = nextValue;
		data = dataValue;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object dataValue) {
		data = dataValue;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node nextValue) {
		next = nextValue;
	}
}