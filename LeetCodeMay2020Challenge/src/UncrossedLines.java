/**
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 * <p>
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 * <p>
 * A[i] == B[j];
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 * <p>
 * Return the maximum number of connecting lines we can draw in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
 * Example 2:
 * <p>
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * Output: 3
 * Example 3:
 * <p>
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 500
 * 1 <= B.length <= 500
 * 1 <= A[i], B[i] <= 2000
 */
public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(A, 0, B, 0, dp);
    }

    int helper(int[] A, int i, int[] B, int j, int[][] dp) {
        if (i == A.length || j == B.length) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int count = 0;

        if (A[i] == B[j]) {
            count = 1 + helper(A, i + 1, B, j + 1, dp);
        } else {
            count = Math.max(helper(A, i + 1, B, j, dp), helper(A, i, B, j + 1, dp));
        }
        dp[i][j] = count;

        return count;
    }
}
