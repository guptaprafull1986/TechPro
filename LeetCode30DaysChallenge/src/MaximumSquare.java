/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 */
public class MaximumSquare {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        char[][] matrix1 = {{'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}};
        System.out.println(maximalSquare(matrix));
        System.out.println(maximalSquare(matrix1));
        System.out.println(maximalSquare(new char[][]{{'1'}}));
    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;

        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j - 1] == '1' && matrix[i - 1][j] == '1'
                            && matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    } else {
                        dp[i][j] = matrix[i][j] - '0';
                    }
                }

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return (int) Math.pow(max, 2);
    }
}
