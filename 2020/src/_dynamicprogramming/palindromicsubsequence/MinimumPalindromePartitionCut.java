package _dynamicprogramming.palindromicsubsequence;

public class MinimumPalindromePartitionCut {
    public static void main(String[] args) {

    }

    int MPP(String str) {
        int m = str.length();
        boolean[][] isPalindromMap = new boolean[m][m];

        for (int i = 0; i < m; i++) {
            isPalindromMap[i][i] = true;
        }

        for (int start = m - 2; start >= 0; start--) {
            for (int end = start + 1; end < m; end++) {
                if (str.charAt(start) == str.charAt(end)) {
                    isPalindromMap[start][end] =
                            isPalindromMap[start + 1][end - 1]
                                    || (end - start == 1);
                }
            }
        }

        int[] cuts = new int[m];

        return 0;
    }
}
