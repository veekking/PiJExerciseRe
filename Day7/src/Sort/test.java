package Sort;

import java.lang.Integer;

public class test {
	
	public static void main(String[] args) {
	
	// initiate a list by the array's default order
	Integer[] numList = new Integer[] {new Integer(300), new Integer(2), new Integer(1),
			new Integer(100), new Integer(200), new Integer(3)};
	
	ListUtilities nl = new ListUtilities(numList);
	nl.print();
	
	// bubble sort
	//nl.sortNode();
	//nl.print();
	
	nl.cocktailSort();
	nl.print();
	
	
	// test of add integer to sorted list
	Integer[] newArr = new Integer[] {new Integer(10), new Integer(2), new Integer(100), new Integer(-50)};
	SortedList sl = new SortedList(newArr);
	sl.print();
	
	sl.add(new Integer(15));
	sl.print();
	
	sl.add(new Integer(1000));
	sl.print();
	
	sl.add(new Integer(-10000));
	sl.print();
	System.out.println("The size of the list is: " + sl.size());

	}
	
	
	
}
