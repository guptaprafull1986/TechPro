package _leetcodegoogle;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{8, 10}, {15, 18}, {1, 3}, {2, 6}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });


        for (int[] x : intervals) {
            System.out.println(x[0] + ", " + x[1]);
        }
    }
}
