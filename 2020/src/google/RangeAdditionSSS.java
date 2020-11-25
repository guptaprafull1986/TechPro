package google;

import java.util.Arrays;

public class RangeAdditionSSS {
    public static void main(String[] args) {
        int length = 5;
        int[][] updates =
                {
                        {1, 3, 2},
                        {2, 4, 3},
                        {0, 2, -2},
                        {1, 4, -5},
                        {3, 2, 4}
                };

        getModifiedArray(length, updates);
        getModifiedArrayOptimization(length, updates);
    }

    public static void getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int value = updates[i][2];

            while (start <= end) {
                arr[start] += value;
                start++;
            }
        }

        for (int n :
                arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    /**
     * 0 0 0 0 0        0  1  2  3  4
     * {1, 3, 2}        0  2  0  0 -2
     * {2, 4, 3},       0  2  3  0 -2
     * {0, 2, -2}      -2  0  5  2 -2
     * -2 -2  3  5 3
     *
     * @param length
     * @param updates
     */
    public static void getModifiedArrayOptimization(int length, int[][] updates) {
        int[] arr = new int[length];

        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int value = updates[i][2];
            arr[start] += value;
            if (end < length - 1) {
                arr[end + 1] -= value;
            }
        }
        for (int i = 1; i < length; i++) {
            arr[i] += arr[i - 1];
        }
        for (int n :
                arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
