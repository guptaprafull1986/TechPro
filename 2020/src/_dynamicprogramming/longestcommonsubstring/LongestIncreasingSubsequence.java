package _dynamicprogramming.longestcommonsubstring;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lis(new int[]{4, 2, 3, 6, 10, 1, 12}));
        System.out.println(lisDP(new int[]{4, 2, 3, 6, 10, 1, 12}));
        System.out.println(lis(new int[]{4, 2, 3, 6, 10, 1, 5}));
        System.out.println(lisDP(new int[]{4, 2, 3, 6, 10, 1, 5}));

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    static int lisDP(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    static int lis(int[] arr) {
        int m = arr.length;
        Integer[][] dp = new Integer[m][m + 1];
        return lisRec(arr, 0, -1, dp);
    }

    private static int lisRec(int[] arr, int current, int prev, Integer[][] dp) {
        if (current == arr.length) return 0;

        if (dp[current][prev + 1] != null) {
            return dp[current][prev + 1];
        }
        int count1 = 0;
        if (prev == -1 || arr[current] > arr[prev]) {
            count1 = 1 + lisRec(arr, current + 1, current, dp);
        }
        int count2 = lisRec(arr, current + 1, prev, dp);
        dp[current][prev + 1] = Math.max(count1, count2);
        return dp[current][prev + 1];
    }

    static public boolean isPalindrome(String s) {
        if (s == null) return false;

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char x = s.charAt(start);
            char y = s.charAt(end);
            boolean isXValid = isValid(x);
            boolean isYValid = isValid(y);
            if (isXValid && isYValid) {
                if (x == y || ((x ^ 32) == y)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            } else {
                if (!isXValid) start++;
                if (!isYValid) end--;
            }
        }

        return true;
    }

    static boolean isValid(char c) {
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) ||
                (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}
