package CircularList;

public class NodeImpl implements Node{
		private Object data;
		private Node next;
		
		NodeImpl(Object dataVal) {
			data = dataVal;
			next = null;
		}
		
		public Object getVal() {
			return data;
		}
		
		public void setVal(Object dataVal){
			data = dataVal;
		}
		
		public void setNext(Node n) {
			next = n;
		}
		
		public Node getNext(){
			return next;
		}
}
