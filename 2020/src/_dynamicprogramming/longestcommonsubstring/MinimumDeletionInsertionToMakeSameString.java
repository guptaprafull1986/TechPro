package _dynamicprogramming.longestcommonsubstring;

public class MinimumDeletionInsertionToMakeSameString {
    public static void main(String[] args) {
        minInsertDeleteToMakeSameString("geeksForGeKo", "geekssForrrGeeks");
    }

    private static void minInsertDeleteToMakeSameString(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println("min deletion : " + (m - dp[m][n]));
        System.out.println("min insertion : " + (n - dp[m][n]));
    }
}
