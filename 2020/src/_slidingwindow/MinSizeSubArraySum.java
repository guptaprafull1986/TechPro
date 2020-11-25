package _slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinSizeSubArraySum {

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray(8, new int[] {3, 4, 1, 1, 6}));
        Map<Integer, Integer> map = new HashMap<>();
        Collections.min(map.values());
    }

    public static int findMinSubArray(int S, int[] arr) {
        int min = arr.length + 1;
        int start = 0;
        int windowSum = 0;
        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            while (windowSum >= S) {
                min = Math.min(min, end - start + 1);
                windowSum -= arr[start++];
            }
        }
        return min;
    }
}
