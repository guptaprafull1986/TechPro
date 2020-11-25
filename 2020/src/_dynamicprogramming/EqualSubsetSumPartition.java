package _dynamicprogramming;

public class EqualSubsetSumPartition {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 1, 3, 4, 7}));
        System.out.println(canPartition(new int[]{1, 2, 3, 4}));
        System.out.println(canPartition(new int[]{2, 3, 4, 6}));
    }

    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) return false;

        int capacity = sum >> 1;
        boolean[][] dp = new boolean[nums.length][capacity + 1];
//        return knapSackPartition(nums, capacity, 0);
        return knapSackDpIterative(nums, capacity);
    }

    private static boolean knapSackPartition(int[] nums, int sum, int index) {
        if (sum == 0) return true;
        if (index >= nums.length || sum < 0) return false;


        return knapSackPartition(nums, sum - nums[index], index + 1)
                || knapSackPartition(nums, sum, index + 1);
    }

    private static boolean knapSackDpIterative(int[] nums, int sum) {
        int m = nums.length;
        boolean[][] dp = new boolean[m + 1][sum + 1];

        for (int i = 0; i <= m; i++) {
            for (int c = 0; c <= sum; c++) {
                if (i == 0 || c == 0) {
                    dp[i][c] = true;
                } else if (dp[i - 1][c]) {
                    dp[i][c] = dp[i - 1][c];
                } else if (c >= nums[i - 1]) {
                    dp[i][c] = dp[i - 1][c - nums[i - 1]];
                }
            }
        }
        return dp[m][sum];
    }
}
