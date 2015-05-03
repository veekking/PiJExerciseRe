package week10;

public class MyInterfaceDriver {
	public static void main(String[] args) {
		MyInterface my = new MyInterfaceImpl();
		my.myThing();
		my.myThingy();
	}
}
