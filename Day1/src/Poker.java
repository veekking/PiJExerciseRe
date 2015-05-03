import java.util.Random;
import UtilPack.Util;

public class Poker{
    public static void main(String[] args) {
        int[] arr = Util.RandIntArr(1, 10, 5);
        
        for (int i = 0; i<5; i++) {
            System.out.println(arr[i]);
        }
    }
}
