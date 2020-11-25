package _dynamicprogramming.longestcommonsubstring;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(maxSumIS(new int[]{5, 1, 2, 3, 4, 10, 5, 7}));
        System.out.println(maxSumISdp(new int[]{5, 1, 2, 3, 4, 10, 5, 7}));
        System.out.println(maxSumIS(new int[]{-4, 10, 3, 7, 15}));
        System.out.println(maxSumISdp(new int[]{-4, 10, 3, 7, 15}));
    }

    static int maxSumISdp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = arr[i] + dp[j];
                    max = Math.max(max, dp[i]);
                }
            }
        }

        /*for (int n : dp) {
            System.out.print(n + " ");
        }
        System.out.println();*/
        return max;
    }

    static int maxSumIS(int[] arr) {
        return maxSumISRec(arr, 0, -1);
    }

    static private int maxSumISRec(int[] arr, int current, int prev) {
        if (current == arr.length) {
            return 0;
        }
        int sum1 = 0;
        if (prev == -1 || arr[current] > arr[prev]) {
            sum1 = arr[current] + maxSumISRec(arr, current + 1, current);
        }
        int sum2 = maxSumISRec(arr, current + 1, prev);
        return Math.max(sum1, sum2);
    }
}

