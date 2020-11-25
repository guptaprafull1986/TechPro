package _dynamicprogramming.palindromicsubsequence;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
//        System.out.println(longestPalindromicSubsequence("abdbca"));
//        System.out.println(longestPalindromicSubsequence("abdbca"));
//        System.out.println(longestPalindromicSubsequence2("cddpd"));
//        System.out.println(longestPalindromicSubsequence2("cddpd"));

        System.out.println(lpsDP("abdbca"));
        System.out.println(lpsDP("abdda"));
//        System.out.println(lpsDP("cddpd"));
//        System.out.println(lpsDP("abcdab"));
//        System.out.println(lpsDP("BBABCBCAB"));
//        System.out.println(lpsDP("GEEKSFORGEEKS"));
    }

    static int longestPalindromicSubsequence(String str) {
        return lpsRec(str, 0, str.length() - 1);
    }

    private static int lpsRec(String str, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) return 1;

        if (str.charAt(start) == str.charAt(end)) {
            return 2 + lpsRec(str, start + 1, end - 1);
        }
        return Math.max(lpsRec(str, start, end - 1)
                , lpsRec(str, start + 1, end));
    }


    static int longestPalindromicSubsequence2(String str) {
        Integer[][] dp = new Integer[str.length()][str.length()];
        return lpsRecDp(str, 0, str.length() - 1, dp);
    }

    private static int lpsRecDp(String str,
                                int start, int end,
                                Integer[][] dp) {

        if (start > end) return 0;
        if (start == end) return 1;

        if (dp[start][end] != null) return dp[start][end];
        if (str.charAt(start) == str.charAt(end)) {
            dp[start][end] = 2 + lpsRecDp(str, start + 1, end - 1, dp);
        } else {
            dp[start][end] = Math.max(
                    lpsRecDp(str, start, end - 1, dp),
                    lpsRecDp(str, start + 1, end, dp)
            );
        }
        return dp[start][end];
    }

    static int lpsDP(String str) {
        int m = str.length();
        int[][] dp = new int[m][m];

        for (int i = 0; i < m; i++) {
            dp[i][i] = 1;
        }
        for (int start = m - 1; start >= 0; start--) {
            System.out.print(start + " >> ");
            for (int end = start + 1; end < m; end++) {
                System.out.print("(" + start + ", " + end + ")");
                if (str.charAt(start) == str.charAt(end)) {
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end],
                            dp[start][end - 1]);
                }
            }
            System.out.println();

            //print(dp, m);
        }
        char[] arr = new char[dp[0][m - 1]];
        int start = 0;
        int end = m - 1;

        int low = 0;
        int high = arr.length - 1;
        while (start <= end && start < m && end >= 0) {
            char x = str.charAt(start);
            char y = str.charAt(end);
            if (x == y) {
                arr[low++] = arr[high--] = x;
                start++;
                end--;
            } else if (dp[start + 1][end] > dp[start][end - 1]) {
                //arr[low++] = x;
                start++;
            } else {
                //arr[high--] = y;
                end--;
            }
        }

        print(dp, m, str);
        System.out.println(new String(arr));

        return dp[0][m - 1];
    }

    static void print(int[][] dp, int m, String str) {
        System.out.print("  ");
        for (char c : str.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int i = 0; i < m; i++) {
            System.out.print(str.charAt(i) + " ");
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*****************");
    }
}
