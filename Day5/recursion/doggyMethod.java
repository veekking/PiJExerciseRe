import java.lang.String;

public class doggyMethod {
	public static void main (String[] args) {
		System.out.println(doggyMeth(8));
	}
	
	public static String doggyMeth(int n) {
		String result = doggyMeth(n-2) + n + doggyMeth(n-3);
		if (n<=0) {
			System.exit(0);
		}
		return result;
 	}

}
