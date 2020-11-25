package _dynamicprogramming.unboundedKnapSack;

public class MaxProfit {
    public static void main(String[] args) {
        int[] weight = {1, 2, 3};
        int[] profit = {15, 20, 50};
        int c = 5;
        System.out.println(maxProfitRecursive(weight, profit, c, 0));
        System.out.println(maxProfitRecursiveDP(new Integer[profit.length][c + 1], weight, profit, c, 0));
        System.out.println(maxProfitDP(weight, profit, c));

        weight = new int[]{1, 3, 4, 5};
        profit = new int[]{15, 50, 60, 90};
        c = 8;
        System.out.println(maxProfitRecursive(weight, profit, c, 0));
        System.out.println(maxProfitRecursiveDP(new Integer[profit.length][c + 1], weight, profit, c, 0));
        System.out.println(maxProfitDP(weight, profit, c));
    }

    public static int maxProfitRecursive(int[] weight, int[] profit, int c, int index) {
        if (c <= 0 || index >= weight.length) return 0;

        int profit1 = 0;
        if (weight[index] <= c) {
            profit1 = profit[index] + maxProfitRecursive(weight, profit, c - weight[index], index);
        }

        int profit2 = maxProfitRecursive(weight, profit, c, index + 1);

        return Math.max(profit1, profit2);
    }

    public static int maxProfitRecursiveDP(Integer[][] dp, int[] weight, int[] profit, int c, int index) {
        if (c <= 0 || index >= weight.length) return 0;

        if (dp[index][c] != null) {
            return dp[index][c];
        }
        int profit1 = 0;
        if (weight[index] <= c) {
            profit1 = profit[index] + maxProfitRecursive(weight, profit, c - weight[index], index);
        }

        int profit2 = maxProfitRecursive(weight, profit, c, index + 1);

        dp[index][c] = Math.max(profit1, profit2);
        return dp[index][c];
    }

    public static int maxProfitDP(int[] weight, int[] profit, int C) {

        int m = weight.length;
        int[][] dp = new int[m + 1][C + 1];

        for (int i = 1; i <= m; i++) {
            for (int c = 1; c <= C; c++) {
                /*if (i == 0 || c == 0) {
                    dp[i][c] = 0;
                } else */
                if (weight[i - 1] > c) {
                    dp[i][c] = dp[i - 1][c];
                } else {
                    dp[i][c] = Math.max(dp[i - 1][c], profit[i - 1] + dp[i][c - weight[i - 1]]);
                }
            }
        }
        return dp[m][C];
    }
}
