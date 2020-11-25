package _dynamicprogramming.longestcommonsubstring;

public class InterleavingString {

    public static void main(String[] args) {

    }

    boolean isInterleavingString(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int m = s1.length();
        int n = s2.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // for 0th row
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // for 0th col
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char x = s1.charAt(i - 1);
                char y = s2.charAt(j - 1);
                char z = s3.charAt(i + j - 1);
                if (x == z && y == z) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (x == z) {
                    dp[i][j] = dp[i - 1][j];
                } else if (y == z) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

