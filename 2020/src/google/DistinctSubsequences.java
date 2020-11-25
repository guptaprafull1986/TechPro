package google;

import java.util.Arrays;

/**
 * Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.
 * <p>
 * Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).
 * <p>
 * Input Format:
 * <p>
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * Output Format:
 * <p>
 * Return an integer representing the answer as described in the problem statement.
 * Constraints:
 * <p>
 * 1 <= length(A), length(B) <= 700
 * Example :
 * <p>
 * Input 1:
 * A = "abc"
 * B = "abc"
 * <p>
 * Output 1:
 * 1
 * <p>
 * Explanation 1:
 * Both the strings are equal.
 * <p>
 * Input 2:
 * A = "rabbbit"
 * B = "rabbit"
 * <p>
 * Output 2:
 * 3
 * <p>
 * Explanation 2:
 * These are the possible removals of characters:
 * => A = "ra_bbit"
 * => A = "rab_bit"
 * => A = "rabb_it"
 * <p>
 * Note: "_" marks the removed character.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("abc", "abc"));
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String A, String B) {
        int m = B.length();
        int n = A.length();
        if (m > n) return 0;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {

                    char x = B.charAt(i - 1);
                    char y = A.charAt(j - 1);
                    if (x != y) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    }
                }
            }
        }

        printArray(dp);
        return dp[m][n];
    }

    private static void printArray(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int rec(String A, String B, int indexA, int indexB) {
        if (indexB == B.length())
            return 1;

        if (indexA == A.length())
            return 0;

        char x = A.charAt(indexA);
        char y = B.charAt(indexB);

        if (x == y) {
            return rec(A, B, indexA + 1, indexB + 1);
        } else {
            return rec(A, B, indexA + 1, indexB)
                    + rec(A, B, indexA, indexB + 1);
        }
    }
}

/*
0 0 r a b b i t
0 1 1 1 1 1 1 1
r 0 1 1 1 1 1 1
a 0 0 1
b 0
b 0
b 0
i 0
t 0


 */