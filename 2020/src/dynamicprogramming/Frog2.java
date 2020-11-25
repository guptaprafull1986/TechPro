package dynamicprogramming;

import java.util.Scanner;

public class Frog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(execute(arr, n, k));
        sc.close();
    }

    private static int execute(int[] arr, int n, int k) {

        int[] dp = new int[n];
        dp[0] = 0;

        dp[1] = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < n; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (i - 1 - j < 0) break;
                int val = dp[i - 1 - j] + Math.abs(arr[i] - arr[i - 1 - j]);
                if (val < min) {
                    min = val;
                }
            }

            dp[i] = min;

        }
        return dp[n - 1];
    }
}
