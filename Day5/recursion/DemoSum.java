public class DemoSum {
    public static void main(String[] args) {
        final int LIMIT = 1;
        System.out.println("Iterative version of sum");
        System.out.println("sum of numbers 10 to 1: " + sumIter(10));
        System.out.println("Recursive version of sum");
        System.out.println("sum of numbers 10 to 1: " + sumRecur(10));
    }

    private static int sumIter(int limit) {
        int sum = 0;
        for (int i = limit; i >= 1; i--)
            sum += i;
        return sum;
    }

    private static int sumRecur(int i) {
        if (i == 1) return i;
        return i + sumRecur(--i);
    }
}
