import java.util.Scanner;
import java.lang.String;
import java.lang.Character;


public class EmployeeFile {
	private static int capacity = 2;
	private String[] names = new String[capacity];
	private int[] IDs = new int[capacity];
	private int count = 0;
	
	EmployeeFile() { };
	
	/*
	 * Read employee names and IDs, untill the name is " ", or id = 0;
	 */
	public void readEmployee() {
		Scanner myScan = new Scanner(System.in);
		String name = new String();
		System.out.println("Let's start");
		int id = 0;
		while (true) {
			name = readName(myScan);
			if (name.equals(" ")) break;  //assign a variable first, and then validate
			id= readID(myScan);
			if (id==0) break;             //assign a variable first, and then validate
			updateEmployee(name, id);	
		}
	}
	
	
	private String readName(Scanner s) {
		String temp = new String();
		System.out.println("Please enter Employee Name: ");
		if (count!=0) temp = s.nextLine(); // make sure move the placeholder by one line
		temp =  s.nextLine();
		return temp;
	}
	
	private int readID(Scanner s) {
		System.out.println("Please enter Employee ID: ");
		while(!s.hasNextInt()) {
			System.out.println("Invalid input, try again.");
			s.next();    // make sure move the place holder;
		}
		return s.nextInt();
	}
	
	/*
	 * Wrapper function 
	 * make sure EmployName and EmployID always called in sequence
	 */
	private void updateEmployee(String nm, int idd) {
		EmployName(nm);
		EmployID(idd);
	}
	
	/*
	 * EmployName check the capacity and doulbe the size if reach the full capacity
	 * EmployName keep the count the same;
	 * EmployID increment the count
	 */
	private void EmployName(String str) {
		if (count == capacity) expandCapacity(); 
		names[count] = str;
	}
	
	private void EmployID(int n) {
		IDs[count] = n;
		count++;
	}
	
	/*
	 * Double the size of array
	 * copy all results to the new array
	 */
	private void expandCapacity() {
		capacity *= 2;
		String[] newName = new String[capacity];
		int[] newIDs = new int[capacity];
		for (int i=0; i<count; i++) {
			newName[i] = names[i];
			newIDs[i] = IDs[i];
		}
		names = newName;
		IDs = newIDs;
	}
	
	
	/* 
	 * Print names starts with 's', or even ID numbers
	 */
	public void print() {
		System.out.println("The employes name starts ");
		for (int i =0; i<count; i++) {
			if (Character.toLowerCase(names[i].charAt(0)) == 's') System.out.println(names[i] + ":" + IDs[i]);
		}
		System.out.println("The even number of IDs are");
		for (int i =0; i<count; i++) {
			if (IDs[i]%2 == 0) System.out.println(names[i] + ":" + IDs[i]);
		}
	}
	
	public static void main(String[] args) {
		EmployeeFile ep = new EmployeeFile();
		ep.readEmployee();
		ep.print();
	}
	
}
