package dynamicprogramming;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * Example:
 * <p>
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * Explanation: There is a subset (4, 5) with sum 9.
 * <p>
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * Explanation:  There is no subset that add up to 30.
 */
public class SubsetSumProblem {
    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    private static boolean isSubsetSum(int[] set, int n, int sum) {

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (set[i - 1] > j) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][sum - set[i - 1]];
                }
                /*if (set[i - 1] > j) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][sum - set[i - 1]];
                }*/
            }
        }
        return dp[n][sum];
    }
}
