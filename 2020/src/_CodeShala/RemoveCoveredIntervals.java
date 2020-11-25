package _CodeShala;

import java.util.Arrays;
import java.util.Stack;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 2}, {1, 4}, {3, 4}
        };

        System.out.println(removeCoveredIntervals(arr));
    }

    public static int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            } else {
                return x[0] - y[0];
            }

        });

        Stack<int[]> stack = new Stack<>();
        for (int[] x : intervals) {
            if (stack.isEmpty() || isOuter(stack.peek(), x)) {
                stack.push(x);
            }
        }

        return stack.size();
    }

    static boolean isOuter(int[] x, int[] y) {
        if (y[0] >= x[0] && y[1] <= x[1]) return false;

        return true;
    }
}
