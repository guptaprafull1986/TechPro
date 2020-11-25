import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersactions {
    public static void main(String[] args) {
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] result = intervalIntersection(A, B);

        for (int[] x :
                result) {
            System.out.println(x[0] + " " + x[1]);
        }
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        int m = A.length;
        int n = B.length;
        List<int[]> list = new ArrayList<>();

        while (i < m && j < n) {
            int[] x = A[i];
            int[] y = B[j];

            // no intersection
            if (x[1] < y[0] || y[1] < x[0]) {
                if (x[1] <= y[1]) {
                    i++;
                } else {
                    j++;
                }
            } else {    // intersection exist
                int low = x[0] <= y[0] ? y[0] : x[0];
                int high;
                if (x[1] == y[1]) {
                    high = x[1];
                    i++;
                    j++;
                } else if (x[1] < y[1]) {
                    high = x[1];
                    i++;
                } else {
                    high = y[1];
                    j++;
                }
                list.add(new int[]{low, high});
            }

        }

        int[][] result = new int[list.size()][];
        int index = 0;
        for (int[] x :
                list) {
            result[index++] = x;
        }

        return result;
    }
}
