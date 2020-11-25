package _dynamicprogramming.unboundedKnapSack;

public class RodCutting {
    public static void main(String[] args) {

        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int n = 5;
        System.out.println(maxProfitRodCutting(lengths, prices, n));
    }

    static int maxProfitRodCutting(int[] lengths, int[] prices, int n) {
        if (n == 0) return 0;
        int m = prices.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int l = 1; l <= n; l++) {
                /*if (i == 0 || l == 0) dp[i][l] = 0;
                else */
                if (lengths[i - 1] > l) {
                    dp[i][l] = dp[i - 1][l];
                } else {
                    dp[i][l] = Math.max(dp[i - 1][l],
                            prices[i - 1] + dp[i][l - lengths[i - 1]]);
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }
}
