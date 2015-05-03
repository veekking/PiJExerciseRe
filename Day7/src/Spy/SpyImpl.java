package Spy;

public class SpyImpl implements Node{
	private Object data;
	private Node nextSpy;
	
	public SpyImpl(Object dataValue) {
		data = dataValue;
		nextSpy = null;
	}
	
	public void setSpy(Object dataValue) {
		data = dataValue;
	}
	
	public Object getSpy() {
		return data;
	}
	
	public Node getNextSpy() {
		return nextSpy;
	}


	public void setNextSpy(Node spy) {
		nextSpy = spy;
		
	}

}
