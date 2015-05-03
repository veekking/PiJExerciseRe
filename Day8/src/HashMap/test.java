package HashMap;

public class test {
	public static void main(String[] args) {
		test t1 = new test();
		t1.launchSimpleMap();
	}
	
	public void launchSimpleMap() {
		SimpleHashMap sm = new SimpleHashMap();
		sm.put(3, "Marry");
		sm.put(10, "John");
		sm.put(19, "Katy");
		
		System.out.println(sm.get(3));
		System.out.println(sm.get(19));
		
		sm.put(19,"me");
		System.out.println(sm.get(19));
		
		System.out.println(sm.get(100));
	}
}
