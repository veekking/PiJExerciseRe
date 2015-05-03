import java.util.ArrayList;
import java.util.List;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(generate("abc"));
    }

    public static List<String> generate(String s) {

        List<String> perm = new ArrayList<>();
        if (s == null) { // error case
            return null;
        } else if (s.length() == 0) {
            perm.add(""); // initial
            return perm;
        }

        char initial = s.charAt(0); // first character
        String rem = s.substring(1); // Full string without first character

        List<String> words = generate(rem);
        for (String str : words) {
            for (int i = 0; i <= str.length(); i++) {
                perm.add(charinsert(str, initial, i));
            }
        }
        return perm;
    }

    public static String charinsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

}
