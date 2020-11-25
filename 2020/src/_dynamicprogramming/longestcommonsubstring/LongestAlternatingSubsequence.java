package _dynamicprogramming.longestcommonsubstring;

public class LongestAlternatingSubsequence {
    public static void main(String[] args) {

    }

    int las(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return Math.max(
                lasRec(arr, -1, 0, true),
                lasRec(arr, -1, 0, false)
        );
    }

    private int lasRec(int[] arr, int prev, int current, boolean isAsc) {
        if (current >= arr.length) return 0;

        int count = 0;
        if (isAsc) {
            if (prev == -1 || arr[prev] < arr[current]) {
                count = 1 + lasRec(arr, current, current + 1, false);
            }
        } else {
            if (prev == -1 || arr[prev] > arr[current]) {
                count = 1 + lasRec(arr, current, current + 1, true);
            }
        }
        int count2 = lasRec(arr, prev, current + 1, isAsc);
        int max = Math.max(count, count2);
        return max;
    }
}
