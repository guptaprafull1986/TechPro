package _dynamicprogramming.fibonaccinumbers;

import java.util.Arrays;

public class StairCase {
    public static void main(String[] args) {
        System.out.println(countWays1(3));
        System.out.println(countWays1(4));
        System.out.println(countWays1(5));
        System.out.println(countWays2(3));
        System.out.println(countWays2(4));
        System.out.println(countWays2(5));
        System.out.println(countWays3(3));
        System.out.println(countWays3(4));
        System.out.println(countWays3(5));
        System.out.println(countWays4(3));
        System.out.println(countWays4(4));
        System.out.println(countWays4(5));


    }

    static int dp(int n) {
        if (n <= 1) return 1;

        int x = 1;
        int y = 1;
        for (int i = 2; i <= n; i++) {
            int temp = x + y;
            x = y;
            y = temp;
        }

        return y;
    }

    /**
     * recursive method start
     */
    static int countWays1(int n) {
        return countWaysRecursive(n);
    }

    static int countWaysRecursive(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
    }

    /**
     * recursive method end
     */

    /**
     * recursive dp method start
     */
    static int countWays2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countWaysRecursiveDp(n, dp);
    }

    static int countWaysRecursiveDp(int n, int[] dp) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (dp[n] != -1) return dp[n];

        dp[n] = countWaysRecursiveDp(n - 1, dp)
                + countWaysRecursiveDp(n - 2, dp)
                + countWaysRecursiveDp(n - 3, dp);

        return dp[n];
    }

    /**
     * recursive dp method end
     */

    static int countWays3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    /**
     * recursive dp method memory optimization
     */

    static int countWays4(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;

        int current = 2;
        int prev = 1;
        int prevPrev = 1;

        for (int i = 3; i <= n; i++) {
            int temp = current + prev + prevPrev;
            prevPrev = prev;
            prev = current;
            current = temp;
        }
        return current;
    }

}
