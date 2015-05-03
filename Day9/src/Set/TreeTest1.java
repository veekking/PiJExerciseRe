package Set;

public class TreeTest1 {
	public static void main(String[] args) {
		TreeTest1 t1 = new TreeTest1();
		t1.launch();
	}
	
	public void launch() {
		InSet t1 = new AVLTreeSet();
		t1.add(1);
		t1.add(2);
		t1.add(3);
		t1.add(4);
		
		t1.add(5);
		t1.add(6);
		t1.add(7);
		t1.add(8);
		t1.add(9);
		t1.add(10);
		t1.add(11);
		
		System.out.println("The tree is: " + t1.toString());
	}
}
