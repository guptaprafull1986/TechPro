package _dynamicprogramming.unboundedKnapSack;

public class MaximumCoinChange {
    public static void main(String[] args) {
        int[] coin = {1, 2, 3};
        int k = 5;
        System.out.println(coinChange(coin, k));
        System.out.println(countChangeRecursive(coin, k, 0));
    }

    static int coinChange(int[] coin, int k) {
        int m = coin.length;
        int[][] dp = new int[m + 1][k + 1];

       /* for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (coin[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i - 1]];
                }
            }
        }*/

        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= k; j++) {
                if (coin[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], 1 + dp[i][j - coin[i - 1]]);
                }
            }
        }

        return dp[m][k];
    }

    static int countChangeRecursive(int[] coins, int k, int index) {
        if (k == 0) {
            return 1;
        }
        if (k < 0) {
            return 0;
        }
        if (index >= coins.length) {
            return 0;
        }

        int count1 = 0;
        if (coins[index] <= k) {
            count1 = countChangeRecursive(coins, k - coins[index], index);
        }
        int count2 = countChangeRecursive(coins, k, index + 1);

        return count1 + count2;
    }
}
