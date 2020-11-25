package dynamicprogramming;

/**
 * Find minimum number of coins that make a given value
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
 * what is the minimum number of coins to make the change?
 * Examples:
 * <p>
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 * <p>
 * Input: coins[] = {9, 6, 5, 1}, V = 11
 * Output: Minimum 2 coins required
 * We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class MinimumCoinChange {
    public static void main(String[] args) {
        System.out.println(minimumCoinChange(new int[]{1, 5, 6, 8}, 11));
    }

    static int minimumCoinChange(int[] coins, int target) {
        int m = coins.length;
        int n = target;
        int[][] dp = new int[m][n + 1];

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                int top = i == 0 ? 0 : dp[i - 1][j];
                int left = j >= coins[i] ? dp[i][j - coins[i]] + 1 : 0;

                if (i == 0) {
                    dp[i][j] = left;
                } else {
                    dp[i][j] = left > 0 ? min(left, top) : top;
                }
            }
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m - 1][n];
    }

    private static int min(int x, int y) {
        return x <= y ? x : y;
    }
}
