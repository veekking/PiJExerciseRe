package HashMap;
import java.lang.Math;

public class HashUtilities {
	public static int shortHash(int hash) {
		return Math.abs(hash)%16;
	}

}
