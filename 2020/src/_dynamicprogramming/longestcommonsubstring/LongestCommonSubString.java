package _dynamicprogramming.longestcommonsubstring;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "abdca";
        String s2 = "cbda";
        System.out.println(lcs(s1, s2));
        System.out.println(lcsDp(s1, s2));
    }

    static int lcsDp(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int m = s1.length();
        int n = s2.length();
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char x = s1.charAt(i - 1);
                char y = s2.charAt(j - 1);
                if (x == y) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    static int lcs(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        return lcsRec(s1, s2, 0, 0, 0);
    }

    static private int lcsRec(String s1, String s2, int index1, int index2, int count) {
        if (index1 >= s1.length() || index2 >= s2.length()) {
            return count;
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            count = lcsRec(s1, s2, index1 + 1, index2 + 1, count + 1);
        }
        int count2 = Math.max(lcsRec(s1, s2, index1 + 1, index2, 0),
                lcsRec(s1, s2, index1, index2 + 1, 0));

        return Math.max(count, count2);
    }
}
