package Queue;

public class PersonImpl {
	private Object data;
	private PersonImpl next;  // can use either Person or PersonImpl
	
	PersonImpl(Object dataVal) {
		data = dataVal;
		next = null;
	}
	
	public Object getVal() {
		return data;
	}
	
	public void setVal(Object dataVal) {
		data = dataVal;
	}
	
	public PersonImpl getNext() {
		return next;
	}
	
	void setNext(PersonImpl p) {
		next = p;
	}
}
