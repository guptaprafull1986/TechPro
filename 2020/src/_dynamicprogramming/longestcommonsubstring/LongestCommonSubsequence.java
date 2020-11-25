package _dynamicprogramming.longestcommonsubstring;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(lcs("abdca", "cbda"));
    }

    static int lcsDP(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        if (s1.length() == 0 || s2.length() == 0) return 0;
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        int maxLength = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                char x = s1.charAt(i - 1);
                char y = s2.charAt(j - 1);
                if (x == y) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength;
    }

    static int lcs(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        if (s1.length() == 0 || s2.length() == 0) return 0;

        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return rec(s1, s2, 0, 0, dp);
    }

    static int rec(String s1, String s2, int i, int j, Integer[][] dp) {

        if (i >= s1.length() || j >= s2.length()) return 0;

        if (dp[i][j] == null) {
            int count = 0;
            if (s1.charAt(i) == s2.charAt(j)) {
                count = 1 + rec(s1, s2, i + 1, j + 1, dp);
            } else {
                int c1 = rec(s1, s2, i + 1, j, dp);
                int c2 = rec(s1, s2, i, j + 1, dp);
                count = Math.max(c1, c2);
            }
            dp[i][j] = count;
        }
        return dp[i][j];
    }
}
