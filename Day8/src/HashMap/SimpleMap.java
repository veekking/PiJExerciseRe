package HashMap;

public interface SimpleMap {

	/*
	 * Put a new String in the map
	 * If the key is already in the map, nothing is done
	 */
	void put(int key, String name);
	
	/*
	 * Return the name associated with that key
	 * or null if there is none
	 */
	String get(int key);
	
	/*
	 * Remove a name from the map
	 */
	//void remove(int key, String name);
	
	/*
	 * returns true if there are no workers
	 */
	//boolean isEmpty();
	
}
