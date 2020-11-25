package _techlead_coderpro;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    private static int fib(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int x = 0;
        int y = 1;

        for (int i = 3; i <= n; i++) {
            int temp = y;
            y = x + y;
            x = temp;
        }
        return y;
    }
}
