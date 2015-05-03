package Queue;

public interface Person {
	
	Object getVal();
	
	void setVal(Object data);
	
	PersonImpl getNext();
	
	void setNext(Person p);
}
