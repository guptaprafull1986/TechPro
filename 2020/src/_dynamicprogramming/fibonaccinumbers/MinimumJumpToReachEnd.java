package _dynamicprogramming.fibonaccinumbers;

import java.util.Arrays;

public class MinimumJumpToReachEnd {
    public static void main(String[] args) {
        System.out.println(countMinJumpDp(new int[]{2, 1, 1, 1, 4}));
        System.out.println(countMinJumpDp(
                new int[]{1, 1, 3, 6, 9, 3, 0 , 1, 3}));
    }

    static int countMinJumpDp(int[] arr) {
        int[] dp = new int[arr.length];

        Arrays.fill(dp, 1, arr.length, Integer.MAX_VALUE);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length && j <= i + arr[i]; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        return dp[arr.length - 1];
    }

    static int minimumJumpRec(int[] arr, int index) {
        if (index == arr.length - 1) return 0;

        if (arr[index] == 0) return Integer.MAX_VALUE;

        int totalJump = Integer.MAX_VALUE;
        int start = index + 1;
        int end = index + arr[index];
        while (start < arr.length && start <= end) {
            int minJump = minimumJumpRec(arr, start++);
            if (minJump != Integer.MAX_VALUE) {
                minJump = Math.min(minJump + 1, totalJump);
            }
        }

        return totalJump;
    }
}
