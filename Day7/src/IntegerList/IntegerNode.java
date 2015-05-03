package IntegerList;

public class IntegerNode { 
    private int n; 
    private IntegerNode next;

    public IntegerNode(int n) {
	  this.n = n;
	  this.next = null;
    }

    public int getNumber() {
	  return n;
    }

    public IntegerNode getNext() {
	  return next;
    }

    public void setNext(IntegerNode n) {
	  this.next = n;
    }
}
