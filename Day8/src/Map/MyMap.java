package Map;

import Map.ArrayMap.Entry;

/**
 * 
 * @author TellyTubbie
 *
 */
public interface MyMap {

	/**
	 * Retrieves the entry associated with the specified key
	 * 
	 * @param key
	 *            the key we wish to find
	 * @return the entry associated with the specified keyor null if the HashMap
	 *         contains no mapping for the key.
	 */
	Entry get(Integer key);

	/**
	 * Makes an entry for the specified value with the specified key in this
	 * map. If the map previously contained a mapping for the key, the old value
	 * is replaced.
	 * 
	 * @param key
	 *            The key of the entries
	 * @param value
	 *            The value we wish to associate with the key
	 */
	void put(Integer key, String value);

}