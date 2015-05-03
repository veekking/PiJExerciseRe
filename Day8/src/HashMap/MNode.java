package HashMap;

public class MNode {
	private final int key; //key is non-amendable
	private String name;
	private MNode next;
	
	MNode(int key, String name) {
		this.key = key;
		this.name = name;
		next = null;
	}
	
	public int getKey() {
		return key;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNext(MNode MNode) {
		next = MNode;
	}
	
	public MNode getNext() {
		return next;
	}
	

}
