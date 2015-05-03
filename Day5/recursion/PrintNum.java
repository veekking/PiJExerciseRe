
public class PrintNum {
	public static void main(String[] args) {
		printNumers(6);
	}
	
	public static void printNumers(int n){
		if (n<=0) return;
		System.out.println(n);
		printNumers(n-2);
		printNumers(n-3);
		System.out.println(n);
	}

}
