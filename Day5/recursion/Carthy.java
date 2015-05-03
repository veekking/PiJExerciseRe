
public class Carthy {
public static  void main (String[] args)  {
	System.out.println("The result is " + myCauthy91(105));
}

public static int myCauthy91(int n) {
	if (n<100)  {
		System.out.print(n-10); 
		return ( n-10);
	} else {
		return myCauthy91(myCauthy91(n+11));
	}
	}


}
