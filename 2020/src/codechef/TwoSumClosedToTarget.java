package codechef;

import java.util.Arrays;

public class TwoSumClosedToTarget {
    public static void main(String[] args) {
        int[] array1 = {1, 4, 13, 6, 23, 19}; // 1 4 6 13 19 23
        int[] array2 = {2, 4, 5, 1, 11, 21};  // 1 2 4 5 11 21
        int target = 19;
        Arrays.sort(array1);
        Arrays.sort(array2);

        int n1 = 0;
        int n2 = 0;
        int diff = Integer.MAX_VALUE;
        int left = 0;
        int right = array2.length - 1;

        while (left < array1.length && right >= 0) {
            int sum = array1[left] + array2[right];
            int currDiff = Math.abs(sum - target);
            if (currDiff < diff) {
                diff = currDiff;
                n1 = array1[left];
                n2 = array2[right];

                if (diff == 0) break;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println("[" + n1 + ", " + n2 + "]");
    }
}
