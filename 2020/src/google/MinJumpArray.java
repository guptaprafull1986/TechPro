package google;

/**
 * Given an array of non-negative integers, A, of length N, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Return the minimum number of jumps required to reach the last index.
 * <p>
 * If it is not possible to reach the last index, return -1.
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument contains an integer array, A.
 * Output Format:
 * <p>
 * Return an integer, representing the answer as described in the problem statement.
 * Constraints:
 * <p>
 * 1 <= N <= 1e6
 * 0 <= A[i] <= 50000
 * Examples:
 * <p>
 * Input 1:
 * A = [2, 1, 1]
 * <p>
 * Output 1:
 * 1
 * <p>
 * Explanation 1:
 * The shortest way to reach index 2 is
 * Index 0 -> Index 2
 * that requires only 1 jump.
 * <p>
 * Input 2:
 * A = [2,3,1,1,4]
 * <p>
 * Output 2:
 * 2
 * <p>
 * Explanation 2:
 * The shortest way to reach index 4 is
 * Index 0 -> Index 1 -> Index 4
 * that requires 2 jumps.
 */
public class MinJumpArray {

    public static void main(String[] args) {
        int[] arr = {33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37,
                15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0,
                39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27,
                23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0,
                39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39,
                0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14,
                22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25,
                0, 41, 2, 48, 28};
        int count = jump(arr);
        System.out.println("count " + count);
    }

    public static int jump(int[] A) {

        int[] dp = new int[A.length];

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == 0) return -1;

            if (A[i - 1] < A[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
                A[i] = A[i - 1] - 1;
            }
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        for (int i = 0; i < A.length; i++) {
            System.out.print(dp[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        return dp[A.length - 1];
    }

}
