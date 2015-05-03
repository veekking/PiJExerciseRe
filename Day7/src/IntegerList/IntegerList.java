package IntegerList;

public class IntegerList {

    private IntegerNode first;

    public IntegerList() {
	  first = null;
    }

    public void add(int n) {
	  IntegerNode newNumber = new IntegerNode(n);
	  if (first == null) {
		first = newNumber;
		return;
	  }
	  IntegerNode aux = first; 
	  while (aux.getNext() != null) {
		aux = aux.getNext();
	  }
	  aux.setNext(newNumber);
    }

    public void prettyPrint() {
	  IntegerNode current = first;
	  while (current != null) {
		System.out.print(" " + current.getNumber());
		current = current.getNext();
	  }
	  System.out.println();
    }

    public static void main(String[] a) {
	  String str;
	  int next;
	  IntegerList list = new IntegerList();
	  do {
		System.out.print("Enter another number (end with 0): ");
		str = System.console().readLine();
		next = Integer.parseInt(str);
		list.add(next);
	  } while (next != 0);
	  list.prettyPrint();
    }
}
 
