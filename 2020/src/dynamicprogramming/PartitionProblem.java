package dynamicprogramming;

public class PartitionProblem {
    public static void main(String[] args) {
//        int[] arr = {7, 3, 1, 5, 4, 8};
        int[] arr = {3, 1, 1, 2, 2, 1};
        boolean isPartitioned = partition(arr);
        System.out.println("isPartitioned : " + isPartitioned);
    }

    private static boolean partition(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        // array sum is odd, so partition is impossible
        if ((dp[n - 1] & 1) == 1) return false;

        int target = dp[n - 1] >> 1;
        for (int i = 0; i < n; i++) {
            int sum = dp[n - 1] - arr[i];
            if (sum == target) return true;
        }
        return false;
    }
}
