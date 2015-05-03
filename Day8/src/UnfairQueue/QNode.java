package UnfairQueue;

public class QNode {
	private Integer val;
	private  QNode next;
	
	QNode(Integer val) {
		this.val = val;
		next = null;
	}
	
	Integer getVal() {
		return val;
	}
	
	void setVal(Integer n) {
		val = n;
	}
	
	QNode getNext() {
		return next;
	}
	
	void setNext(QNode nq) {
		next  = nq;
	}
	
}
