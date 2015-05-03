package Spy;

public interface Node {
	
	
	void setSpy(Object dataValue);
	Object getSpy();
	Node getNextSpy();
	void setNextSpy(Node spy);

}
