/**
 * (This problem is an interactive problem.)
 * <p>
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 * <p>
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * Example 4:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= mat.length, mat[i].length <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in a non-decreasing way.
 */

import java.util.ArrayList;
import java.util.List;

public class LeftMostColumnWithOne {

    public static void main(String[] args) {
        LeftMostColumnWithOne obj = new LeftMostColumnWithOne();
        BinaryMatrix binaryMatrix = new BinaryMatrix();
        System.out.println(obj.leftMostColumnWithOne(binaryMatrix));
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimens = binaryMatrix.dimensions();
        int row = dimens.get(0);
        int col = dimens.get(1);

        int r = 0;
        int c = col - 1;
        int ans = col;
        int x = binaryMatrix.get(r, c);
        while (r < row - 1 && c > 0) {
            if (x == 0) {    // move to next row
                r++;
                x = binaryMatrix.get(r, c);
            } else {
                ans = c;
                int y = binaryMatrix.get(r, c - 1);
                int z = binaryMatrix.get(r + 1, c);
                if (y == 1) {
                    x = y;
                    c--;
                } else {
                    x = z;
                    r++;
                }
            }
        }

        if (c == 0) {
            if (binaryMatrix.get(r, c) == 1) return c;
        }

        if (r == row - 1) {

            int start = 0;
            int end = c;

            while (start <= end) {
                int mid = (start + end) / 2;
                int a = binaryMatrix.get(r, mid);
                if (a == 0) {
                    start = mid + 1;
                } else {
                    ans = mid;
                    end = mid - 1;
                }
            }
        }

        if (ans == col) return -1;

        return ans;
    }
}

class BinaryMatrix {
    int[][] matrix =
            {
                    {0, 0, 0, 0, 1, 1, 1, 1, 1},
                    {0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {0, 0, 0, 0, 1, 1, 1, 1, 1},
                    {0, 0, 0, 0, 0, 0, 1, 1, 1},
                    {0, 0, 0, 0, 0, 0, 0, 1, 1},
                    {0, 0, 0, 1, 1, 1, 1, 1, 1},
                    {0, 0, 0, 0, 1, 1, 1, 1, 1},
                    {0, 0, 0, 0, 1, 1, 1, 1, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1}
            };


    public List<Integer> dimensions() {
        List<Integer> dimen = new ArrayList<>();
        dimen.add(matrix.length);
        dimen.add(matrix[0].length);
        return dimen;
    }

    public int get(int r, int c) {
        return matrix[r][c];
    }
}