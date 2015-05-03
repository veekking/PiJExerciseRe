package Map;

import Map.ArrayMap.*;

public class MapDriver {
	public static void main(String[] args) {
		MyMap mm = new ArrayMap();

		mm.put(new Integer(6), "Betty");
		mm.put(new Integer(7), "Fred");
		mm.put(new Integer(3), "John");
		mm.put(new Integer(70), "Joe");
		mm.put(new Integer(3), "Esha"); //Esha overwrite John
		mm.put(new Integer(70), "ann"); //but ann doesn't overwrite Betty; 

		out(mm, new Integer(6));
		out(mm, new Integer(3));
		out(mm, new Integer(70));
	}

	private static void out(MyMap mm, Integer i){
		Entry e = mm.get(i);
		System.out.println(e.getValue());
	}
}
