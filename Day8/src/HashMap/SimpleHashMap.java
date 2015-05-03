package HashMap;

public class SimpleHashMap {
	
	public static final int capacity = 16;
	MNode[] table = new MNode[16];
	
	void put(int key, String name) {
		MNode mn = new MNode(key, name);
		int hashCode = HashUtilities.shortHash(key);
		MNode e =  table[hashCode];
		if (e!=null) {
			while(e.getNext() != null) {
				if (e.getKey() == key) {e.setName(name); break;}
				e = e.getNext();
			}
			if (e.getKey() != key) {
				e.setNext(mn);
			} else {
				e.setName(name);
			}
			
		} else {
			table[hashCode] = mn;
		}
	}

	public String get(int key) {
		int hash = HashUtilities.shortHash(key);
		MNode e = table[hash];
		while (e!= null) {
			if (e.getKey() == key) return e.getName();
			e = e.getNext();
		}
		return null;
	}
	
	
	//void remove(int key, String name);
	
	
	//boolean isEmpty() {
		

		
}
