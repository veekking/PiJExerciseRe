package week10;

public interface MyInterface {
	String myThing();
	default String myThingy() {
		return("fixed");
	}
}
