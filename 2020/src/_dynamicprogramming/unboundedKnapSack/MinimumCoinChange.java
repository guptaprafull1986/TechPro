package _dynamicprogramming.unboundedKnapSack;

import java.util.Arrays;

public class MinimumCoinChange {
    public static void main(String[] args) {
        int[] coin = {1, 2, 5};
        int k = 11;
        int min = minCoinChange(coin, k);
        System.out.println(min);
        System.out.println(minCoinDpBottomUp(coin, k));
    }

    private static int minCoinDpBottomUp(int[] coin, int K) {
        if (coin.length == 0) return -1;
        int n = coin.length;
        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < n; j++) {
                if (coin[j] <= i) {
                    int diff = dp[i - coin[j]];
                    if (diff != Integer.MAX_VALUE) {
                        dp[i] = Math.min(diff + 1, dp[i]);
                    }
                }
            }
        }

        for(int i = 0; i <= K; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[K] == Integer.MAX_VALUE ? -1 : dp[K];
    }

    private static int minCoinChange(int[] coin, int k) {
        Integer[][] dp = new Integer[coin.length][k + 1];
        int min = minCoinChangeDP(coin, k, 0, dp);
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private static int minCoinChangeDP(int[] coin, int k, int index, Integer[][] dp) {
        if (k == 0) return 0;

        if (coin.length == 0 || index >= coin.length) return Integer.MAX_VALUE;

        if (dp[index][k] != null) return dp[index][k];
        int count1 = Integer.MAX_VALUE;
        if (coin[index] <= k) {
            int result = minCoinChangeDP(coin, k - coin[index], index, dp);
            if (result != Integer.MAX_VALUE) {
                count1 = 1 + result;
            }
        }
        int count2 = minCoinChangeDP(coin, k, index + 1, dp);
        dp[index][k] = Math.min(count1, count2);
        return dp[index][k];
    }
}
