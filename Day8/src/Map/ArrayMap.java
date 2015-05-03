package Map;

/**
 * Example of a simple Map data structure with key and value. Utilizes a linked
 * list in the case multiple key-value pairs lead to the same bucket with same
 * hash code but with different keys (collisions).
 *
 * @author TellyTubbie
 */

public class ArrayMap implements MyMap {
	// make it simple - size is taken as 2^4
	private static final int SIZE = 16;
	private Entry table[] = new Entry[SIZE];

	class Entry {
		private final Integer key;
		private String value;
		private Entry next;

		Entry(Integer k, String v) {
			key = k;
			value = v;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Integer getKey() {
			return key;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see week9.MyMap#get(java.lang.String)
	 */
	//@Override
	public Entry get(Integer key) {
		int hash = key.hashCode() % SIZE;  //hashCode() returns the primitive int value
		Entry e = table[hash];

		// if bucket is found then traverse through the linked list and
		// see if element is present
		while (e != null) {
			if (e.getKey().equals(key)) {
				return e;
			}
			e = e.next;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see week9.MyMap#put(java.lang.String, java.lang.String)
	 */
	//@Override
	public void put(Integer key, String value) {
		int hash = computeHash(key);
		Entry e = table[hash];
		if (e != null) {
			// it means we are trying to insert duplicate
			// key-value pair, hence overwrite the current
			// pair with the old pair
			if (e.key.equals(key)) {
				e.value = value;
			} else {
				// traverse to the end of the list and insert new element
				// in the same bucket
				while (e.next != null) {
					e = e.next;
				}
				Entry entryInOldBucket = new Entry(key, value);
				e.next = entryInOldBucket;
			}
		} else {
			// new element in the map, hence creating new bucket
			Entry entryInNewBucket = new Entry(key, value);
			table[hash] = entryInNewBucket;
		}
	}

	private int computeHash(Integer key) {
		int hash = key.hashCode() % SIZE;
		System.out.println("Hash is " + hash);
		return hash;
	}
}