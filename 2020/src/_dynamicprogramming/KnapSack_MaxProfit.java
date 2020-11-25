package _dynamicprogramming;

/**
 * reference site
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RM1BDv71V60
 */
public class KnapSack_MaxProfit {

    public static void main(String[] args) {

        int[] weight = {2, 3, 1, 4};
        int[] profit = {4, 5, 3, 7};
        int capacity = 5;
//        int[] profit = {1, 6, 10, 16};
//        int[] weight = {1, 2, 3, 5};
//        int capacity = 7;
        System.out.println(maxProfit(weight, profit, capacity, 0));

        Integer[][] dp = new Integer[weight.length][capacity + 1];

        System.out.println(maxProfitDp(dp, weight, profit, capacity, 0));
        System.out.println(maxProfitDPIterative(weight, profit, capacity));
    }

    public static int maxProfit(int[] weight, int[] profit, int capacity, int index) {
        if (capacity <= 0 || index >= weight.length) {
            return 0;
        }

        int profit1 = 0;
        if (weight[index] <= capacity) {
            profit1 = profit[index] + maxProfit(weight, profit, capacity - weight[index], index + 1);
        }
        int profit2 = maxProfit(weight, profit, capacity, index + 1);
        return Math.max(profit1, profit2);
    }

    public static int maxProfitDp(Integer[][] dp, int[] weight, int[] profit, int capacity, int index) {
        if (capacity <= 0 || index >= weight.length) {
            return 0;
        }

        if (dp[index][capacity] != null) {
            return dp[index][capacity];
        }
        int profit1 = 0;
        if (weight[index] <= capacity) {
            profit1 = profit[index] + maxProfit(weight, profit, capacity - weight[index], index + 1);
        }
        int profit2 = maxProfit(weight, profit, capacity, index + 1);
        dp[index][capacity] = Math.max(profit1, profit2);
        return dp[index][capacity];
    }

    public static int maxProfitDPIterative(int[] weight, int[] profit, int capacity) {
        int m = weight.length;
        if (capacity <= 0 || m == 0) return 0;

        int[][] dp = new int[m + 1][capacity + 1];

        for (int w = 0; w <= m; w++) {
            for (int c = 0; c <= capacity; c++) {
                if (c == 0 || w == 0) {
                    dp[w][c] = 0;
                } else if (weight[w - 1] > c) {
                    dp[w][c] = dp[w - 1][c];
                } else {
                    dp[w][c] = Math.max(dp[w - 1][c], profit[w - 1] + dp[w - 1][c - weight[w - 1]]);
                }
            }
        }
        return dp[m][capacity];
    }

    public static int maxProfitDPIterative2(int[] weight, int[] profit, int K) {
        int m = weight.length;
        if (m == 0 || K == 0) return 0;

        int[][] dp = new int[m + 1][K + 1];

        for (int w = 1; w <= m; w++) {
            for (int c = 1; c <= K; c++) {
                if (weight[w - 1] <= c) {
                    dp[w][c] = Math.max(dp[w - 1][c],
                            profit[w - 1] + dp[w][c - weight[w - 1]]);
                } else {
                    dp[w][c] = dp[w - 1][c];
                }
            }
        }

        return dp[m][K];
    }


    int maxProfit(int[] weight, int[] profit, int capacity) {
        if (weight.length == 0) return 0;
        Integer[][] dp = new Integer[profit.length][capacity + 1];
        return maxProfitUtil(weight, profit, capacity, 0, dp);
    }

    int maxProfitUtil(int[] weight, int[] profit, int capacity, int index, Integer[][] dp) {
        if (capacity <= 0 || index >= weight.length) return 0;

        if (dp[index][capacity] != null) {
            return dp[index][capacity];
        }
        int profit1 = 0;
        if (weight[index] <= capacity) {
            profit1 = profit[index] +
                    maxProfitUtil(weight, profit, capacity - profit[index], index + 1, dp);
        }
        int profit2 = maxProfitUtil(weight, profit, capacity, index + 1, dp);

        dp[index][capacity] = Math.max(profit1, profit2);
        return dp[index][capacity];
    }

}
