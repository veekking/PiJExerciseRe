
public class myPow {
	public static void main(String[] args) {
		System.out.println("The result is: " + calPow(2,10));
		
	}
	
	public static int calPow(int base, int power) {
		if (power==1) {
			return base;
		} else {
			return base*calPow(base, power-1);
		}
	}

}
